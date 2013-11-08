import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Database implements Serializable{
	  
	 public static void serialize(List list,String filename) {
			FileOutputStream fos = null;
			ObjectOutputStream out = null;
			try {
				fos = new FileOutputStream(filename);
				out = new ObjectOutputStream(fos);
				out.writeObject(list);
				out.close();
			
			//	System.out.println("Object Persisted");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	  public static List deserialize(String filename) {
			List pDetails = null;
			FileInputStream fis = null;
			ObjectInputStream in = null;
			try {
				fis = new FileInputStream(filename);
				in = new ObjectInputStream(fis);
				pDetails = (ArrayList) in.readObject();
				in.close();
				
			} catch (IOException ex) {
				ex.printStackTrace();
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			// print out the size
			//System.out.println(" Details Size: " + pDetails.size());
			//System.out.println();
			return pDetails;
		}
	  

}
