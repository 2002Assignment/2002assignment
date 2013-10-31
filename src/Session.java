import java.util.Calendar; 
  
  
public class Session { 
      
      
    private String movie; 
    private String cineplex; 
    private String cinema; 
    private Calendar Date, Time; 
    private Seat seat[][]; 
      
    public Session(String movie, String cineplex, String cinema, Calendar date, 
            Calendar time, Seat[][] seat) { 
      
        this.movie = movie; 
        this.cineplex = cineplex; 
        this.cinema = cinema; 
        Date = date; 
        Time = time; 
        this.seat = seat; 
    } 
      
    public void assignSeat(int row, int column, int email){ 
          
        if(seat[row][column].isOccupied() == false){ 
            seat[row][column].assign(email); 
            System.out.println("Seat Assigned!"); 
        } 
        else
            System.out.println("Seat already assigned to a customer."); 
    } 
  
}