package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;

class UDPClientTime extends UDPClientBuilder implements Runnable {
	private long sTime;

	/** The main run method for threading. */
	public void run() {
		try {
			setConnection();
			// send a packet to server which include timestamp
			req = new DatagramPacket(new byte[size], 0, size, isA.getAddress(), isA.getPort());
			setTimeStamp(req);
			s.send(req);
			System.out.println("request sent");
			System.out.println("Thread sleep");
			// make the thread sleep 5 second
			Thread.sleep(5000);
			// recieve response from server which include timestamp
			rep = new DatagramPacket(new byte[size], size);
			s.receive(rep);
			sTime = this.getTimeStamp(rep);
			System.out.println("reply received:" + sTime);
			s.close();
		} catch (IOException e) {
			System.out.println("IOException UDPClient ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}