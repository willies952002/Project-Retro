package tk.willies952002.java.game.util.auth;

import tk.willies952002.java.game.util.multiplayer.Client;
import tk.willies952002.java.util.ServerCommand;
import tk.willies952002.java.util.auth.Password;

public class LoginClient extends Client {
	
	private static String sessionID;

	
	public LoginClient(String addr, int port) throws Exception {
		super(addr, port);
		LoginClient.initialize();
	}
	
	public void authenticate(String uname, Password pass) {
		try {
			System.out.println(ServerCommand.CONNECT_REQ.getCmdID() + " - " + ServerCommand.CONNECT_REQ.getCmdMsg());
			Client.getDataOutput().writeInt(ServerCommand.CONNECT_REQ.getCmdID());
			if ( Client.getDataInput().readInt() == ServerCommand.CONNECT_GOOD.getCmdID() ) {
				System.err.println(ServerCommand.CONNECT_GOOD.getCmdID() + " - " + ServerCommand.CONNECT_GOOD.getCmdMsg());
				if ( Client.getDataInput().readInt() == ServerCommand.SET_UUID.getCmdID() ) {
					System.out.println(ServerCommand.SET_UUID.getCmdID() + " - " + ServerCommand.SET_UUID.getCmdMsg());
					clientID = Client.getDataInput().readInt();
					if ( Client.getDataInput().readInt() == ServerCommand.COMPLETE.getCmdID() ) {
						System.out.println(ServerCommand.COMPLETE.getCmdID() + " - " + ServerCommand.COMPLETE.getCmdMsg());
						System.out.println("Client ID: " + Client.clientID);
					}
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getSessionID() {
		return sessionID;
	}

}
