
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
		if (ocean.isOccupied(row, column)) {
			return false;
		}
		
		if (horizontal) {
			// ship "sticks" out of the board
			if (column + this.length > 20) {
				return false;
			}
			
			// touches horizontally
			if (ocean.isOccupied(row, column + this.length + 1)) {
				return false;
			}
			
			// check to see if a ship would touch any other ships vertically
			// or diagonally should it be placed at this point
			for (int j = column + 1; j < column + this.length; j++) {
				
				// another ship is already occupied at one of the points
				if (ocean.isOccupied(row, j)) {
					return false;
				}
				
				if (row > 0) {
					// touching vertically
					if (ocean.isOccupied(row - 1, j)) {
						return false;
					}
					
					// touching diagonally
					if (ocean.isOccupied(row - 1, j - 1)) {
						return false;
					}
					if (ocean.isOccupied(row - 1, j + 1)) {
						return false;
					}
				}
				if (row < 20) {
					// touching vertically
					if (ocean.isOccupied(row + 1, j)) {
						return false;
					}
					
					// touching diagonally
					if (ocean.isOccupied(row + 1, j - 1)) {
						return false;
					}
					if (ocean.isOccupied(row + 1, j + 1)) {
						return false;
					}
				}
			}
			
		}
		else { // not horizontal (ie. vertical)
			// ship "sticks" out of the board
			if (row + this.length > 20) {
				return false;
			}
			
			// touches vertically
			if (ocean.isOccupied(row + this.length + 1, column)) {
				return false;
			}
			
			// check to see if the ship would touch any other ship
			// horizontally or diagonally should it be placed at this point.
			for (int i = row; i < row + this.length; i++) {
				
				// another ship is already occupied
				if (ocean.isOccupied(i, column)) {
					return false;
				}
				
				if (i  > 0) {
					// touches horizontally
					if (ocean.isOccupied(i - 1, column)) {
						return false;
					}
					
					// touches diagonally
					if (ocean.isOccupied(i - 1, column - 1)) {
						return false;
					}
					if (ocean.isOccupied(i - 1, column + 1)) {
						return false;
					}
				}
				if (i < 20) {
					// touches horizontally
					if (ocean.isOccupied(i + 1,  column)) {
						return false;
					}
					
					// touches diagonally
					if (ocean.isOccupied(i + 1, column - 1)) {
						return false;
					}
					if (ocean.isOccupied(i + 1,  column + 1)) {
						return false;
					}
				}
				
			}
			
		}
		
		// at this point, we can say the ship is okay to be placed here.
		return true;
	}
	
	
	
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		// todo
	}
	
	boolean shootAt(int row, int column) {
		// todo
		return false;
	}
	
	boolean isSunk() {
		for (int i = 0; i < this.length; i++) {
			if (hit[i]== false) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		// todo
		return "S";
	}
}
