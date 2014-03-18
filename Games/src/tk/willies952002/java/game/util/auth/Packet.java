package tk.willies952002.java.game.util.auth;

public abstract class Packet {

	int packetID;
	
	public Packet() {
	}
	
	public int getPacketID() {
		return packetID;
	}
	
	/**
	 * @param The Data To Store In The Packet
	 */
	public abstract void setData(/**Parameters*/);
	
	/**
	 * @return The Data Stored Inside the Pakcet
	 */
	public abstract void getData();
	
}
