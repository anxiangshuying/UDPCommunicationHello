package udp;

import java.io.IOException;
import java.net.DatagramPacket;

class UDPClientHello extends UDPClientBuilder implements Runnable {
	public void run() {
		try {
			this.setConnection();
			req = new DatagramPacket(new byte[size],0,size,isA.getAddress(),isA.getPort()); 
			s.send(req);
			System.out.println("request sent");
			rep = new DatagramPacket(new byte[size],size); 
			s.receive(rep);
			System.out.println("reply received");
			s.close();
		} catch (IOException e) {
			System.out.println("IOException UDPClient ");
		}
	}
}

class UDPServerHello extends UDPServerBuilder implements Runnable{
	public void run() {
		try {
			this.setConnection();
			req = new DatagramPacket(new byte[size], size);
			s.receive(req);
			System.out.println("request received");
			rep = new DatagramPacket(new byte[size], 0, size, req.getSocketAddress());
			s.send(rep);
			System.out.println("reply sent");
			s.close();
		} catch (IOException e) {
			System.out.println("IOException UDPServer ");
		}
	}
}
