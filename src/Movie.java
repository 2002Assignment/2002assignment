import java.util.Date;
import java.util.Calendar;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;



public class Movie  implements Serializable {
	private String movieName;
	private Date movieDateOn;
	private Date movieDateOff;
	private String movieType;
	private String rating;
	private int movieLastTime;
	
	
	// constructor 
	public Movie(String movieName, Date movieDateOn, Date movieDateOff,
			String movieType, String rating,int movieLastTime) {
		this.movieName = movieName;
		this.movieDateOn = movieDateOn;
		this.movieDateOff = movieDateOff;
		this.movieType = movieType;
		this.rating = rating;
		this.movieLastTime=movieLastTime;
	}
	//to string
	public String toString() {
		return "Movie [movieName=" + movieName + ", movieDateOn=" + movieDateOn
				+ ", movieDateOff=" + movieDateOff + ", MovieType=" + movieType
				+ ", Rating=" + rating + ",movie last time "+ movieLastTime+"]";
	}
	
	// set get method
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Date getMovieDateOn() {
		return movieDateOn;
	}
	public void setMovieDateOn(Date movieDateOn) {
		this.movieDateOn = movieDateOn;
	}
	public Date getMovieDateOff() {
		return movieDateOff;
	}
	public void setMovieDateOff(Date movieDateOff) {
		this.movieDateOff = movieDateOff;
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
	public void setRating(int movieLastTime) {
		this.movieLastTime = movieLastTime;
	}
	
	

}
