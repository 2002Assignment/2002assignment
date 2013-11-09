import java.util.*;

public class RevenueReportByMovie extends RevenueReport{

	private HashMap<String, HashMap> revenueMap = new HashMap<String, HashMap>();
	private HashMap<String, Double> revenueMovieMap = new HashMap<String, Double>();
	private HashMap<String, Double> totalRevenueMap = new HashMap<String, Double>();
	private double revenue;
	private double totalRevenue;
	
	RevenueReportByMovie(ArrayList<Movie> m, ArrayList<Cineplex> c,
			ArrayList<Booking> b) {
		super(m, c, b);
		// TODO Auto-generated constructor stub
	}
	
	public void calculateRevenue(){
		
			for (Movie m : movieList){
				revenueMovieMap.clear();
				for (Booking b : bookingList){
					if(b.getMovieName() == m.getMovieName()){
						for(Cineplex c : cineplexList){
							if (c.getCineplexName() == b.getCineplexName()){
								revenue+=b.getPrice();
							}
							revenueMovieMap.put(c.getCineplexName(),revenue);
						}
						revenueMap.put(b.getMovieName(), revenueMovieMap);
					}
				}
			}
			
			for(String key : revenueMap.keySet()){
				totalRevenue = 0;
				for(double r : revenueMovieMap.values())
					totalRevenue += r;
				totalRevenueMap.put(key, totalRevenue);
		}
	}
	
	
	public void printReport(){
		for(String key: revenueMap.keySet()){
			System.out.format("%-30s", key);
			for(String key1: revenueMovieMap.keySet()){
				System.out.format("%-10d", revenueMovieMap.get(key1));
				}
			System.out.format("%-10d", totalRevenueMap.get(key));
			System.out.println();
			}
		
		}

}
