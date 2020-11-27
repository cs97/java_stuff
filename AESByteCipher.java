import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class aesbytecipher {
	private static SecretKeySpec secretKey;
	private static byte[] key;

	public aesbytecipher(String s) {
		setKey(s);
	}

	public byte[] enc(byte[] b) {
		return encrypt(b);
	}

	public byte[] dec(byte[] b) {
		return decrypt(b);
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

	private static byte[] encrypt(byte[] byteToEncrypt) {
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return cipher.doFinal(byteToEncrypt);
		} catch (Exception e) {
			System.out.println("Error while encrypting !");
		}
		return null;
	}

	private static byte[] decrypt(byte[] byteToDecrypt) {
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return cipher.doFinal(byteToDecrypt);
		} catch (Exception e) {
			System.out.println("Error while decrypting !");
		}
		return null;
	}

}
