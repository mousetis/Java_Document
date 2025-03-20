package tuan3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class fileDocGhi {
	public static void writeToFile(ArrayBook list, String fileName) throws Exception {
		ObjectOutputStream oos = null;
		
		oos = new ObjectOutputStream(new FileOutputStream(fileName));
		oos.writeObject(list);
		oos.close();
	}
	
	public Object readFromFile(String fileName) throws Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		Object list = ois.readObject();
		ois.close();
		return list;
	}
}
