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
		
		@SuppressWarnings("unchecked")
		ArrayList <Cineplex> cineplexList=(ArrayList)Database.deserialize("Cineplexes.dat");
		ArrayList <Movie> movieList=(ArrayList)Database.deserialize("Movies.dat");
	    ArrayList <Session> sessionList=(ArrayList)Database.deserialize("Sessions.dat");
	    ArrayList <Booking> bookingList=(ArrayList)Database.deserialize("Bookings.dat");
	    ArrayList<Date> holidayList=(ArrayList)Database.deserialize("Holidays.dat");
	    PriceSetting priceSetting=(PriceSetting)Database.deserialize2("PriceSetting.dat");
	    String pwd=staff.inputPwd();
	    while(true){
			if (pwd.equals(accessKey)){
		    	do{
				System.out.println("====Welcome to Admin System===");
				System.out.println("1.add movie                  |");
				System.out.println("2.delete movie               |");
				System.out.println("3.update movie               |");
				System.out.println("4.add movie session          |");
				System.out.println("5.update movie session       |");
				System.out.println("6.delete movie session       |");
				System.out.println("7.set price                  |");
				System.out.println("8.set public holiday         |");
				System.out.println("9.generate revenue report    |");
				System.out.println("10.quit                      |");
				System.out.println("==============================");
				Scanner sc=new Scanner(System.in);
				choice=sc.nextInt();
				switch(choice){
				case 1:
					staff.addMovie(movieList);
					break;
				case 2:
					staff.deleteMovie();
					break;
				case 3:
					staff.updateMovie();
					break;
				case 4:
					staff.addMovieSession();
					break;
				case 5:
					try {
						staff.updateMovieSession();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 6:
					staff.deleteMovieSession();
					break;
				case 7:
					staff.setPrice(priceSetting);
					break;
				case 8:
					staff.setHoliday(holidayList);				
					break;
				case 9:
					System.out.println("_____________");
					System.out.println("1)by period;\n2)by movie;\n3)by cineplex;");
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

		    	}while(choice<10);
		    	break;
			}
			else {
				System.out.println("Invalid Access.");
				pwd=staff.inputPwd();
			};
	}	
	}
	
}