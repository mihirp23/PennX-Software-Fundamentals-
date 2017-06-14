
public abstract class Ship {
    
    int bowRow;
    int bowColumn;
    int length;
    boolean horizontal;
    boolean [] hit;
    
	public int getBowRow() {
		return bowRow;
	}
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}
	public int getBowColumn() {
		return bowColumn;
	}
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public boolean isHorizontal() {
		return horizontal;
	}
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	public boolean[] getHit() {
		return hit;
	}
	public void setHit(boolean[] hit) {
		this.hit = hit;
	}
	
	abstract String getShipType();
	
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		// todo
		return false;
	}
	
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		// todo
	}
	
	boolean shootAt(int row, int column) {
		// todo
		return false;
	}
	
	boolean isSunk() {
		// todo 
		return false;
	}
	
	@Override
	public String toString() {
		// todo
		return "S";
	}
}
