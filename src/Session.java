import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.io.*;

public class Session implements Serializable {
	
	
	private Movie movie;

	private Cineplex  cineplex;
	private Cinema cinema;
	private Date dateMovieStart;
	private Seat[][] seatLayout; 
    
   
	@Override
	public String toString() {
		return "Session [movie=" + movie + ", cineplex=" + cineplex
				+ ", cinema=" + cinema + ", dateMovieStart=" + dateMovieStart
				+ ", seatLayout=" + Arrays.toString(seatLayout) + "]";
	}
	
	//constructor
    public Session() {
		
		this.movie = null;
		this.cineplex =null;
		this.cinema =null;
		this.dateMovieStart = null;
		this.seatLayout=null;
	}
    //constructor 
	public Session(Movie movie, Cineplex cineplex, Cinema cinema,
			Date dateMovieStart) {
		
		this.movie = movie;
		this.cineplex = cineplex;
		this.cinema = cinema;
		this.dateMovieStart = dateMovieStart;
		if (cinema.isCinemaNormal()){
			seatLayout= new Seat [10][10];
			for (int i=0;i<10;i++)
				for (int j=0;j<10;j++)
					seatLayout[i][j]=new Seat(i+1,j+1);
		}
		else{
			seatLayout= new Seat [5][5];
			for (int i=0;i<5;i++)
				for (int j=0;j<5;j++)
					seatLayout[i][j]=new Seat(i+1,j+1);	
		}
	}
	
	public boolean isSeatOccupied(int row,int column){
		return seatLayout[row][column].isOccupied();
	}
	
    public void assignSeat(int row, int column){
		
		if(!isSeatOccupied(row,column)){
		    seatLayout[row][column].assign();
		    System.out.println("Seat Assigned!");
		}
		else
			System.out.println("Seat has already been occupied  to  another customer.");
		
		
	}
    public void printSessionLayout(){
    	//..........
    	
    }
    
    public void printInvoice(MovieGoer movieGoer, double price){
    	
    	System.out.println("Your name: "+movieGoer.getName());
    	System.out.println("Movie name: "+getMovie());
    	System.out.println("Date and Time: "+dateMovieStart);
    	System.out.println("Price: "+price);
    	System.out.println("Movie na: "+getMovie());
    }
    
    public Movie getMovie() {
		return movie;
	}



	public void setMovie(Movie movie) {
		this.movie = movie;
	}



	public Cineplex getCineplex() {
		return cineplex;
	}



	public void setCineplex(Cineplex cineplex) {
		this.cineplex = cineplex;
	}



	public Cinema getCinema() {
		return cinema;
	}



	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}



	public Date getdateMovieStart() {
		return dateMovieStart;
	}



	public void setdateMovieStart(Date dateMovieStart) {
		this.dateMovieStart = dateMovieStart;
	}
	public double getSessionTicketPrice(){
		
		PriceSetting priceSetting = new PriceSetting();
		double price = priceSetting.getPriceBasic();
		
		String movieType = movie.getMovieType();
		int isNormal = cinema.isCinemaNormal()? 1:0;
		
		switch(movieType){
		case "3D": price += priceSetting.getPrice3D();
			break;
		case "Blockbuster": price += priceSetting.getPriceBlockbuster();
			break;
		}
		
		if(isNormal == 0)
			price += priceSetting.getPricePlatium();
		return price;
	}

}
