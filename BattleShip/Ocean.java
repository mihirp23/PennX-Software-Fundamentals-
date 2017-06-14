
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
		BattleShip bShip = new BattleShip();
		bShip.setBowRow(0);
		bShip.setBowColumn(0);
		bShip.setHorizontal(true);
		
		EmptySea eSea = new EmptySea();
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				ships[i][j] = eSea;
			}
		}
		
		ships[0][0] = bShip;
		
	}
	
	public boolean isOccupied(int row, int column) {
		if (ships[row][column].getShipType() != "empty") {
			return true;
		}
        return false;		
	}
	
	public boolean shootAt(int row, int column) {
		
		if (ships[row][column].getShipType() == "empty") {
			return false;
		}
		
		if  (ships[row][column].isSunk() == false) {
			// todo
			this.shotsFired++;
			this.hitCount++;
		}
		return true;
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
	}

}
