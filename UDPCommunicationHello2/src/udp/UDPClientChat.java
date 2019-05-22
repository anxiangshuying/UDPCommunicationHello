package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.util.Scanner;




class UDPClientChat extends UDPClientBuilder implements Runnable{
	
	  private Scanner sc;
	  public void run() {
			try {
				sc = new Scanner(System.in);
				String msg = sc.nextLine();
				sc.close(); 
				
			setConnection();
			
			req=getTextSendingPacket(isA,msg,size);
			s.send(req);
			//socketInfo("client sets the connection",s);
			 rep = new DatagramPacket(new byte[size],size);
			 s.receive(rep);
			System.out.printf("%s", getMsg(rep));
			s.close(); 
			//socketInfo("client closes the connection",s);
			}
			catch(IOException e)
			{ System.out.println("IOException UDPClient"); }
			}
	  
}


/*
public class UDPClientMsg extends UDPClientBuilder implements Runnable{
	  private String msg;
	  private int number = 1024;

	  public void run() {
	    try {
	      this.setConnection();
	      req = getTextSendingPacket(isA,msg,number); 
	      setMsg(req, "hello guy"); 
	      s.send(req);
	      s.close();
	    }
	    catch (Exception localException) {
	      System.out.println("IOException UDPClient");
	    }
	  }

}*/
