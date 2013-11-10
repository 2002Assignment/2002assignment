import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.lang.*;

public class MovieBookingAppInitialize {

	public static void main(String[] args) {
		
		// create files 
		
		File f1 = new File("Cineplexes.dat");
		File f2 = new File("Movies.dat");
		File f3 = new File("Sessions.dat");
		File f4 = new File("Bookings.dat");
		
		Database db=new Database();
		//initialize all database
		Cinema[] cinemas1=new Cinema[2];
		cinemas1[0]=new Cinema("NO1_1",true);
		cinemas1[1]=new Cinema("NO1_2",false);
		Cinema[] cinemas2=new Cinema[2];
		cinemas2[0]=new Cinema("NO2_1",true);
		cinemas2[1]=new Cinema("NO2_2",false);
		ArrayList <Cineplex> cineplexes=new ArrayList<Cineplex>();
		Cineplex cineplex1=new Cineplex("Perry",cinemas1);
		Cineplex cineplex2=new Cineplex("Jerry",cinemas2);
		cineplexes.add(cineplex1);
		cineplexes.add(cineplex2);
		
		db.serialize(cineplexes, "Cineplexes.dat");
        
		//initialize movies database
		Date movieDateStart=new Date();
		Date movieDateEnd=new Date();
		Date dateMovieOn=new Date();
		
		ArrayList <Movie> movies=new ArrayList<Movie>();
		Movie movie1=new Movie("I love you", movieDateStart,
				"3D", "16G",150,"Preview");
		Movie movie2=new Movie("I'm Sam", movieDateStart, 
				"2D", "18G",120,"ComingSoon");
		Movie movie3=new Movie("+1I love you", movieDateStart,
				"3D", "16G",150,"NowShowing");
		Movie movie4=new Movie("+2I'm Sam", movieDateStart,
				"2D", "18G",120,"NowShowing");
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);
		
		db.serialize(movies, "Movies.dat");
		
		// initialize Sessions database
        ArrayList<Session> sessions=new ArrayList<Session>();
		
		Session movie1_1=new Session(movie1, cineplex1, cinemas1[0],
				dateMovieOn);
		
		
		Session movie1_2=new Session(movie1, cineplex1, cinemas1[1],
				dateMovieOn);
		
		Session movie2_1=new Session(movie2, cineplex2, cinemas1[1],
				dateMovieOn);
		sessions.add(movie1_1);
		sessions.add(movie1_2);
		sessions.add(movie2_1);
		db.serialize(sessions, "Sessions.dat");
		
		//initialize bookings
		MovieGoer movieGoer1=new MovieGoer("Xiao","+86 85800254","qxiao001@e.ntu.edu.sg");
        ArrayList<Booking> bookings=new ArrayList<Booking>();
		Booking booking1=new Booking(1,1,movie1_1,movieGoer1,1);
		bookings.add(booking1);
		db.serialize(bookings, "Bookings.dat");
		
		// load lists from database
		ArrayList <Cineplex> cineplexList=(ArrayList)db.deserialize("Cineplexes.dat");
		ArrayList <Movie> movieList=(ArrayList)db.deserialize("Movies.dat");
	    ArrayList <Session> sessionList=(ArrayList)db.deserialize("Sessions.dat");
	    ArrayList <Booking> bookingList=(ArrayList)db.deserialize("Bookings.dat");
	    //  ArrayList <MovieGoer> MovieGoerList=(ArrayList)db.deserialize("MovieGoers.dat");
	    
	    //test app
	    Iterator<Movie> it = movieList.iterator();
	    while (it.hasNext()){
	    	Movie cine=it.next();
	    	System.out.println(cine.toString());
	    }
	    

	    // List movies
	    //select session
	    
	    
	    
		
		
		
	

	}

}
