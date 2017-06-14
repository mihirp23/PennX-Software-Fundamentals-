
public class Ocean {
	Ship ships[][] = new Ship[20][20];
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	
	Ocean() {
		shotsFired = 0;
		hitCount = 0;
		shipsSunk = 0;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				EmptySea eSea = new EmptySea();
				ships[i][j] = eSea;
			}
		}
	}
	
	public void placeAllShipsRandomly() {
		// todo
	    // one battleship
		BattleShip bShip = new BattleShip();
		bShip.bowRow = 0;
		bShip.bowColumn = 0;
		bShip.horizontal = true;
		for (int j = 0; j < 8; j++) {
			ships[bShip.bowRow][j] = bShip;
		}
		
	}
	
	public boolean isOccupied(int row, int column) {
		if (ships[row][column].getShipType() != "empty") {
			return true;
		}
        return false;		
	}
	
	public boolean shootAt(int row, int column) {
		if (this.isOccupied(row, column)) {
			if (ships[row][column].isSunk() == false) {
				ships[row][column].shootAt(row, column);
				this.shotsFired++;
				this.hitCount++;
				return true;
			}
		}
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
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (ships[i][j].isSunk() == false) {
					return false;
				}
			}
		}
		return true;
	}
	
	public Ship[][] getShipArray() {
		return this.ships;
	}
	
	public void print() {
		// todo
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (ships[i][j].isSunk() == true) {
				    System.out.print("x");
				}
				else {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}

}
