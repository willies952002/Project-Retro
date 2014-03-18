package tk.willies952002.java.games.util.multiplayer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {

	static Socket socket;
	private static DataInputStream dataInput;
	private static DataOutputStream dataOutput;
	protected static int clientID;
	
	public Client(String addr, int port) throws Exception {
		socket = new Socket(addr, port);
	}

	public static void initialize() throws Exception {
		System.out.println("Starting Client...");
		dataInput = new DataInputStream(socket.getInputStream());
		dataOutput = new DataOutputStream(socket.getOutputStream());
		Input input = new Input(dataInput);
		Thread thread = new Thread(input);
		thread.start();
	}

	public static DataOutputStream getDataOutput() {
		return dataOutput;
	}

	public static DataInputStream getDataInput() {
		return dataInput;
	}

}
