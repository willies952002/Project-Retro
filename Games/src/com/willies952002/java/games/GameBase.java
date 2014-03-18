package com.willies952002.java.games;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
public abstract class GameBase {

	public static String GAME_NAME = "";
	public static Class<? extends GameBase> GAME_EXE;
	
	public GameBase(String gameName, Class<? extends GameBase> gameExe) {
		GAME_NAME = gameName;
		GAME_EXE = gameExe;
	}
	
	public abstract void init();
	
	public static void main(String[] args) {
		getLogicMethod();
	}

	
	/** Used to seach the game class for the game logic method
	 * 
	 * @return The Method, if one is found, null otherwise
	 */
	public static Method getLogicMethod() {
		for ( Method method : GAME_EXE.getClass().getMethods() ) {
			for ( Annotation a : method.getDeclaredAnnotations() ) {
				if ( a.equals(GameLogic.class));
				return method;
			}
		}
		return null;		
	}

	public static void cleanup() {
		AL.destroy();
		Display.destroy();
	}

}
