import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class SessionSetting {

	Database db=new Database();
	ArrayList <Cineplex> cineplexList=(ArrayList)db.deserialize("Cineplexes.dat");
    ArrayList <Session> sessionList=(ArrayList)db.deserialize("Sessions.dat");
    
	private Movie movie;
	private Cineplex cineplex;
	private Cinema cinema;
	private Date dateMovieStart;
	
	
	public SessionSetting(Database db, Movie movie, Cineplex cineplex,
			Cinema cinema, Date dateMovieStart) {
		super();
		this.db = null;
		this.movie = null;
		this.cineplex = null;
		this.cinema = null;
		this.dateMovieStart = null;
	}


	public void addSession() throws ParseException{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name movies to add session:");
	    movie.setMovieName(sc.next());
	    
	    System.out.println("Set cineplex:");
	    System.out.println("Cineplex list:");
	    for(int i=0 ;i<cineplexList.size();i++){
	    	System.out.print(cineplexList.get(i).getCineplexName());
	    }
		cineplex.setCineplexName(sc.next());
	
		
	    System.out.println("Cinema list:");
	    
	    for(int i=0 ;i<3;i++){
	    	System.out.print(cineplex.getCinema()[i].getCinemaCode());
	    }
	    System.out.println("Set Cinema:");
		cinema.setCinemaCode(sc.next());

	    
	    System.out.println("Set date and time movie starts:");
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyymmddhhmm");
	    dateMovieStart = dateFormatter.parse(sc.nextLine());
	    
	    
	    Session session = new Session(movie, cineplex, cinema, dateMovieStart);
		
		sessionList.add(session);
		db.serialize(sessionList, "Sessions.dat");
	}
}
