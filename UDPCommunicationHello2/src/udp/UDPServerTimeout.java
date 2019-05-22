package udp;

import java.io.IOException;
import java.net.DatagramPacket;

public class UDPServerTimeout extends UDPServerBuilder implements Runnable{

	@Override
	public void run() {
		try {
			this.setConnection();
			req = new DatagramPacket(new byte[size], size);
			s.receive(req);
			System.out.println("request received");
			s.close();
		} catch (IOException e) {
			System.out.println("IOException UDPServer ");
		}
		
	}

}
