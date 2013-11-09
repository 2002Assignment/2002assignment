import java.io.Serializable;
import java.util.Arrays;


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
	
	public String getCineplexName(){
		return cineplexName;
	}
	
	public void setCineplexName(String name){
		cineplexName = name;
	}
	@Override
	public String toString() {
		return "Cineplex [cineplexName=" + cineplexName + ", cinema="
				+ Arrays.toString(cinema) + "]";
	}
}
