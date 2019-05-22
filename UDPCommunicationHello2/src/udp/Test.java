package udp;

public class Test {
	public static void testHello(){
		//new Thread(new UDPClientHello()).start();
		new Thread(new UDPServerHello()).start();
		
	}
	public static void testInfo(){
		new Thread(new UDPClientInfo()).start();
	    new Thread(new UDPServerInfo()).start();
	}
	public static void testTimeout(){
		//new Thread(new UDPClientTimeout()).start();
		new Thread(new UDPServerTimeout()).start();
	}
	
	public static void testChat(){
		//new Thread(new UDPClientChat()).start();
		new Thread(new UDPServerChat()).start();
	}

	public static void main(String[] args) {
		//testHello();
		//testTimeout();
		testChat();
	}

}
