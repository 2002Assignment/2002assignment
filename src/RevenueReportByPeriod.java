import java.text.SimpleDateFormat;
import java.util.*;

public class RevenueReportByPeriod extends RevenueReport{

	RevenueReportByPeriod(ArrayList<Movie> m, ArrayList<Cineplex> c,
			ArrayList<Booking> b) {
		super(m, c, b);
		
	}

	private SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyymmddhhmm");
	private HashMap<String, Double> revenueDayMap = new HashMap<String, Double>();
	private HashMap<Date, HashMap> revenueMap = new HashMap<Date, HashMap>();
	private HashMap<Date, Double> totalRevenueMap = new HashMap<Date, Double>();
	private double revenue;
	private double totalRevenue;
	
	// to calculate revenue for each day
	public void calculateRevenue(){
		Calendar currentDate = Calendar.getInstance(); 
		
		Date today = new Date();
		Date target = firstDayOfMonth(today);
		
		while(target.before(today)){
			for(Cineplex c: cineplexList){
				revenueDayMap.clear();
				revenue= 0;
				for (Booking b : bookingList){
					if((b.getCineplexName() == c.getCineplexName()) & (b.getCurrentDate().equals(target))){
							revenue+=b.getPrice();
					}
				}
				revenueDayMap.put(c.getCineplexName(), revenue);			
			}
			revenueMap.put(target, revenueDayMap);
			addDays(target,1);
		}
	
		for(Date key : revenueMap.keySet()){
			totalRevenue = 0;
			for(double r : revenueDayMap.values())
				totalRevenue += r;
			totalRevenueMap.put(key, totalRevenue);
		}
}

	//change Date to Calendar
	public static Calendar DateToCalendar(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
		}
	
	//get first date of the current month
	public static Date firstDayOfMonth(Date date) {
		   Calendar calendar = Calendar.getInstance();
		   calendar.setTime(date);
		   calendar.set(Calendar.DATE, 1);
		   return calendar.getTime();
		}
	
	//increment date
	public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
	
	//print the report
	public void printReport(){
		for(Date key: revenueMap.keySet()){
			System.out.format("%-30s", key);
			for(String key1: revenueDayMap.keySet()){
				System.out.format("%-10d", revenueDayMap.get(key1));
				}
			System.out.format("%-10d", totalRevenueMap.get(key));
			System.out.println();
			}
		
		}
			
	}

