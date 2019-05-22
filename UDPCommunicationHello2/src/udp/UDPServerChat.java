package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.util.Scanner;

/*
public class UDPServerMsg extends UDPServerBuilder implements Runnable{
	  private String msg;
	  public void run() {
	    try {
	      setConnection();
	      System.out.println("waiting ...."); 
	      s.receive(req); 
	      msg = getMsg(req);
	      System.out.println(msg);
	    }
	    catch (Exception localException)
	    {
	      this.s.close(); System.out.println("IOException UDPServer");
	    }
	  }

}*/

class UDPServerChat extends UDPServerBuilder implements Runnable {
	private Scanner sc;
	private String msg;

	public void run() {
		try {
			setConnection();
			req = new DatagramPacket(new byte[size], size);
			s.receive(req);
			// socketInfo("client sets the connection", s);
			System.out.printf("%s", getMsg(req));
            
			sc = new Scanner(System.in);
			while (msg != "end") {
				rep = new DatagramPacket(new byte[size], 0, size, req.getSocketAddress());
				msg = sc.nextLine();
				setMsg(rep, msg);
				s.send(rep);
				// socketInfo("client closes the connection", s);
				req = new DatagramPacket(new byte[size], size);
				s.receive(req);
				// socketInfo("client sets the connection", s);
				msg=getMsg(req);
				System.out.println();
				System.out.printf("%s", msg);
			}
			sc.close();
			s.close();
		} catch (IOException e) {
			System.out.println("IOException UDPServer");
		}
	}
}
