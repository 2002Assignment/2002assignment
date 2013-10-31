
public class Cineplex { 
      
    private String cineplexName; 
    private Cinema[] cinema; 
      
    public Cineplex() { 
        cineplexName = null; 
        Cinema[] cinema = new Cinema[3]; 
          
        // TODO Auto-generated constructor stub 
    } 
  
    public Cineplex(String name, int size){ 
        this.cineplexName = name; 
        Cinema[] cinema = new Cinema[size]; 
          
          
    } 
      
    public String getCineplexName(){ 
        return cineplexName; 
    } 
      
    public void setCineplexName(String name){ 
        cineplexName = name; 
    } 
} 
