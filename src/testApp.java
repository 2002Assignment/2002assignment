import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

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
				"3D", "16G");
		Session movie1_1=new Session(movie1, cineplex1, cinema[0],
				dateMovieOn);
		
		movie1_1.assignSeat(1, 1);
		movie1_1.assignSeat(1, 1);
		
		
		

	}

}
