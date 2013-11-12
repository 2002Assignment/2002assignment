import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class MovieBookingAppInitialize {

	public static void main(String[] args) throws ParseException {
		
		// create files 
		
		File f1 = new File("Cineplexes.dat");
		File f2 = new File("Movies.dat");
		File f3 = new File("Sessions.dat");
		File f4 = new File("Bookings.dat");
		
		
		
		//initialize all database
		Cinema[] cinemas0=new Cinema[3];
		cinemas0[0]=new Cinema("FIR",true);
		cinemas0[1]=new Cinema("SEC",false);
		cinemas0[2]=new Cinema("THI",true);
		Cinema[] cinemas1=new Cinema[3];
		cinemas1[0]=new Cinema("FIR",true);
		cinemas1[1]=new Cinema("SEC",false);
		cinemas1[2]=new Cinema("THI",true);
		Cinema[] cinemas2=new Cinema[3];
		cinemas2[0]=new Cinema("FIR",true);
		
		cinemas2[1]=new Cinema("SEC",false);
		cinemas2[2]=new Cinema("THI",true);
		
		ArrayList <Cineplex> cineplexes=new ArrayList<Cineplex>();
		Cineplex cineplex0=new Cineplex("Jurong East",cinemas0);
		Cineplex cineplex1=new Cineplex("Orchard",cinemas1);
		Cineplex cineplex2=new Cineplex("Pasir Ris",cinemas2);
	
		cineplexes.add(cineplex0);
		cineplexes.add(cineplex1);
		cineplexes.add(cineplex2);
		
		Database.serialize(cineplexes, "Cineplexes.dat");
        
		//initialize movies database
		SimpleDateFormat dateFormatterM=new SimpleDateFormat("yyyy-MM-dd");
		
		
		
		//movie available
		ArrayList <Movie> movies=new ArrayList<Movie>();
		Movie movie0=new Movie("Avanta", dateFormatterM.parse("2013-11-01"),
				"3D", "NC16",150,"Preview");
		Movie movie1=new Movie("Geek", dateFormatterM.parse("2013-11-01"),
				"2D", "PG13",150,"Preview");
		Movie movie2=new Movie("The Notes", dateFormatterM.parse("2013-11-21"), 
				"2D", "M18",120,"ComingSoon");
		Movie movie3=new Movie("Gravity", dateFormatterM.parse("2013-11-25"),
				"3D", "NC16",150,"ComingSoon");
		Movie movie4=new Movie("Detactive Conan", dateFormatterM.parse("2013-11-31"),
				"2D", "PG",120,"ComingSoon");
		Movie movie5=new Movie("Cat and dog", dateFormatterM.parse("2013-11-19"),
				"2D", "G",120,"ComingSoon");
		Movie movie6=new Movie("Kongfu panda (*2D)", dateFormatterM.parse("2013-11-03"),
				"2D", "PG",120,"NowShowing");
		Movie movie7=new Movie("Kongfu panda (*3D)", dateFormatterM.parse("2013-11-05"),
				"3D", "PG",120,"NowShowing");
		Movie movie8=new Movie("Tian tai", dateFormatterM.parse("2013-10-27"),
				"2D", "PG13",120,"NowShowing");
		Movie movie9=new Movie("Ender's game", dateFormatterM.parse("2013-10-25"),
				"2D", "M18",120,"NowShowing");
		Movie movie10=new Movie("Taitanic", dateFormatterM.parse("2013-11-02"),
				"3D", "PG13",120,"NowShowing");
		Movie movie11=new Movie("Pie", dateFormatterM.parse("2013-10-31"),
				"3D", "PG",120,"NowShowing");
		//end of showing
		Movie movie12=new Movie("Red2", dateFormatterM.parse("2013-01-01"), 
				"2D", "NC16",120,"EndOfShowing");
		Movie movie13=new Movie("Happy People", dateFormatterM.parse("2013-01-03"),
				"2D", "PG13",120,"EndOfShowing");
		Movie movie14=new Movie("Despicable Me2", dateFormatterM.parse("2013-01-04"),
				"2D", "PG",120,"EndOfShowing");
		Movie movie15=new Movie("Tai ji (*3D)", dateFormatterM.parse("2013-01-03"),
				"3D", "PG13",120,"EndOfShowing");
		Movie movie16=new Movie("Ice Man", dateFormatterM.parse("2013-01-02"),
				"2D", "M18",120,"EndOfShowing");
		Movie movie17=new Movie("Planes", dateFormatterM.parse("2013-01-01"), 
				"3D", "PG",120,"EndOfShowing");
	     
		movies.add(movie0);
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);
		movies.add(movie5);
		movies.add(movie6);
		movies.add(movie7);
		movies.add(movie8);
		movies.add(movie9);
		movies.add(movie10);
		movies.add(movie11);
		movies.add(movie12);
		movies.add(movie13);
		movies.add(movie14);
		movies.add(movie15);
		movies.add(movie16);
		movies.add(movie17);
		
		
		Database.serialize(movies, "Movies.dat");
		
///////////////////////////
		// initialize Sessions database
		SimpleDateFormat dateFormatterS=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
        ArrayList<Session> sessions=new ArrayList<Session>();
        
        
		//generate history records for session
	    Calendar calendar = new GregorianCalendar(); 
	    Date date = new Date();
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd");
	    date = dateFormatter.parse("2013-01-01");
	    calendar.setTime(date);
		for(int i=0;i<304;i++){
			
	    	calendar.add(Calendar.DAY_OF_YEAR, 1);
	    	String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	    	String mvTime1 = dayAfter + " 10:00";
	    	String mvTime2 = dayAfter + " 15:00";
	    	String mvTime3 = dayAfter + " 19:00";
	    
	    	//cineplex0
	    	Session movie12_1 = new Session(movie12, cineplex0, cinemas0[0],
	    			dateFormatterS.parse(mvTime1));
	    	Session movie17_1 = new Session(movie17, cineplex0, cinemas0[2],
	    			dateFormatterS.parse(mvTime3));
	    	//cineplex1
	    	Session movie13_1 = new Session(movie13, cineplex1, cinemas1[0],
	    			dateFormatterS.parse(mvTime3));
	    	Session movie16_1 = new Session(movie16, cineplex1, cinemas1[2],
	    			dateFormatterS.parse(mvTime2));
	    	//cineplex2
	    	Session movie14_1 = new Session(movie14, cineplex2, cinemas2[1],
	    			dateFormatterS.parse(mvTime1));
	    	Session movie15_1 = new Session(movie15, cineplex2, cinemas2[2],
	    			dateFormatterS.parse(mvTime1));
	    	
	    	//add history
			sessions.add(movie12_1);
			sessions.add(movie13_1);			
			sessions.add(movie14_1);
			sessions.add(movie15_1);
			sessions.add(movie16_1);
			sessions.add(movie17_1);
	    }
		Database.serialize(sessions, "Sessions.dat");

	    //////////////////////////////
	    //Now showing
		date = new Date();
    	date = dateFormatter.parse("2013-11-14");
    	calendar.setTime(date); 
	    for(int i=0;i<7;i++){
			
	    	calendar.add(Calendar.DAY_OF_YEAR, 1);
	    	//System.out.println("date:"+calendar.getTime());
	    	String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	    	String mvTime1 = dayAfter + " 10:00";
	    	String mvTime2 = dayAfter + " 15:00";
	    	String mvTime3 = dayAfter + " 19:00";
	    	String mvTime4 = dayAfter + " 22:00";
	        //cineplex0
			Session movie6_1=new Session(movie6, cineplex0, cinemas0[0],
					dateFormatterS.parse(mvTime1));
			Session movie7_1=new Session(movie7, cineplex0, cinemas0[0],
					dateFormatterS.parse(mvTime2));
			Session movie8_1=new Session(movie8, cineplex0, cinemas0[0],
					dateFormatterS.parse(mvTime3));
			
			Session movie9_1=new Session(movie9, cineplex0, cinemas0[2],
					dateFormatterS.parse(mvTime1));
			Session movie10_1=new Session(movie10, cineplex0, cinemas0[2],
					dateFormatterS.parse(mvTime2));
			Session movie11_1=new Session(movie11, cineplex0, cinemas0[2],
					dateFormatterS.parse(mvTime3));
			
			Session movie6_2=new Session(movie6, cineplex0, cinemas0[1],
					dateFormatterS.parse(mvTime1));
			Session movie8_2=new Session(movie8, cineplex0, cinemas0[1],
					dateFormatterS.parse(mvTime2));
			Session movie7_2=new Session(movie7, cineplex0, cinemas0[1],
					dateFormatterS.parse(mvTime3));
			Session movie0_1=new Session(movie0, cineplex0, cinemas0[1],
					dateFormatterS.parse(mvTime4));
			
			//cineplex1
			Session movie9_2=new Session(movie9, cineplex1, cinemas1[0],
					dateFormatterS.parse(mvTime1));
			Session movie10_2=new Session(movie10, cineplex1, cinemas1[0],
					dateFormatterS.parse(mvTime2));
			Session movie11_2=new Session(movie11, cineplex1, cinemas1[0],
					dateFormatterS.parse(mvTime3));
					
			Session movie8_3=new Session(movie8, cineplex1, cinemas1[2],
					dateFormatterS.parse(mvTime1));
			Session movie6_3=new Session(movie6, cineplex1, cinemas1[2],
					dateFormatterS.parse(mvTime2));
			Session movie7_3=new Session(movie7, cineplex1, cinemas1[2],
					dateFormatterS.parse(mvTime3));
					
			Session movie9_3=new Session(movie9, cineplex1, cinemas1[1],
					dateFormatterS.parse(mvTime1));
			Session movie11_3=new Session(movie11, cineplex1, cinemas1[1],
					dateFormatterS.parse(mvTime2));
			Session movie10_3=new Session(movie10, cineplex1, cinemas1[1],
					dateFormatterS.parse(mvTime3));
			Session movie1_1=new Session(movie1, cineplex1, cinemas1[1],
					dateFormatterS.parse(mvTime4));
			
			//cineplex2
			Session movie7_4=new Session(movie7, cineplex2, cinemas2[0],
					dateFormatterS.parse(mvTime1));
			Session movie6_4=new Session(movie6, cineplex2, cinemas2[0],
					dateFormatterS.parse(mvTime2));
			Session movie8_4=new Session(movie8, cineplex2, cinemas2[0],
					dateFormatterS.parse(mvTime3));
			
			Session movie10_4=new Session(movie10, cineplex2, cinemas2[2],
					dateFormatterS.parse(mvTime1));
			Session movie9_4=new Session(movie9, cineplex2, cinemas2[2],
					dateFormatterS.parse(mvTime2));
			Session movie11_4=new Session(movie11, cineplex2, cinemas2[2],
					dateFormatterS.parse(mvTime3));
								
			Session movie8_5=new Session(movie8, cineplex2, cinemas2[1],
					dateFormatterS.parse(mvTime1));
			Session movie9_5=new Session(movie9, cineplex2, cinemas2[1],
					dateFormatterS.parse(mvTime2));
			Session movie11_5=new Session(movie11, cineplex2, cinemas2[1],
					dateFormatterS.parse(mvTime3));
			Session movie0_2=new Session(movie0, cineplex2, cinemas2[1],
					dateFormatterS.parse(mvTime4));

			//add now showing sessions to db
			sessions.add(movie0_1);
			sessions.add(movie0_2);
			sessions.add(movie1_1);
			sessions.add(movie6_1);
			sessions.add(movie6_2);
			sessions.add(movie6_3);
			sessions.add(movie6_4);
			sessions.add(movie7_1);
			sessions.add(movie7_2);
			sessions.add(movie7_3);
			sessions.add(movie7_4);
			sessions.add(movie8_1);
			sessions.add(movie8_2);
			sessions.add(movie8_3);
			sessions.add(movie8_4);
			sessions.add(movie8_5);
			sessions.add(movie9_1);
			sessions.add(movie9_2);
			sessions.add(movie9_3);
			sessions.add(movie9_4);
			sessions.add(movie9_5);
			sessions.add(movie10_1);
			sessions.add(movie10_2);
			sessions.add(movie10_3);
			sessions.add(movie10_4);
			sessions.add(movie11_1);
			sessions.add(movie11_2);
			sessions.add(movie11_3);
			sessions.add(movie11_4);
			sessions.add(movie11_5);
	    }
	    
	    Database.serialize(sessions, "Sessions.dat");
		
		// load lists from database
		ArrayList <Cineplex> cineplexList=(ArrayList)Database.deserialize("Cineplexes.dat");
		ArrayList <Movie> movieList=(ArrayList)Database.deserialize("Movies.dat");
	    ArrayList <Session> sessionList=(ArrayList)Database.deserialize("Sessions.dat");
	    ArrayList <Booking> bookingList=(ArrayList)Database.deserialize("Bookings.dat");
	    
		
		//initialize bookings
		
        ArrayList<Booking> bookings=new ArrayList<Booking>();
        MovieGoer movieGoer1=new MovieGoer("Xiao","85800254","qxiao001@e.ntu.edu.sg");
        MovieGoer movieGoer2=new MovieGoer("Wang","85887627","wang0789@e.ntu.edu.sg");
        MovieGoer movieGoer3=new MovieGoer("Liu","91574283","yliu023@e.ntu.edu.sg");
        MovieGoer movieGoer4=new MovieGoer("Qi","84036721","qiyi0002@e.ntu.edu.sg");
        MovieGoer movieGoer5=new MovieGoer("Zeng","82188039","yzeng002@e.ntu.edu.sg");
        MovieGoer movieGoer6=new MovieGoer("Zhou","85887626","zhou0002@e.ntu.edu.sg");
        MovieGoer movieGoer7=new MovieGoer("Xie","84475217","xxie001@e.ntu.edu.sg");
        
        for (int i=1;i<sessionList.size()/4;i++){  
        	if ((Math.random()*10) > 3){
        		Booking booking1=new Booking(" ",1,1,sessionList.get(4*i) ,movieGoer1,1);
    			bookings.add(booking1);
    			}
        	if ((Math.random()*10) > 3){
        		Booking booking2=new Booking(" ",1,2,sessionList.get(4*i-1) ,movieGoer2,1);
    			bookings.add(booking2);
        	}
        	if ((Math.random()*10) > 3){
        		Booking booking3=new Booking(" ",1,3,sessionList.get(4*i-2) ,movieGoer3,1);
    			bookings.add(booking3);
        	}
        	if ((Math.random()*10) > 3){
        		Booking booking4=new Booking(" ",1,4,sessionList.get(4*i-3) ,movieGoer4,1);
    			bookings.add(booking4);
        	}
        	if ((Math.random()*10) > 3){
        		Booking booking5=new Booking(" ",1,5,sessionList.get(4*i-4) ,movieGoer5,2);
    			bookings.add(booking5);
        	}
        	if ((Math.random()*10) > 3){
        		Booking booking6=new Booking(" ",2,1,sessionList.get(4*i-1) ,movieGoer6,3);
    			bookings.add(booking6);
        	}
        	if ((Math.random()*10) > 3){
        		Booking booking7=new Booking(" ",2,2,sessionList.get(4*i-3) ,movieGoer7,3);
    			bookings.add(booking7);
        	}
        }
        
		Database.serialize(bookings, "Bookings.dat");
		System.out.println("generated");
	/*	File f1 = new File("Cineplexes.dat");
		File f2 = new File("Movies.dat");
		File f3 = new File("Sessions.dat");
		File f4 = new File("Bookings.dat");*/
	}
}
