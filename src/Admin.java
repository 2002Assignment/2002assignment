import java.text.ParseException;
import java.util.*;
import java.io.*;

public class Admin {
	private String accessKey="123456";

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public void main2()throws ParseException{
		int choice=0;
		Staff staff=new Staff();
		Database db=new Database();
		ArrayList <Cineplex> cineplexList=(ArrayList)db.deserialize("Cineplexes.dat");
		ArrayList <Movie> movieList=(ArrayList)db.deserialize("Movies.dat");
	    ArrayList <Session> sessionList=(ArrayList)db.deserialize("Sessions.dat");
	    ArrayList <Booking> bookingList=(ArrayList)db.deserialize("Bookings.dat");
	    ArrayList<Date> holidayList=(ArrayList)db.deserialize("Holidays.dat");
	    PriceSetting priceSetting=(PriceSetting)db.deserialize2("PriceSetting.dat");
	    if(staff.inputPwd().equals(accessKey)){
		do{
			System.out.println("====Welcome to Admin System===");
			System.out.println("1.add movie                  |");
			System.out.println("2.add movie session          |");
			System.out.println("3.update movie               |");
			System.out.println("4.set price                  |");
			System.out.println("5.set public holiday         |");
			System.out.println("6.generate revenue report    |");
			System.out.println("7.quit                       |");
			System.out.println("==============================");
			Scanner sc=new Scanner(System.in);
			choice=sc.nextInt();
			switch(choice){
			case 1:
				staff.addMovie(movieList);
				break;
			case 2:
				staff.addMovieSession();
				break;
			case 3:
				staff.updateMovie();
				break;
			case 4:
				staff.setPrice(priceSetting);
				break;
			case 5:
				staff.setHoliday(holidayList);				
				break;
			case 6:
				System.out.println("__________");
				System.out.println("1)by period;2)by movie;3)by cineplex");
				switch(sc.nextInt()){
				case 1:
					RevenueReport rvrpt=new RevenueReportByPeriod(movieList, cineplexList, bookingList);
					staff.generateRevenueReport(rvrpt);
					break;
				case 2:
					rvrpt=new RevenueReportByMovie(movieList, cineplexList, bookingList);
					staff.generateRevenueReport(rvrpt);
					break;
				case 3:
					rvrpt=new RevenueReportByCineplex(movieList, cineplexList, bookingList);
					staff.generateRevenueReport(rvrpt);
					break;
				default:
					System.out.println("Invalid Access");
				}
				break;
			}
		
		}while(choice<7);
	}
	
	}
	
}