import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileCipher {

	public static void main(String[] args) throws IOException {

		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
		
		ArrayHandler bah = new ArrayHandler();

		byte[] data;
		
    		System.out.println("key:");
    	
		aesbytecipher abc = new aesbytecipher(reader.readLine());

		switch(args[0]){
        case "-enc":
    		  data = abc.enc(bah.read(args[1]));
    		  bah.write(data, args[1]+".enc");
        	break;
        case "-dec":
        	data = abc.dec(bah.read(args[1]));
        	bah.write(data, args[1]+".dec");
        	break;
        default:
        	System.out.println("!");
        	break;
		}		
	}
}
