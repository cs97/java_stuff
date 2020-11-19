package stuff1;

import java.io.Serializable;

public class DataObject implements Serializable{
	
	private String string;
	
	public DataObject(String string) {
		this.string = string;
	}
	public String getString() {
		return string;
	}
}
