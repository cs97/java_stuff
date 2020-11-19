import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class DateiSchreiben {
	public static void main(String[] args) {
		try {
			File datei = new File("/home/rax/nope.txt");
			datei.createNewFile();
			PrintWriter pw = new PrintWriter(new FileWriter(datei));
			pw.println("line 1");
			pw.println("line 2");
			pw.flush();
			pw.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
