import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjHandler<ET> {

	public void save(ET d, String s) {
		try {
			ET obj = d;
			File datei = new File(s);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(datei));
			oos.writeObject(obj);
			oos.flush();
			oos.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public ET load(String s) {
		try {
			File datei = new File(s);
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datei));
			Object raw = ois.readObject();
			ois.close();				
			return (ET) raw;	
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public void delete(String s) {
		File datei = new File(s);
		datei.delete();
	}
}
