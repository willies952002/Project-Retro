package tk.willies952002.java.games.util.multiplayer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

public class ServerProperties extends Properties {

	private static final long serialVersionUID = 294950204819110844L;
	
	public static final String MAX_CONNECTIONS = "connections";
	public static final String String = "String";
	
	public ServerProperties() {
		File propFile = new File(System.getProperty("user.dir"), "server.properties");
		try {
			System.out.println("Reading Server Properties...");
			if ( propFile.createNewFile() ) {
				System.err.println("Server Properties File Not Found!!!");
				System.err.println("One Has Been Created In Its Place...");
				this.setProperty(MAX_CONNECTIONS, "10");
				this.store(new FileWriter(propFile), "");
				System.out.println("Default Values Stored...");
			}
			load(new FileReader(propFile));
			System.out.println("Loaded Server Properties...");
		}
		catch (Exception e) {  }
	}
	
	public int getMaxConnections() {
		return Integer.parseInt(getProperty(MAX_CONNECTIONS), 10);
	}

}
