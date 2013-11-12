import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.io.*;

@SuppressWarnings("serial")
public class Session implements Serializable {
	
	
	private Movie movie;

	private Cineplex  cineplex;
	private Cinema cinema;
	private Date dateMovieStart;
	private Seat[][] seatLayout; 
    
   
	@Override
	public String toString() {
		return "Session [movie=" + movie.getMovieName() + ", cineplex=" + cineplex.getCineplexName()
				+ ", cinema=" + cinema.getCinemaCode() + ", dateMovieStart=" + dateMovieStart
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
		return seatLayout[row-1][column-1].isOccupied();
	}
	
	public Date getDateMovieStart(){
		return dateMovieStart;
	}
	
    public boolean assignSeat(int row, int column){
		
		if(!isSeatOccupied(row,column)){
		    seatLayout[row-1][column-1].assign();
		    System.out.println("Seat Assigned!");
		    return true;
		}
		else{
			System.out.println("Seat has already been occupied  to  another customer.");
			return false;
		}
		
	}
    
    public void unAssignSeat(int row, int column){
		seatLayout[row-1][column-1].unAssign();
    }	
		
	
    public void printSessionLayout(){
    	
    	if (cinema.isCinemaNormal()){
    		System.out.println("============SCREEN=============");
	    	for (int row=0;row<10;row++){
	    		for(int col=0;col<10;col++){
	    			if(!seatLayout[row][col].isOccupied())
	    				System.out.print("[ ]");
	    			else
	    				System.out.print("[X]");
	    			if (col==5)
	    				System.out.print("_");		
	    		}
	    	System.out.println();
	    	}
    	}
    	else{
    		System.out.println(" =====SCREEN=====");
    		for (int row=0;row<5;row++){
	    		for(int col=0;col<5;col++){
	    			if(!seatLayout[row][col].isOccupied())
	    				System.out.print("[ ]");
	    			else
	    				System.out.print("[X]");
	    			if (col==2)
	    				System.out.print("__");	
	    		}
    		System.out.println();
    		}
    	}
    }
    
    public void printInvoice(MovieGoer movieGoer, double price){
    	
    	System.out.println("Your name: "+movieGoer.getName());
    	System.out.println("Movie name: "+getMovie());
    	System.out.println("Date and Time: "+dateMovieStart);
    	System.out.println("Price: "+price);
    	System.out.println("Movie name: "+getMovie());
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
		
		if(movieType.equals("3D")){
	        price += priceSetting.getPrice3D();
	        //System.out.println("price ++ 3D price +++");
		}
		// check public holiday, weekends
		if (checkHoliday(dateMovieStart)){
		    price += priceSetting.getPriceHoliday();
		
		}
		if(isNormal == 0)
			price += priceSetting.getPricePlatinum();
		
		return price;
	}
	
	@SuppressWarnings("deprecation")
	public static boolean checkHoliday(Date dateMovieStart){
		boolean isHoliday=false;
		ArrayList<Date> holidays=(ArrayList<Date>)Database.deserialize("Holidays.dat");
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyyMMdd");
		String dateMovieStartstr=dateFormatter.format(dateMovieStart);		
		for (Date d:holidays){
			String dstr=dateFormatter.format(d);
				
            if (dateMovieStartstr.equals(dstr)){
		       isHoliday=true;
		      
		       break;
		     }
		}
				int year=dateMovieStart.getYear();
				int month=dateMovieStart.getMonth();
				int day=dateMovieStart.getDay();
	    Calendar cal = new GregorianCalendar(year, month - 1, day);
	   
	    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	   
	    if ((Calendar.SUNDAY+5) == dayOfWeek || (Calendar.SATURDAY-2) == dayOfWeek){
	    	
	    	isHoliday=true;
	    }
	   
		return isHoliday;
	}

}
