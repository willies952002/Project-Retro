package tk.willies952002.java.util;

import java.rmi.ServerError;

public enum ServerCommand {

	UNKNOWN(0, "Unknown Command"), //Command Received is Unknown
	CONNECT_REQ(200, "Connection Requested"), //Client Is Requesting To Connect To The Server
	CONNECT_GOOD(201, "Connection Successfull"), //Server Response That A Connection Has Been Established
	SET_UUID(202, "Set Unique User ID"), //Set The UUID Of The Client Connected To The Server
	DIR_MSG(9998, "Direct Message"), //Used To Send DIRECT, RAW UTF-8 Data To The Client.
	COMPLETE(9999, "Complete"); //Two Way Response Signaling That Data Transition Is Complete 
	
	
	private int commandID;
	private String message;
	
	ServerCommand(int cmdID, String msg) {
		commandID = cmdID;
		message = msg;
	}
	
	public int getCmdID() {
		return commandID;
	}
	
	public String getCmdMsg() {
		return message;
	}

	public static ServerCommand getByID(int cmd) throws ServerError {
		switch ( cmd ) {
			case 100: return CONNECT_REQ;
			case 200: return CONNECT_GOOD;
			default: return UNKNOWN;
		}
	}
	
}
