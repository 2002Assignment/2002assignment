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
	private String movieStatus;
	private int upC;
	private String name;
	
	
	//constructor
	public MovieSetting() {
		this.movieName = null;
		this.movieDateOn = null;
		this.movieType = null;
		this.rating = null;
		this.movieLastTime = 0;
		this.movieStatus =null;
		this.upC = 0;
		this.name = null;
		this.db =new Database();
	}

	
    public void printMovie(){
    	int i=1;
    	System.out.println("=====Movies in Database===== ");
		System.out.println("No.|      Movie Name      |  Type  |  Length   |Rating|");
    	for (Movie m : movieList){
    			System.out.printf("%2d |%-22s|  %-4s  |    %-6d |  %-4s|\n", i,m.getMovieName(), m.getMovieType() , m.getMovieLastTime() 
    	        		,m.getRating());
    			i++;
    		
    	} 
    }
	
	public void addMovie() throws ParseException{
		
	    Scanner sc = new Scanner(System.in);
	    System.out.println("----Initialize New Movie----");
	    System.out.println("Enter movie name:");
	    movieName = sc.nextLine();
	    System.out.println("Enter date on in YYYY-MM-DD format: ");
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd");
	    movieDateOn = dateFormatter.parse(sc.nextLine());
	    System.out.println("Enter movie type(2D,3D):");
	    movieType = sc.nextLine();
	    System.out.println("Enter movie rating(18G .. ): ");
	    rating = sc.nextLine();
	    System.out.println("Enter movie last time(minutes in integer):");
	    movieLastTime = sc.nextInt();
	    System.out.println("Enter movie status(Preview, OnShowing, EndOfShowing ): ");
	    sc.nextLine();
	    movieStatus = sc.nextLine();
		
		Movie movie = new Movie(movieName, movieDateOn,movieType, rating,
				movieLastTime, movieStatus);
		movieList.add(movie);
		db.serialize(movieList, "Movies.dat");
		System.out.println("Movie add successfully: "+movie.getMovieName());
	}
	public void deleteMovie(){
		
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter integer to delete movie:");
	    int movieIndex =sc.nextInt();
	    movieList.remove(movieIndex-1);
	    db.serialize(movieList, "Movies.dat");
	    
	}
	public void updateMovie() throws ParseException{
		
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter integer to update movie");
	    int movieIndex = sc.nextInt();
	    Movie mv=movieList.get(movieIndex-1);
	    
	    
	    System.out.println("Enter your choice to update movie:");
	    System.out.println("1. Movie name");
	    System.out.println("2. Movie date on");
	    System.out.println("3. Movie rating");
	    System.out.println("4. Movie typing");
	    System.out.println("5. Movie last time");
	    System.out.println("6. Change movie status");
	    
	    
	    SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd");
	    
	    upC = sc.nextInt();
	    sc.nextLine();
		switch(upC){
		case 1: 
			System.out.println("Enter new name: ");
		    mv.setMovieName(sc.nextLine());
			break;
		case 2:
			System.out.println("Enter new date on: ");
		    mv.setMovieDateOn(dateFormatter.parse(sc.nextLine()));
		    break;
		case 3:
			System.out.println("Enter new rating: ");
			mv.setRating(sc.nextLine());
			break;
		case 4:
			System.out.println("Enter new type: ");
			mv.setMovieType(sc.nextLine());
			break;
		case 5:
			System.out.println("Enter new last time: ");
			mv.setMovieLastTime(sc.nextInt());
			break;
		case 6:
			System.out.println("Enter new status: ");
			mv.setMovieStatus(sc.nextLine());
			break;
		}
		db.serialize(movieList, "Movies.dat");
	}
}
