import java.util.*;

public class RevenueReportByCineplex extends RevenueReport{
	
	private HashMap<String, HashMap> revenueMap = new HashMap<String, HashMap>();
	private HashMap<String, Double> revenueCineplexMap = new HashMap<String, Double>();
	private HashMap<String, Double> totalRevenueMap = new HashMap<String, Double>();
	private double revenue;
	private double totalRevenue;
	
	RevenueReportByCineplex(ArrayList<Movie> m, ArrayList<Cineplex> c,
			ArrayList<Booking> b) {
		super(m, c, b);
		// TODO Auto-generated constructor stub
	}
	
	public void calculateRevenue(){
		
		for(Cineplex c : cineplexList){
			revenueCineplexMap.clear();
			for (Movie m : movieList){
				for (Booking b : bookingList)
					if(b.getMovieName() == m.getMovieName() & b.getCineplexName() == c.getCineplexName()){
								revenue+=b.getPrice();
								}
				revenueCineplexMap.put(c.getCineplexName(),revenue);
			}
				revenueMap.put(c.getCineplexName(), revenueCineplexMap);
			}

			for(String key : revenueMap.keySet()){
				totalRevenue = 0;
				for(double r : revenueCineplexMap.values())
					totalRevenue += r;
				totalRevenueMap.put(key, totalRevenue);
		}
	}
	

		public void printReport(){
			for(String key: revenueMap.keySet()){
				System.out.format("%-30s", key);
				for(String key1: revenueCineplexMap.keySet()){
					System.out.format("%-10d", revenueCineplexMap.get(key1));
					}
				System.out.format("%-10d", totalRevenueMap.get(key));
				System.out.println();
				}
			
			}

}
