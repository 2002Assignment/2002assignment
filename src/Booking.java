import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Booking implements Serializable {
	private String TID;

	private Session session;
	private MovieGoer movieGoer;
	private int row;
	private int column;
	private double price;
	private Date currentDate;
	private int ticketType;
	//constructor
	public Booking(int seatRow, int seatColumn, Session session, MovieGoer movieGoer,int ticketType) {
		Date currentDate=new Date();
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyyMMddHHmm");
		this.TID = session.getCinema().getCinemaCode() +dateFormatter.format(currentDate);
		this.session = session;
		this.movieGoer = movieGoer;
		this.column=seatColumn;
		this.row=seatRow;
		this.price=session.getSessionTicketPrice();
		//System.out.println("booking price : "+this.price);
		this.currentDate=currentDate;
		this.ticketType=ticketType;
	}
	
	public Booking(String currentDate, int seatRow, int seatColumn, Session session, MovieGoer movieGoer,int ticketType) throws ParseException {
		
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyyMMddHHmm");
		
		this.session = session;
		this.movieGoer = movieGoer;
		this.column=seatColumn;
		this.row=seatRow;
		this.price=session.getSessionTicketPrice();
		//System.out.println("booking price : "+this.price);
		this.currentDate= getBookDate();
		this.TID = session.getCinema().getCinemaCode() +dateFormatter.format(getBookDate());
		this.ticketType=ticketType;
	}
   public Date getBookDate(){
	   Date sessionDate=session.getdateMovieStart();  // get movie date on 
		Calendar cal = Calendar.getInstance();
       cal.setTime(sessionDate);
       cal.add(Calendar.DATE, -10); //minus number would decrement the days
       Date currentDate=cal.getTime();
	   return currentDate;
   } 
	public double getTicketTypeDiscount(){
	
		Database db=new Database();
		PriceSetting ps=(PriceSetting)db.deserialize2("PriceSetting.dat");

		if (ticketType==1)
			return 1;
		else if(ticketType==2)
			return ps.getDiscountSenior();
		else return ps.getDiscountChild();
	}
	public String getMovieName(){
		return session.getMovie().getMovieName();
	}
	
	public Date getCurrentDate() {
		return currentDate;
	}



	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}



	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCineplexName(){
	    return session.getCineplex().getCineplexName();

	}


	public void bookSessionSeat(MovieGoer movieGoer){
		session.assignSeat(row,column);
	}


	public void printTicket() {
		System.out.println("=================TICKET=================");
		System.out.println("TID:        "+TID);
		System.out.println("Moive:      "+session.getMovie().getMovieName());
		System.out.println("Cineplex:   "+session.getCineplex().getCineplexName());
		System.out.println("Cinema:     "+session.getCinema().toString());
		System.out.println("Start Time: "+session.getdateMovieStart());
		System.out.println("Seat:       "+"Row "+row+" Column "+column);
		if (Session.checkHoliday(session.getdateMovieStart()))
		    System.out.println("Holiday/weekend price:");
		System.out.println("TicketTypeDiscount:"+this.getTicketTypeDiscount()*100+"%");
		
		System.out.println("Price:      "+price*this.getTicketTypeDiscount());
		System.out.println("========================================");

	}
	public void printInvoice(){
		System.out.println("============INVOICE=============");
		System.out.println("Moive:       "+session.getMovie().getMovieName());
		System.out.println("Cineplex:    "+session.getCineplex().getCineplexName());
		System.out.println("Cinema:      "+session.getCinema().toString());
		System.out.println("Start Time:  "+session.getdateMovieStart());
		System.out.println("Seat:        "+"Row "+row+" Column "+column);
		if (Session.checkHoliday(session.getdateMovieStart()))
		System.out.println("Holiday/Weekend Price");
		System.out.println("Discount:    "+this.getTicketTypeDiscount()*100+"%");
		System.out.println("Price:       "+price*this.getTicketTypeDiscount());
		System.out.println("================================");
		System.out.println("Confirm to proceed payment?");
	}

	public MovieGoer getMovieGoer() {
	
		return movieGoer;
	}

	


}
