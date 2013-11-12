import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class SessionSetting {

	Database db=new Database();
	ArrayList <Cineplex> cineplexList=(ArrayList)db.deserialize("Cineplexes.dat");
    ArrayList <Session> sessionList=(ArrayList)db.deserialize("Sessions.dat");
    ArrayList <Movie> movieList=(ArrayList)db.deserialize("Movies.dat");
    
	private Movie movie;
	private Cineplex cineplex;
	private Cinema cinema;
	private Date dateMovieStart;
	
	
	public SessionSetting() {
		this.db = null;
		this.movie = null;
		this.cineplex = null;
		this.cinema = null;
		this.dateMovieStart = null;
	}


	public void addSession() throws ParseException{
		int i = 1;
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	System.out.println("================Movie Sessions===============");
		System.out.println("No.|      Movie Name      |  Cinema  |  Session Time  |");		
	    for(Session s : sessionList){
	    		if (!s.getMovie().getMovieStatus().equals("EndOfShowing")){
					System.out.printf("%2d.|%-22s| %-9s|%s|\n" ,i, s.getMovie().getMovieName() ,
					( s.getCinema().isCinemaNormal()? "Normal":"Platinum")  ,dateFormatter.format(s.getdateMovieStart()));
					i++;
	    		} 
    	}
	    i=1;
	    System.out.println("================Add Session=============");
	    System.out.println("============Movies in Database========== ");
		System.out.println("No.|      Movie Name      |  Type  |  Length   |Rating|");
    	for (Movie m : movieList){
    			System.out.printf("%2d |%-22s|  %-4s  |    %-6d |  %-4s|\n", i,m.getMovieName(), m.getMovieType() , m.getMovieLastTime() 
    	        		,m.getRating());
    			i++;
    		
    	} 
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter integer to choose movie:");
	    int choice=sc.nextInt();
	    Movie sessionMovie=movieList.get(choice-1);      // set movie
	    
	    
	    System.out.println("Cineplexes: ");
		i=0;
		for(Cineplex m:cineplexList){
			i++;
		    System.out.println(i+"."+m.getCineplexName());
		    
		}
	    System.out.println("Enter integer to choose cineplex:");
	    choice=sc.nextInt();
	    Cineplex sessionCineplex=cineplexList.get(choice-1);      // set cineplex
	
		
		 System.out.println("Cinemas: ");
		 i=0;
		 Cinema[] cinemaList=sessionCineplex.getCinema();
		 
		 for(Cinema m:cinemaList){
			    i++;
			    System.out.println(i+"."+m.getCinemaCode());
			   
		 }
		 System.out.println("Enter integer to choose cinema:");
		 choice=sc.nextInt();
		 Cinema sessionCinema=Arrays.asList(cinemaList).get(choice-1);  

		 
		 // set start date
	     sc.nextLine();
	     System.out.println("Set date and time movie starts in this format yyyy-MM-dd HH:mm:");
		 SimpleDateFormat dateFormatter2=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	     dateMovieStart = dateFormatter.parse(sc.nextLine());
	    
	    
	     Session session = new Session(sessionMovie, sessionCineplex, sessionCinema, dateMovieStart);
		 
		 sessionList.add(session);
		 db.serialize(sessionList, "Sessions.dat");
		 System.out.println("Session add successfully!");
		 
		 
	}
}
