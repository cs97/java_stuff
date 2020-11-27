
import java.io.Serializable;

public class SimpleDataObject implements Serializable{
	
	private String string;
	
	public SimpleDataObject(String string) {
		this.string = string;
	}
	public String getString() {
		return string;
	}
}
