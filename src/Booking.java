import java.io.*;
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
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyymmddhhmm");
		this.TID = session.getCinema().getCinemaCode() +dateFormatter.format(currentDate);
		this.session = session;
		this.movieGoer = movieGoer;
		this.column=seatColumn;
		this.row=seatRow;
		this.price=session.getSessionTicketPrice()*this.getTicketTypeDiscount();
		this.currentDate=currentDate;
	}
	
	public double getTicketTypeDiscount(){
		double discount=1;
		PriceSetting ps=new PriceSetting();
		switch(ticketType){
		case 1: discount =1; break;
		case 2: discount=ps.getDiscountSenior();break;
		case 3: discount=ps.getDiscountChild();break;
		}
		return discount;
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
		System.out.println("_______________________");
		System.out.println("TID:"+TID);
		System.out.println("Moive:"+session.getMovie().getMovieName());
		System.out.println("Cineplex:"+session.getCineplex().getCineplexName());
		System.out.println("Cinema:"+session.getCinema().getCinemaCode());
		System.out.println("Start Time:"+session.getdateMovieStart());
		System.out.println("Seat:"+"Row "+row+" Column "+column);
		System.out.println("Price:"+price);
		System.out.println("________________________");

	}
	public void printInvoice(){
		System.out.println("___________INVOICE_____________");
		System.out.println("Moive:"+session.getMovie().getMovieName());
		System.out.println("Cineplex:"+session.getCineplex().getCineplexName());
		System.out.println("Cinema:"+session.getCinema().getCinemaCode());
		System.out.println("Start Time:"+session.getdateMovieStart());
		System.out.println("Seat:"+"Row "+row+" Column "+column);
		System.out.println("Price:"+price);
		System.out.println("______________________________");
		System.out.println("Confirm to proceed payment?");
	}

	public MovieGoer getMovieGoer() {
	
		return movieGoer;
	}

	


}
