package tk.willies952002.java.game.util.multiplayer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.rmi.ServerError;

import tk.willies952002.java.util.ServerCommand;

public class User implements Runnable {

	DataInputStream input;
	DataOutputStream output;
	User[] onlineUsers = new User[Server.getServerProperties().getMaxConnections()];
	private int userID;

	public User(DataInputStream in, DataOutputStream out, User[] users, int id) {
		input = in;
		output = out;
		onlineUsers = users;
		userID = id;
	}

	@Override
	public void run() {
		while (true) {
			
			try {
				//Interperate Data From The Client
				int cmd = input.readInt();
				switch ( ServerCommand.getByID(cmd) ) {
					case CONNECT_REQ: connectClient();
					default: 
						output.writeInt(ServerCommand.UNKNOWN.getCmdID());
						output.writeInt(ServerCommand.DIR_MSG.getCmdID());
						output.writeUTF("YOUR CLIENT HAS INVOKED AN UNKOWN SERVER COMMAND,\n MOST LIKELY RESULTING IN THE SERVER CRASHING!!! GOOD JOB ASS HOLE...");
						output.writeInt(ServerCommand.COMPLETE.getCmdID());
						throw new ServerError("Unknown Server Command", new Error());
				}
				
			} catch (Exception e) {
				if ( e instanceof ServerError ) {e.printStackTrace(); System.out.println("WOOPS!!!...\nIts Seems that a client sent an unknown server command and something went wrong");}
				e.printStackTrace();
			}
			finally {
				onlineUsers[userID] = null;
			}
		}

	}

	private void connectClient() throws Exception {
		output.writeInt(ServerCommand.CONNECT_GOOD.getCmdID());
		output.writeInt(ServerCommand.SET_UUID.getCmdID());
		output.writeInt(userID);
		output.writeInt(ServerCommand.COMPLETE.getCmdID());
	}

}
