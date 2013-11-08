import java.util.*;
import java.io.*;

public class SessionsDB implements Serializable {
          ArrayList<Session> sessions=null;
	      public SessionsDB(){
	    	  sessions=null;
	      }
          
		  
		  /*
		  public void searilizeSessions(ArrayList<Session> sessions, String fileName) {
			  //System.out.println(sessions.get(0).toString()); 
			  try {
				    
			        FileOutputStream fileOut = new FileOutputStream(fileName);
			        ObjectOutputStream out = new ObjectOutputStream(fileOut);
			        out.writeObject(sessions);
			        out.close();
			        fileOut.close();
			  
			        
			    } catch (IOException ex) {
			    }
			} */
	      

	      /*
	     		public ArrayList<Session> deserializeSessions(String fileName) {
	     			    ArrayList<Session> Sessions = new ArrayList<Session>() ;
	     			    try {
	     			        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
	     			        Sessions = (ArrayList<Session>)in.readObject(); 
	     			        System.out.println(Sessions.get(0).getMovie().toString());
	     			        in.close();
	     			    }
	     			    catch(Exception e) {}
	     			    return Sessions;
	     			}
	     		 */
		  public static void searilizeSessions(List list,String filename) {
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
		  public static List deserializeSessions(String filename) {
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

