import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class Booking implements Serializable {
	private String TID;
	
	private Session session;
	private MovieGoer movieGoer;
	
	
	//constructor
	public Booking( Session session, MovieGoer movieGoer) {
		Date currentDate=new Date();
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyymmddhhmm");
		this.TID = session.getCinema().getCinemaCode() +dateFormatter.format(currentDate);;
		this.session = session;
		this.movieGoer = movieGoer;
	}
	
	public void bookSessionSeat(int row , int column, MovieGoer movieGoer){
		session.assignSeat(row,column);
	}
	@Override
	public String toString() {
		return "Booking [TID=" + TID + ", session=" + session.toString() + ", movieGoer="
				+ movieGoer.toString() + "]";
	}

	

}
