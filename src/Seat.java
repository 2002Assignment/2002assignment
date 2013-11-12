import java.io.Serializable;


@SuppressWarnings("serial")
public class Seat  implements Serializable{
	private int row,column;  //index +1
	private boolean isOccupied=false;
	
	public boolean isOccupied() {
		return isOccupied;
	}
	//constructor 
	public Seat(int row, int column) {
		this.setRow(row);
		this.setColumn(column);
	}
	//constructor
	public Seat() {
		this.setRow(1);
		this.setColumn(1);
	}
	public void assign(){
		isOccupied=true;	
	}
	public void unAssign(){
		isOccupied=false;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
}
