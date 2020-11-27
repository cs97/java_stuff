import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ByteArrayHandler {
	public byte[] read(String s) {
		try {
			byte[] bytes = Files.readAllBytes(Paths.get(s));
			return bytes;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void write(byte[] b, String s) {
		try {
			Files.write(Paths.get(s), b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
