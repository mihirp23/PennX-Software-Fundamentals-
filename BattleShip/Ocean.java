
public class Ocean {
	private Ship ships[][] = new Ship[20][20];
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	
	Ocean() {
		shotsFired = 0;
		hitCount = 0;
		shipsSunk = 0;
	}
	
	public void placeAllShipsRandomly() {
		// todo
	}
	
	public boolean isOccupied(int row, int column) {
		// todo
        return false;		
	}
	
	public boolean shootAt(int row, int column) {
		// todo
		return false;
	}
	
	public int getShotsFired() {
		return this.shotsFired;
	}
	
	public int getHitCount() {
		return this.hitCount;
	}
	
	public int getShipsSunk() {
		return this.shipsSunk;
	}
	 
	public boolean isGameOver() {
		// todo
		return false;
	}
	
	public Ship[][] getShipArray() {
		return this.ships;
	}
	
	public void print() {
		// todo
	}

}
