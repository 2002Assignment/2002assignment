import java.util.*;

public class RevenueReportByCineplex extends RevenueReport{

	private double revenue;
	private double totalRevenue;
	
	RevenueReportByCineplex(ArrayList<Movie> m, ArrayList<Cineplex> c,
			ArrayList<Booking> b) {
		super(m, c, b);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("deprecation")
	public void printRevenueReport(){
		Date today = new Date();
		System.out.printf("=======%s Revenue Report By Cineplex======\n", today.getYear());
		
		for(Cineplex c : cineplexList){
			System.out.printf("------Cineplex: %-15s------\n", c.getCineplexName());
			totalRevenue = 0;
			for (Movie m : movieList){
				System.out.printf("%-20s : ", m.getMovieName());
				revenue =0;
				
				for (Booking b : bookingList)
					if(b.getMovieName().equals(m.getMovieName()) &(b.getCurrentDate().getYear() == today.getYear())& b.getCineplexName().equals(c.getCineplexName())){
								revenue+=b.getPrice();
								}
				totalRevenue+=revenue;
				System.out.printf("%8.1f\n", revenue);
				
			}
				System.out.printf("%-20s : %8.1f\n", "TOTAL REVENUE", totalRevenue);
				
			}
		System.out.println();
	}


}
