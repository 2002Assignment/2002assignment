
public class Seat {
	private int row,column;
	private boolean isOccupied=false;
	
	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public Seat(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public void assign(){
		isOccupied=true;
		
	}
	public void unAssign(){
		isOccupied=false;
	}
}
