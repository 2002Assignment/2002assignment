
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
		db.serialize(holidays, "Holiday.dat");
	}
	public void setPrice(double basicPrice){
		PriceSetting priceSetting=new PriceSetting();
		System.out.println("The current price setting : ");
		System.out.println("Basic price: "+ priceSetting.getPriceBasic());
		
	}
	public void setMovie(){
		
	}
	public void updateMovie(){
		
	}
	public void generateRevenueReport(RevenueReport RV){
		
	}

}
