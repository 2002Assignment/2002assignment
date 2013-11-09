import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class MovieSetting {
	Database db=new Database();
	ArrayList <Cineplex> cineplexList=(ArrayList)db.deserialize("Cineplexes.dat");
	ArrayList <Movie> movieList=(ArrayList)db.deserialize("Movies.dat");
    
    
	private String movieName;
	private Date movieDateOn;
	private Date movieDateOff;
	private String movieType;
	private String rating;
	private int movieLastTime;
	
	
	private int upC;
	
	private String name;
	
	//constructor
	public MovieSetting(String movieName, Date movieDateOn, 
			String movieType, String rating, int movieLastTime, Movie movie, 
			int upC, String name, Database db) {
		super();
		this.movieName = null;
		this.movieDateOn = null;
		this.movieType = null;
		this.rating = null;
		this.movieLastTime = 0;
		this.upC = 0;
		this.name = null;
		this.db = null;
		
	}

	
	

	
	public void addMovie() throws ParseException{
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter movie name:");
	    movieName = sc.next();
	    System.out.println("Enter date on:");
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyymmdd");
	    movieDateOn = dateFormatter.parse(sc.nextLine());
	    System.out.println("Enter movie type:");
	    movieType = sc.next();
	    System.out.println("Enter movie rating:");
	    rating = sc.next();
	    System.out.println("Enter movie last time:");
	    movieLastTime = sc.nextInt();
	    
		Movie movie = new Movie(movieName, movieDateOn, movieDateOff, 
				movieType, rating, movieLastTime);
		movieList.add(movie);
		db.serialize(movieList, "Movies.dat");
	}
	
	public void updateMovie() throws ParseException{
		 
		int i = 1;

		for (Movie m : movieList){
    		if (m.getMovieStatus() == "Now Showing"){
    	        System.out.println(i + m.getMovieName());
    		    i++;
    		} 
		}
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter movie name to update");
	    name = sc.next();
	   
	    Iterator<Movie> it = movieList.iterator();
	    Movie mv = new Movie(movieName, movieDateOn, movieDateOff, 
				movieType, rating, movieLastTime);
	    
	    while (it.hasNext()){
	    	mv=it.next();
	    	if (mv.getMovieName() == name)
    	        break;
	    }
	    
	    System.out.println("Enter your choice to update movie:");
	    System.out.println("1. Movie name");
	    System.out.println("2. Movie date on");
	    System.out.println("3. Movie rating");
	    System.out.println("4. Movie typing");
	    System.out.println("5. Movie last time");
	    System.out.println("6. Change movie status");
	    
	    
	    SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyymmdd");
	    
	    upC = sc.nextInt();
		switch(upC){
		case 1: 
			System.out.println("Enter new name: ");
		    mv.setMovieName(sc.next());
			break;
		case 2:
			System.out.println("Enter new date on: ");
		    mv.setMovieDateOn(dateFormatter.parse(sc.nextLine()));
		    break;
		case 3:
			System.out.println("Enter new rating: ");
			mv.setRating(sc.next());
			break;
		case 4:
			System.out.println("Enter new type: ");
			mv.setMovieType(sc.next());
			break;
		case 5:
			System.out.println("Enter new last time: ");
			mv.setMovieLastTime(sc.nextInt());
			break;
		case 6:
			System.out.println("Enter new status: ");
			mv.setMovieStatus(sc.next());
			break;
		}
	}
}
