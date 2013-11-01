
public class Cineplex {
	
	private String cineplexName;
	private Cinema[] cinema;
	
	public Cineplex() {
		cineplexName = null;
		Cinema[] cinema = new Cinema[3];
		
		// TODO Auto-generated constructor stub
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
}
