package tk.willies952002.java.util.auth.test;

import static org.junit.Assert.*;

import org.junit.Test;

import tk.willies952002.java.games.util.auth.LoginClient;
import tk.willies952002.java.util.auth.Password;

public class LoginClientTest {

	@Test
	public void testLoginClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testAuthenticate() throws Exception {
		LoginClient lc = new LoginClient("localhost", 7777);
		lc.authenticate("test", new Password());
	}

}
