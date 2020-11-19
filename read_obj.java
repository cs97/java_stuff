import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File datei = new File("/home/user/obj.dat");
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datei));
			Object raw = ois.readObject();
			DataObject dataobj = (DataObject) raw;
			
			System.out.println(dataobj.getString());

		} catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
