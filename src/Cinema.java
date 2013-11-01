
public class Cinema {
	private String cinemaCode;
	private boolean isNormal;

	
	
	public Cinema(String cinemaCode, boolean isNormal) {
		this.cinemaCode = cinemaCode;
		this.isNormal = isNormal;
	}
	
	public String getCinemaCode() {
		return cinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		this.cinemaCode = cinemaCode;
	}
	public  boolean isCinemaNormal(){
		return isNormal;
	}
}
