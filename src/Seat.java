import java.io.Serializable;


public class Seat  implements Serializable{
	private int row,column;  //index +1
	private boolean isOccupied=false;
	
	public boolean isOccupied() {
		return isOccupied;
	}
	//constructor 
	public Seat(int row, int column) {
		this.row = row;
		this.column = column;
	}
	//constructor
	public Seat() {
		this.row =1;
		this.column =1;
	}
	public void assign(){
		isOccupied=true;	
	}
	public void unAssign(){
		isOccupied=false;
	}
	
}
