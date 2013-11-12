import java.util.*;


public abstract class RevenueReport {
	protected ArrayList<Movie> movieList;
	protected ArrayList<Cineplex> cineplexList;
	protected ArrayList<Booking> bookingList;
		
	RevenueReport(ArrayList<Movie> m, ArrayList<Cineplex> c, ArrayList<Booking> b){
		this.movieList = m;
		this.cineplexList = c;
		this.bookingList = b;
	}
	
	
	public abstract void printRevenueReport();
	
}
