
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


public class RSAByteCipher {
	private static KeyPair key = null;
	public RSAByteCipher() {
		genkey();
	}
	public PublicKey getpubkey() {
		return key.getPublic();
	}
	public byte[] enc(byte[] b, PublicKey pubkey) {
		return encrypt(b, pubkey);
	}
	public byte[] dec(byte[] b) {
		return decrypt(b, key.getPrivate());
	}
	//private
	private static void genkey() {
		KeyPairGenerator keygen = null;
		try{
			keygen = KeyPairGenerator.getInstance("RSA");
		} catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		keygen.initialize(1024);
		key = keygen.generateKeyPair();
	}
	private static byte[] encrypt(byte[] data, PublicKey pubkey){
		Cipher cipher = null;
		try{
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, pubkey);
		} catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		} catch (NoSuchPaddingException e){
			e.printStackTrace();
		} catch (InvalidKeyException e){
			e.printStackTrace();
		}
		
		byte[] chiffrat = null;
		try{
			chiffrat = cipher.doFinal(data);
		} catch (IllegalBlockSizeException | BadPaddingException e){
			e.printStackTrace();
		}
		return chiffrat;
	}
	private static byte[] decrypt(byte[] data, PrivateKey prvkey){
		byte[] dec = null;
		Cipher cipher = null;
		try{
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, prvkey);
		} catch (NoSuchAlgorithmException e1){
			e1.printStackTrace();
		} catch (NoSuchPaddingException e1){
			e1.printStackTrace();
		} catch (InvalidKeyException e){
			e.printStackTrace();
		}
		
		try{
			dec = cipher.doFinal(data);
		} catch (IllegalBlockSizeException | BadPaddingException e){
			e.printStackTrace();
		}
		return dec;
	}
}
