
import java.util.*;
import java.io.*;
import java.text.*;

public class Staff{
	
	
	public String inputPwd(){
		Scanner sc=new Scanner(System.in);
		return sc.nextLine();
	}
	
	public void setHoliday(ArrayList<Date> holidays){  //pass the original list of holidays
		//ArrayList <Date> holidays=new ArrayList<Date>();
		System.out.println("Please enter the Holiday in this format:yyyy-MM-dd");
		Scanner sc=new Scanner(System.in);
		String holidayInput=sc.nextLine();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {   
			Date date = format.parse(holidayInput);  // Thu Jan 18 00:00:00 CST 2007   
			holidays.add(date);
		} catch (ParseException e) {   
		    e.printStackTrace(); 
		}
		Database db=new Database();
		db.serialize(holidays, "Holiday.dat");   //write back
	}
	public void setPrice(PriceSetting priceSetting){
	    Database db=new Database();
		priceSetting.setAllPrice();
		ArrayList<PriceSetting> newlist=new ArrayList<PriceSetting>();
		newlist.add(priceSetting);
		db.serialize(newlist, "PriceSetting.dat"); //write back
	}
	public void addMovie()throws ParseException{
		MovieSetting movieSetting=new MovieSetting();
		movieSetting.addMovie();
	}
	public void updateMovie()throws ParseException{
		MovieSetting movieSetting=new MovieSetting();
		movieSetting.updateMovie();
	}
	public void generateRevenueReport(RevenueReport RV){
		RV.calculateRevenue();
		RV.printReport();
	}

	public void addMovieSession()throws ParseException{
		SessionSetting sessionSetting=new SessionSetting();
		sessionSetting.addSession();
		
	}
}
