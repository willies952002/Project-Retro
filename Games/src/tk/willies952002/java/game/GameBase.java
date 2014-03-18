package tk.willies952002.java.game;

import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
public abstract class GameBase {

	public static String GAME_NAME = "";
	public static Class<? implements Runnable> GAME_EXE
	
	public GameBase(String gameName, Class<? implements Runnable> gameExe) {
		GAME_NAME = gameName;
		GAME_EXE = gameExe;
	}
	
	public abstract void init();
	
	public static void main(String[] args) {
		//Seach Class for Intialization Method
		//GAME_EXE.getClass().
	}
	
	public static void cleanup() {
		AL.destroy();
		Display.destroy();
	}

}
