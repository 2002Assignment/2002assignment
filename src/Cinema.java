import java.io.Serializable;


@SuppressWarnings("serial")
public class Cinema  implements Serializable {
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
	public void setNormal(boolean isNormal){
		this.isNormal=isNormal;
	}
	public String toString(){
		String type;
		if (isNormal)
			type="Normal";
		else type="Platinum";
		return cinemaCode+type;
	}
}
