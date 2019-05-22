package udp;

import java.io.IOException;
import java.net.DatagramPacket;

public class UDPClientTimeout extends UDPClientBuilder implements Runnable{
	@Override
	public void run() {
		try{
			this.setConnection();
			req = new DatagramPacket(new byte[size],0,size,isA.getAddress(),isA.getPort()); 
			s.send(req);
			System.out.println("request sent");
			s.close();
		}catch(IOException e){
			
		}
		
	}
}
