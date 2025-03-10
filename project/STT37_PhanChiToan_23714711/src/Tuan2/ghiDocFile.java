package Tuan2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ghiDocFile {
	public static void  writeToFile(ArrayNhanVien dsnv, String fileName) throws Exception {
		ObjectOutputStream oos = null;
		
		oos = new ObjectOutputStream(new FileOutputStream(fileName));
		oos.writeObject(dsnv);
		oos.close();
	}
	
	public Object readFromFile(String fileName) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		Object list = ois.readObject();
		ois.close();
		return list;
	}
}
