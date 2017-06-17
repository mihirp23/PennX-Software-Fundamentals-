/* Name : Mihir Patel
 * Date : June 15, 2017
 * File : Ship.java
 */
public abstract class Ship {
    
	// instance variables.
    int bowRow;
    int bowColumn;
    int length;
    boolean horizontal;
    boolean [] hit;
    
    /* -------------------- getBowRow() ---------------- */
	public int getBowRow() {
		return bowRow;
	}
	
	/* -------------------- setBowRow() ---------------- */
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}
	
	/* ----------------- getBowColumn() --------------- */
	public int getBowColumn() {
		return bowColumn;
	}
	
	/* ------------------ setBowColumn() --------------- */
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}
	
	/* ------------------- getLength() ----------------- */
	public int getLength() {
		return length;
	}
	
	/* ------------------- setLength() ----------------- */
	public void setLength(int length) {
		this.length = length;
	}
	
	/* ------------------- isHorizontal() -------------- */
	public boolean isHorizontal() {
		return horizontal;
	}
	
	/* ------------------ setHorizontal() -------------- */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	
	/* ------------------- getHit() --------------------- */
	public boolean[] getHit() {
		return hit;
	}
	
	/* -------------------- setHit() -------------------- */
	public void setHit(boolean[] hit) {
		this.hit = hit;
	}
	
	/* -------------------- getShipType() --------------- */
	abstract String getShipType();
	
	/* --------------------- okToPlaceShipAT() ------------------- */
	public boolean okToPlaceShipAt(int row, 
	                               int column, 
	                               boolean horizontal, 
	                               Ocean ocean) {
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
			for (int j = column; j < column + this.length; j++) {
				
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
	
	
	/* ----------------------- placeShipAT() ----------------------- */
	public void placeShipAt(int row,  
			                int column, 
			                boolean horizontal,
			                Ocean ocean) {
		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);
		if (horizontal) {
			for (int j = column; j < column + this.length;j++) {
				ocean.ships[row][j] = this;
			}
		}
		else {
			for (int i = row; i < row + this.length; i++) {
				ocean.ships[i][column] = this;
			}
		}
	}
	
	/* ------------------------ shootAt() ------------------------ */
	boolean shootAt(int row, int column) {
		if (row < 0 || row > 19 || column < 0 || column > 19) {
			return false;
		}
		
		if (this.horizontal) {
			if (this.bowRow == row && column < this.bowColumn + this.length) {
				hit[column % this.length] = true;
				return true;
			}
		}
		else {
			if (this.bowColumn == column && row < this.bowRow + this.length) {
				hit[row % this.length] = true;
				return true;
			}
		}
		return false;
	}
	
	/* ----------------------- isSunk() --------------------- */
	boolean isSunk() {
		for (int i = 0; i < this.length; i++) {
			if (hit[i] != true) {
				return false;
			}
		}
		return true;
	}
	
	/* --------------------- toString() --------------------- */
	@Override
	public String toString() {
		// todo
		if (this.isSunk()) {
			return "x";
		}
		else {
			return "s";
		}
	}
}
