package udp;

public class UDPServerTime extends UDPServerBuilder implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}

class UDPServerNTP extends UDPServerBuilder implements Runnable {
	/** The main run method for threading. */
	public void run() {
		try {
			this.setConnection();
			// recieve request from client
			req = new DatagramPacket(new byte[size], size);
			s.receive(req);
			System.out.println("request received");
			// send reply to client
			rep = new DatagramPacket(new byte[size], 0, size, req.getSocketAddress());
			s.send(rep);
			System.out.println("reply sent");
			s.close();
		} catch (IOException e) {
			System.out.println("IOException UDPServer ");
		}
	}
}