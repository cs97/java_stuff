
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

public class StreamCipher {
	private static SecretKeySpec secretKey;
	private static byte[] key;
	public AesStream(String s) {
		setKey(s);
	}
	private static void setKey(String myKey) {
		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	static CipherOutputStream OuntEnc(OutputStream b) {
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);		
			CipherOutputStream cin = new CipherOutputStream(b, cipher);
			return cin;
		} catch (Exception e) {
			System.out.println("Error while encrypting !");
			return null;
		}
	}
	static CipherOutputStream OutDec(OutputStream b) {
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			CipherOutputStream cin = new CipherOutputStream(b, cipher);
			return cin;
		} catch (Exception e) {
			System.out.println("Error while decrypting !");
			return null;
		}
	}
	static CipherInputStream InEnc(InputStream b) {
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);		
			CipherInputStream cin = new CipherInputStream(b, cipher);
			return cin;
		} catch (Exception e) {
			System.out.println("Error while encrypting !");
			return null;
		}
	}
	static CipherInputStream InDec(InputStream b) {
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			CipherInputStream cin = new CipherInputStream(b, cipher);
			return cin;
		} catch (Exception e) {
			System.out.println("Error while decrypting !");
			return null;
		}
	}
}
