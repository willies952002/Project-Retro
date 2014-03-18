package tk.willies952002.java.util.auth;

import java.security.MessageDigest;
import java.util.Random;

public class Password {
	
	/**
	 * 
	 * @param pswd
	 * @throws Exception
	 */
	public Password() {
	}
	
	/**
	 * @category INSECURE
	 * @return The MD5 Hashed Password 
	 */
	public static String getMD5(String passwd) {
		try {
			byte[] array = MessageDigest.getInstance("MD5").digest(passwd.getBytes("UTF-8"));
			StringBuffer buffer = new StringBuffer();
			for ( int i = 0; i < array.length; i++ ) {
				buffer.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
			}
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * @category INSECURE
	 * @return The SHA1 Hashed Password 
	 */
	public static String getSHA1(String passwd) {
		try {
			byte[] array = MessageDigest.getInstance("SHA1").digest(passwd.getBytes("UTF-8"));
			StringBuffer buffer = new StringBuffer();
			for ( int i = 0; i < array.length; i++ ) {
				buffer.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
			}
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getDblMD5(String passwd) {
		String hash1 = getMD5(passwd);
		String hash2 = getMD5(hash1);
		return hash2;
	}
	
	public static String getSHA256(String passwd) {
		try {
			String tmp = passwd;
			int salt = Salt.getSalt();
			System.out.println("Salt: " + salt);
			tmp = passwd + salt;
			passwd = tmp;
			byte[] array = MessageDigest.getInstance("SHA-256").digest(passwd.getBytes("UTF-8"));
			StringBuffer buffer = new StringBuffer();
			for ( int i = 0; i < array.length; i++ ) {
				buffer.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
			}
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static class Salt {
		public static int getSalt() {
			return new Random().nextInt();
		}
	}

}