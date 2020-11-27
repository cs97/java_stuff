import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteObj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataObject dataobj = new DataObject("lolig");
		try {
			File datei = new File("/home/user/obj.dat");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(datei));
			oos.writeObject(dataobj);
			oos.flush();
			oos.close();
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
