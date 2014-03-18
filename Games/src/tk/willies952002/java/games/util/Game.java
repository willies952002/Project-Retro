package tk.willies952002.java.games.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Game {

	String name() default ""; //Name of the Game
	
	String version() default ""; //Version of the Game
	
	String authors() default ""; //Author(s) of the Game
	
	String sourceChangeDate() default ""; //Date source last changed 
	
}

