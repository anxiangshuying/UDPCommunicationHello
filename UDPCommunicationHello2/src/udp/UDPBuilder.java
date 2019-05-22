package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

class UDPClientBuilder extends UDPRWText{
	InetSocketAddress isA;
	DatagramSocket s;
	DatagramPacket req, rep;
	final int size = 2048;
	int timer = 3000;

	UDPClientBuilder() {
		isA = null;
		s = null;
		req = rep = null;
	}

	protected void setConnection() throws IOException {
		isA = new InetSocketAddress("172.24.31.167",8080);
		s = new DatagramSocket(); 
		s.setSoTimeout(timer);
		/** we can include more setting, later бн */ 
	}
}


class UDPServerBuilder  extends UDPRWText{
	InetSocketAddress isA;
	DatagramSocket s;
	DatagramPacket req, rep;
	final int size = 2048;
	int timer = 3000;

	UDPServerBuilder() {
		isA = null;
		s = null;
		req = rep = null;
	}

	protected void setConnection() throws IOException {
		isA = new InetSocketAddress("localhost",8080); 
		s = new DatagramSocket(isA.getPort());
		//s.setSoTimeout(timer);
	}
}