import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class MovieDB {
	public static final String SEPARATOR = "|";

    // an example of reading
	public static ArrayList readMovies(String filename) throws IOException {
		// read String from text file
		ArrayList stringArray = (ArrayList)read(filename);
		ArrayList alr = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				// get individual 'fields' of the string separated by SEPARATOR
				StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","



			    
			    String movieName=star.nextToken().trim();
			    String movieDateOnStr=star.nextToken().trim();
			    String movieDateOffStr=star.nextToken().trim();
			    String movieType=star.nextToken().trim();
			    String rating=star.nextToken().trim();
			    String movieLastTimeStr=star.nextToken().trim();
			    int movieLastTime=Integer.parseInt(movieLastTimeStr);
			    
			    SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
			   // Date movieDateOn ;
				//Date movieDateOff;
			 
				try {
			 
					 Date movieDateOn = formatter.parse(movieDateOnStr);
					 Date movieDateOff= formatter.parse(movieDateOffStr);
					//System.out.println(date);
					//System.out.println(formatter.format(date));
					 Movie movie = new Movie(movieName,movieDateOn,movieDateOff,movieType,rating,movieLastTime);
					 alr.add(movie);
					 
				} catch (ParseException e) {
					e.printStackTrace();
				}
			    
			    
				// create Professor object from file data
				//Movie movie = new Movie(movieName,movieDateOn,movieDateOff,movieType,rating);
				// add to Professors list
				//alr.add(movie) ;
			}
			return alr ;
	}

	
  // an example of saving
public static void saveMovies(String filename, List al) throws IOException {
		List alw = new ArrayList() ;// to store Professors data

		
//		private String movieName;
//		
//		private Date movieDateOn;
//		private Date movieDateOff;
//		private String movieType;
//		private String rating;
        for (int i = 0 ; i < al.size() ; i++) {
				Movie movie = (Movie)al.get(i);
				StringBuilder st =  new StringBuilder() ;
				st.append(movie.getMovieName().trim());
				st.append(SEPARATOR);
				SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
				st.append(formatter.format(movie.getMovieDateOn()).trim());
				st.append(SEPARATOR);
				st.append(formatter.format(movie.getMovieDateOff()).trim());
				st.append(SEPARATOR);
				st.append(movie.getMovieType().trim());
				st.append(SEPARATOR);
				st.append(movie.getRating().trim());
				st.append(SEPARATOR);
				st.append(String.valueOf(movie.getMovieLastTime()).trim());
				
				alw.add(st.toString()) ;
			}
			write(filename,alw);
	}  

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
    	String filename = "C:/2002/2002Assignment/src/Movies.txt" ;
		try {
			// read file containing Professor records.
			ArrayList al = MovieDB.readMovies(filename) ;
			for (int i = 0 ; i < al.size() ; i++) {
					Movie movie = (Movie)al.get(i);
					System.out.println(movie.toString());
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
