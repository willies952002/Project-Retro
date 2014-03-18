package tk.willies952002.java.util.auth.test;

import org.junit.Test;

import tk.willies952002.java.util.auth.Password.Salt;

public class SaltTest {

	@Test
	public void testGetSalt() {
		for ( int i = 0; i < 5; i++ ) {
			System.out.println(Salt.getSalt());
		}
	}

}
