package tk.willies952002.java.util.auth.test;

import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

import tk.willies952002.java.util.auth.Password;

public class PasswordTest {

	static String password;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Please Enter Password: ");
		Scanner sc = new Scanner(System.in);
		password = sc.nextLine();
		sc.close();
	}

	@Test
	public void testGetMD5() {
		System.out.println("MD5: " + Password.getMD5(password));
	}

	@Test
	public void testGetSHA1() {
		System.out.println("SHA1: " + Password.getSHA1(password));
	}
	
	@Test
	public void testGetSHA256() {
		System.out.println("SHA-256: " + Password.getSHA256(password));
	}

}
