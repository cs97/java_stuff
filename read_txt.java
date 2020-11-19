import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DateiSchreiben {
	public static void main(String[] args) {
		try {
			File datei = new File("/home/user/test.txt");
			Scanner data = new Scanner(datei);
			while(data.hasNextLine()) {
				String string = data.nextLine();
				System.out.println(string);
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}

}
