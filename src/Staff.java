
import java.util.*;
import java.io.*;
import java.text.*;

public class Staff{
	
	
	public String inputPwd(){
		System.out.println("Please input password: ");
		Scanner sc=new Scanner(System.in);
		return sc.nextLine();
	}
	
	public void setHoliday(ArrayList<Date> holidays){  //pass the original list of holidays
		//ArrayList <Date> holidays=new ArrayList<Date>();
		//System.out.println(holidays.get(holidays.size()-1).toString());
		for (Date d: holidays){
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		    System.out.println(dateFormatter.format(d));
		}
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
		db.serialize(holidays, "Holidays.dat");   //write back
		ArrayList<Date> newlist=(ArrayList)db.deserialize("Holidays.dat");
		for (Date d: newlist){
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		    System.out.println(dateFormatter.format(d));
		}
		
	}
	public void setPrice(PriceSetting priceSetting){
	    Database db=new Database();
		priceSetting.setAllPrice();
		db.serialize2(priceSetting, "PriceSetting.dat"); //write back
	}
	public void addMovie(ArrayList<Movie> movieList)throws ParseException{
		MovieSetting movieSetting=new MovieSetting();
        movieSetting.printMovie();
		movieSetting.addMovie();
	}
	public void updateMovie()throws ParseException{
		MovieSetting movieSetting=new MovieSetting();
		movieSetting.printMovie();
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