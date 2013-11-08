import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class Booking {
	private String TID;
	private Session session;
	private MovieGoer movieGoer;
	private static Date currentDate=new Date();
	private SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyymmddhhmm");
	
	//constructor
	public Booking( Session session, MovieGoer movieGoer) {
		
		this.TID = session.getCinema().getCinemaCode() +dateFormatter.format(currentDate);;
		this.session = session;
		this.movieGoer = movieGoer;
	}
	
	public void bookSessionSeat(int row , int column, MovieGoer movieGoer){
		session.assignSeat(row,column);
	}
	
	

}
