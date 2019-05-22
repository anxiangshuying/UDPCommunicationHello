package udp;

import java.io.IOException;

class UDPServerInfo extends UDPClientBuilder implements Runnable {
	public void run() {
		try {
			setConnection();
			socketInfo("client sets the connection", s);
			s.close();
			socketInfo("client closes the connection", s);
		} catch (IOException e) {
			System.out.println("IOException UDPClient");
		}
	}
}