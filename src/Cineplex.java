import java.io.Serializable;
@SuppressWarnings("serial")
public class Cineplex  implements Serializable {
	
	private String cineplexName;


	private Cinema[] cinema;
	
	
	public Cineplex() {
		cineplexName = null;
		Cinema[] cinema = new Cinema[3];
		for (int i=0;i<3;i++)
			cinema[i]=null;
	}

	public Cineplex(String name, Cinema[] cinema){
		this.cineplexName = name;
		this.cinema=cinema;
		
		
	}
	public Cineplex(String name,int num){
		this.cineplexName=name;
		cinema=new Cinema[num];
	}
	
	
	public Cinema[] getCinema() {
		return cinema;
	}

	public void setCinema(Cinema[] cinema) {
		this.cinema = cinema;
	}

	public String getCineplexName(){
		return cineplexName;
	}
	
	public void setCineplexName(String name){
		cineplexName = name;
	}
	@Override
	public String toString() {
		String cinemastr;
		cinemastr=cinema[0].getCinemaCode()+cinema[1].getCinemaCode()+cinema[2].getCinemaCode();
		return "Cineplex [cineplexName=" + cineplexName + ", cinema="
				+ cinemastr + "]";
	}
}
