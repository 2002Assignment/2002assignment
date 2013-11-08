import java.io.*;
import java.util.*;

public class SessionDB {
	public static final String SEPARATOR = "|";

    // an example of reading
	public static ArrayList readSessions(String filename) throws IOException {
		// read String from text file
		ArrayList stringArray = (ArrayList)read(filename);
		ArrayList alr = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				// get individual 'fields' of the string separated by SEPARATOR
				StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

				
//				private Movie movie;
//				private Cineplex cineplex;
//				private Cinema cinema;
//				private Date dateMovieStart;
//				private Seat[][] seatLayout; 
//			    private int emptySeat;
			    
			    String movie=star.nextToken().trim();
			    String cineplex=star.nextToken().trim();
			    String cinema=star.nextToken().trim();
			    String dateMovieStart=star.nextToken().trim();
			    String seat=star.nextToken().trim();
			    
				
			    
				// create Professor object from file data
				Session session = new Session(movie,cineplex,cinema,dataMovieStart,seatLayout);
				// add to Professors list
				alr.add(session) ;
			}
			return alr ;
	}

	/*
  // an example of saving
public static void saveProfessors(String filename, List al) throws IOException {
		List alw = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < al.size() ; i++) {
				Professor prof = (Professor)al.get(i);
				StringBuilder st =  new StringBuilder() ;
				st.append(prof.getName().trim());
				st.append(SEPARATOR);
				st.append(prof.getEmail().trim());
				st.append(SEPARATOR);
				st.append(prof.getContact());
				alw.add(st.toString()) ;
			}
			write(filename,alw);
	}  */

  /** Write fixed content to the given file. */
  public static void write(String fileName, List data) throws IOException  {
    PrintWriter out = new PrintWriter(new FileWriter(fileName));

    try {
		for (int i =0; i < data.size() ; i++) {
      		out.println((String)data.get(i));
		}
    }
    finally {
      out.close();
    }
  }

  /** Read the contents of the given file. */
  public static List read(String fileName) throws IOException {
	List data = new ArrayList() ;
    Scanner scanner = new Scanner(new FileInputStream(fileName));
    try {
      while (scanner.hasNextLine()){
        data.add(scanner.nextLine());
      }
    }
    finally{
      scanner.close();
    }
    return data;
  }

public static void main(String[] aArgs)  {
    	SessionDB txtDB = new SessionDB();
    	String filename = "professor.txt" ;
		try {
			// read file containing Professor records.
			ArrayList al = SessionDB.readSessions(filename) ;
			for (int i = 0 ; i < al.size() ; i++) {
					Session prof = (Session)al.get(i);
					System.out.println("Movie " + prof.getMovie() );
					System.out.println("Contact " + prof.getContact() );
			}
			/*Professor p1 = new Professor("Joseph","jos@ntu.edu.sg",67909999);
			// al is an array list containing Professor objs
			al.add(p1);
			// write Professor record/s to file.
			TextDB.saveProfessors(filename, al);  */
			
		}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
  }
}
