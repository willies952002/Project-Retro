package tk.willies952002.java.game.util.multiplayer;

import java.io.DataInputStream;
import java.io.IOException;

public class Input implements Runnable {

	static DataInputStream input;

	public Input(DataInputStream in) {
		input = in;
	}

	@Override
	public void run() {
		while (true) {
			String msg = "";
			try {
				msg = input.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(msg);
		}
	}

}
