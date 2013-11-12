import java.util.Date;
import java.util.Calendar;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;



public class Movie  implements Serializable {
	private String movieName;
	private Date movieDateOn;
	//private Date movieDateOff;
	private String movieType;
	private String rating;
	private int movieLastTime;
	private String movieStatus;
	
	
	// constructor 
	public Movie(String movieName, Date movieDateOn,
			String movieType, String rating,int movieLastTime,String movieStatus) {
		this.movieName = movieName;
		this.movieDateOn = movieDateOn;
		//this.movieDateOff = movieDateOff;
		this.movieType = movieType;
		this.rating = rating;
		this.movieLastTime=movieLastTime;
		this.movieStatus=movieStatus;
	}
	//to string
	public String toString() {
		return "Movie [movieName=" + movieName + ", movieDateOn=" + movieDateOn
				+ ", MovieType=" + movieType
				+ ", Rating=" + rating + ",movie last time "+ movieLastTime+"MovieStatus="+movieStatus+"]";
	}
	
	// set get method
	public String getMovieStatus() {
		return movieStatus;
	}
	public void setMovieStatus(String movieStatus) {
		this.movieStatus = movieStatus;
	}
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		//System.out.println(this.movieName + movieName);
		this.movieName = movieName;
	}
	public Date getMovieDateOn() {
		return movieDateOn;
	}
	public void setMovieDateOn(Date movieDateOn) {
		this.movieDateOn = movieDateOn;
	}
	
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public int getMovieLastTime() {
		return movieLastTime;
	}
	public void setMovieLastTime(int movieLastTime) {
		this.movieLastTime = movieLastTime;
	}

}
