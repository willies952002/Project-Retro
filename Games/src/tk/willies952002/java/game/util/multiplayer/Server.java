package tk.willies952002.java.game.util.multiplayer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	static ServerSocket serverSocket;
	static Socket socket;
	static DataInputStream input;
	static DataOutputStream output;
	static int serverPort;
	static ServerProperties props = new ServerProperties();
	static User[] onlineUsers = new User[props.getMaxConnections()];
	
	public Server(int port) throws Exception {
		serverPort = port;
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Starting Server...");
		serverSocket = new ServerSocket(serverPort);
		System.out.println("Server Started...");
		System.out.println("Now Accepting Users...");
		while ( true ) {
			socket = serverSocket.accept();
			for ( int i = 0; i < props.getMaxConnections(); i++ ) {
				System.out.print("Connection From: " + socket.getInetAddress());
				System.out.println(" at port: " + socket.getPort());
				input = new DataInputStream(socket.getInputStream());
				output = new DataOutputStream(socket.getOutputStream());
				if ( onlineUsers[i] == null ) {
					onlineUsers[i] = new User(input, output, onlineUsers, i);
					Thread thread = new Thread(onlineUsers[i]);
					thread.start();
					break;
				}
			}
		}
	}
	
	public static ServerProperties getServerProperties() {
		return props;
	}
	
	//TODO Do Something With The Data From The Clients

}
