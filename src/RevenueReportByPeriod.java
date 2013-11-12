import java.text.SimpleDateFormat;
import java.util.*;


public class RevenueReportByPeriod extends RevenueReport{

	RevenueReportByPeriod(ArrayList<Movie> m, ArrayList<Cineplex> c,
			ArrayList<Booking> b) {
		super(m, c, b);
		
	}

	private SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyyMMdd");

	private double revenue;
	private double totalRevenue;
	
	// to calculate revenue for each day
	@SuppressWarnings("deprecation")
	public void printRevenueReport(){
		 
		String months[] = {"January", "February", "March", "April",
                "May", "June", "July", "August", "September",
                "October", "November", "December"};
		Date today = new Date();
	
		
		Date target = firstDayOfMonth(today);
		
		System.out.println("=======Revenue Report By Day (S$)======");
		while(target.getMonth() == today.getMonth()){
			totalRevenue=0;
			System.out.printf("---------%s----------\n",dateFormatter.format(target));
			
			for(Cineplex c: cineplexList){
				System.out.printf("%-15s : ", c.getCineplexName());
				revenue= 0;
				for (Booking b : bookingList){
					if((b.getCineplexName().equals(c.getCineplexName())) & (b.getCurrentDate().equals(target))){
							revenue+=b.getPrice();
					}
					
				}
				
				System.out.printf("%8.1f\n",revenue);
				totalRevenue+=revenue;
			}
			System.out.printf("%-15s : %-8.1f\n", "TOTAL REVENUE", totalRevenue);
			target=addDays(target,1);
			}
		
		System.out.println();
		int month =0;
		target = firstDayOfYear(today);
		System.out.println("=======Revenue Report By Month (S$)======");
		while(month <= 11){
			totalRevenue=0;
			System.out.printf("---------%-10s---------\n", months[month]);
			
			for(Cineplex c: cineplexList){
				revenue= 0;
			System.out.printf("%-15s : ", c.getCineplexName());
			
			for (Booking b : bookingList){
					if((b.getCineplexName().equals(c.getCineplexName())) &(b.getCurrentDate().getMonth()==month)){
							revenue+=b.getPrice();
					}
				}
			totalRevenue+=revenue;
			System.out.printf("%-8.1f\n",revenue);
			}
			System.out.printf("%-15s : %-8.1f\n", "TOTAL REVENUE", totalRevenue);
			month++;		
			}
	
	
}


	
	//get first date of the current month
	public Date firstDayOfMonth(Date date) {
		   Calendar calendar = Calendar.getInstance();
		   calendar.setTime(date);
		   calendar.set(Calendar.DATE, 1);
		   return calendar.getTime();
		}
	
	public Date firstDayOfYear(Date date) {
		   Calendar calendar = Calendar.getInstance();
		   calendar.setTime(date);
		   calendar.set(Calendar.MONTH, 0);
		   calendar.set(Calendar.DATE, 1);
		   return calendar.getTime();
		}
	
	//increment date
	public Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }	
	}
