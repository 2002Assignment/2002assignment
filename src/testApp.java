import java.util.Calendar;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.*;
import java.io.*;

public class testApp {

	public static void main(String[] args) {
		Date movieDateStart=new Date();
		Date movieDateEnd=new Date();
		Date dateMovieOn=new Date();
		Cinema[] cinema=new Cinema[2];
		
		cinema[1]=new Cinema("no.1Cinema",true);
		cinema[0]=new Cinema("no.0Cinema",true);
		
		Cineplex cineplex1=new Cineplex("no.1cineplex",cinema);
		
		Movie movie1=new Movie("I love you", movieDateStart, movieDateEnd,
				"3D", "16G",150);
		
		ArrayList<Session> sessions=new ArrayList<Session>();
		
		Session movie1_0=new Session(movie1, cineplex1, cinema[0],
				dateMovieOn);
		sessions.add(movie1_0);
		
		Session movie1_1=new Session(movie1, cineplex1, cinema[1],
				dateMovieOn);
		
		Session movie1_2=new Session(movie1, cineplex1, cinema[1],
				dateMovieOn);
		
		sessions.add(movie1_1);
		
		//System.out.println(sessions.get(0).getMovie().toString());
		
		//movie1_1.assignSeat(1, 1);
		//movie1_1.assignSeat(1, 1);
		
		Database database=new Database();
		File fileName = new File ("C:/2002/2002Assignment/src/tmp.dat");
		
		Database.serialize(sessions, "C:/2002/2002Assignment/src/tmp.dat");
		
		ArrayList<Session> newtest=(ArrayList)database.deserialize("C:/2002/2002Assignment/src/tmp.dat");
	    
		newtest.add(movie1_2);
		Database.serialize(newtest, "C:/2002/2002Assignment/src/tmp.dat");
		ArrayList<Session> newtest2=(ArrayList)database.deserialize("C:/2002/2002Assignment/src/tmp.dat");
	    
		
		System.out.println(newtest2.isEmpty());
		System.out.println(newtest2.get(2).getMovie().toString());
		
		

	}

}
