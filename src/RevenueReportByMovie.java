import java.util.*;

public class RevenueReportByMovie extends RevenueReport{

	private double revenue;
	private double totalRevenue;
	
	RevenueReportByMovie(ArrayList<Movie> m, ArrayList<Cineplex> c,
			ArrayList<Booking> b) {
		super(m, c, b);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("deprecation")
	public void printRevenueReport(){
		Date today = new Date();
		System.out.printf("=======%s Revenue Report By Movie======\n", (1900+today.getYear()));

			for (Movie m : movieList){
				System.out.printf("------%-20s------\n", m.getMovieName());
				totalRevenue = 0;
				for(Cineplex c : cineplexList){
					revenue=0;
					
				for (Booking b : bookingList){
			
					if(b.getMovieName().equals(m.getMovieName())&b.getCurrentDate().getYear()==today.getYear()){
							
							if (c.getCineplexName().equals(b.getCineplexName())){
								
								revenue+=b.getPrice();
																
							}
							
						}
					}
				System.out.printf("%-15s: %8.1f\n",c.getCineplexName(),revenue);
				totalRevenue += revenue;
				
		
				}
				System.out.printf("TOTAL REVENUE  : %8.1f\n", totalRevenue);
	
			}
			System.out.println();
	}
	

}
