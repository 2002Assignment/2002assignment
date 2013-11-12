import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;



public class SessionSetting {

	
	ArrayList <Cineplex> cineplexList=(ArrayList)Database.deserialize("Cineplexes.dat");
    ArrayList <Session> sessionList=(ArrayList)Database.deserialize("Sessions.dat");
    ArrayList <Movie> movieList=(ArrayList)Database.deserialize("Movies.dat");
    
	private Movie movie;
	private Cineplex cineplex;
	private Cinema cinema;
	private Date dateMovieStart;
	
	
	public SessionSetting() {
		this.setMovie(null);
		this.setCineplex(null);
		this.setCinema(null);
		this.dateMovieStart = null;
	}


	public void addSession() throws ParseException{
	    int i=1;
	    System.out.println("======================Add Session=====================");
	    System.out.println("====================Movies in Database================ ");
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
	    System.out.println("Enter integer to choose cineplex:\n>>");
	    choice=sc.nextInt();
	    Cineplex sessionCineplex=cineplexList.get(choice-1);      // set cineplex
	
		
		 System.out.println("Cinemas: ");
		 i=0;
		 Cinema[] cinemaList=sessionCineplex.getCinema();
		 
		 for(Cinema m:cinemaList){
			    i++;
			    System.out.println(i+"."+m.getCinemaCode());
			   
		 }
		 System.out.println("==>Enter integer to choose cinema:\n>>");
		 choice=sc.nextInt();
		 Cinema sessionCinema=Arrays.asList(cinemaList).get(choice-1);  

		 
		 // set start date
	     sc.nextLine();
	     System.out.println("Set date and time movie starts in this format yyyy-MM-dd HH:mm:");
		 SimpleDateFormat dateFormatter2=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	     dateMovieStart = dateFormatter2.parse(sc.nextLine());
	    
	    
	     Session session = new Session(sessionMovie, sessionCineplex, sessionCinema, dateMovieStart);
		 
		 sessionList.add(session);
		 Database.serialize(sessionList, "Sessions.dat");
		 System.out.println("Session add successfully!");
		 
		 
	}

	public void deleteSession(){
		System.out.println("================Update Session=============");  
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter integer to choose Session:");
	    int choice=sc.nextInt();  
	    
	    sessionList.remove(sessionList.get(choice-1));
	  
		Database.serialize(sessionList, "Sessions.dat");
	    System.out.println("Session delete successfully!");
	}
    public void updateSession() throws Exception{
    	

    	int i=1;
	    System.out.println("================Update Session=============");
	  
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter integer to choose Session:");
	    int choice=sc.nextInt();
	    Session session=sessionList.get(choice-1);      
	    
	    
	    	System.out.println("1.Cineplex");
	    	System.out.println("2.Cinema");
	    	System.out.println("3.Movie start time");
	    	System.out.println("==> Please input your choice to update('1','2'...)");
	    	sc.nextLine();
	    int c=sc.nextInt();
	    switch(c){
	    case 1:System.out.println("Cineplexes: ");
		       i=0;
		       for(Cineplex m:cineplexList){
			   i++;
		       System.out.println(i+"."+m.getCineplexName());
		       
		        }
	           System.out.println("==>Enter integer to choose cineplex:");
	           choice=sc.nextInt();
	           session.setCineplex(cineplexList.get(choice-1)); 
	           break;
	    case 2:
	    	 System.out.println("Cinemas: ");
			 i=0;
			 Cinema[] cinemaList=session.getCineplex().getCinema();
			 
			 for(Cinema m:cinemaList){
				    i++;
				    System.out.println(i+"."+m.getCinemaCode());
				   
			 }
			 System.out.println("==>Enter integer to choose cinema:");
			 choice=sc.nextInt();
			 session.setCinema(Arrays.asList(cinemaList).get(choice-1)); 
			 break;
	    case 3:
	    	sc.nextLine();
		    System.out.println("==>Enter date and time movie starts in this format yyyy-MM-dd HH:mm:");
			SimpleDateFormat dateFormatter2=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		    dateMovieStart = dateFormatter2.parse(sc.nextLine());
		    session.setdateMovieStart(dateMovieStart); 
	    	break;
	    }
	   
		 Database.serialize(sessionList, "Sessions.dat");
		 System.out.println("Session update successfully!");
    }
    public void printSession(){
    	int i = 1;
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	System.out.println("============================Movie Sessions==============================");
		System.out.println("No.|      Movie Name      |    Cineplex    |  Cinema  |  Session Time  |");		
	    for(Session s : sessionList){
					System.out.printf("%2d.|%-22s| %-15s| %-9s|%s|\n" ,i, s.getMovie().getMovieName() ,s.getCineplex().getCineplexName(),
					( s.getCinema().isCinemaNormal()? "Normal":"Platinum")  ,dateFormatter.format(s.getdateMovieStart()));
					i++;
	    		
    	}
    }
	public Cinema getCinema() {
		return cinema;
	}


	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}


	public Cineplex getCineplex() {
		return cineplex;
	}


	public void setCineplex(Cineplex cineplex) {
		this.cineplex = cineplex;
	}


	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}
