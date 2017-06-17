/* Name : Mihir Patel
 * Date : June 15, 2017
 * File : Ocean.java
 */

import java.util.*;
public class Ocean {
	// instance variables...
	Ship ships[][] = new Ship[20][20];
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	
	/* ------------------ Ocean() ---------------------- */
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
	
	/* ----------- placeAllShipsRandomly() --------------*/
	public void placeAllShipsRandomly() {
		int i, j;
		boolean horizontal = true;
		Random ran = new Random();
		
		// place one battleship randomly
		while (true) {
			i = ran.nextInt(20);
			j = ran.nextInt(20);
			BattleShip bship = new BattleShip();
		    if (bship.okToPlaceShipAt(i, j, horizontal, this)) {
		    	bship.placeShipAt(i, j, horizontal, this);
		    	break;
		    }
		    else if (bship.okToPlaceShipAt(i, j, !horizontal, this)) {
		    	bship.placeShipAt(i, j, !horizontal, this);
		    	break;
		    }
		}
		
		// place one battle cruiser randomly
		while (true) {
			i = ran.nextInt(20);
			j = ran.nextInt(20);
			BattleCruiser bcruiser = new BattleCruiser();
			if (bcruiser.okToPlaceShipAt(i, j, horizontal, this)) {
				bcruiser.placeShipAt(i, j, horizontal, this);
				break;
			}
			else if(bcruiser.okToPlaceShipAt(i, j, !horizontal, this)) {
				bcruiser.placeShipAt(i, j, !horizontal, this);
				break;
			}
		}
		
		// place 2 cruisers randomly
		int cruisers_placed = 0;
		while (cruisers_placed < 2) {
			i = ran.nextInt(20);
			j = ran.nextInt(20);
			Cruiser cruiser = new Cruiser();
			if (cruiser.okToPlaceShipAt(i, j, horizontal, this)) {
				cruiser.placeShipAt(i, j, horizontal, this);
				cruisers_placed++;
			}
			else if(cruiser.okToPlaceShipAt(i, j, !horizontal, this)) {
				cruiser.placeShipAt(i, j, !horizontal, this);
				cruisers_placed++;
			}
		}
		
		// place 2 light cruisers randomly
		int light_cruisers_placed = 0;
		while (light_cruisers_placed < 2) {
			i = ran.nextInt(20);
			j = ran.nextInt(20);
			LightCruiser lcruiser = new LightCruiser();
			if (lcruiser.okToPlaceShipAt(i, j, horizontal, this)) {
				lcruiser.placeShipAt(i, j, horizontal, this);
				light_cruisers_placed++;
			}
			else if(lcruiser.okToPlaceShipAt(i, j, !horizontal, this)) {
				lcruiser.placeShipAt(i, j, !horizontal, this);
				light_cruisers_placed++;
			}
		}
		
		// place 3 destroyers
		int destroyers_placed = 0;
		while (destroyers_placed < 3) {
			i = ran.nextInt(20);
			j = ran.nextInt(20);
			Destroyer dship = new Destroyer();
			if (dship.okToPlaceShipAt(i, j, horizontal, this)) {
				dship.placeShipAt(i, j, horizontal, this);
				destroyers_placed++;
			}
			else if (dship.okToPlaceShipAt(i, j, !horizontal, this)) {
				dship.placeShipAt(i, j, !horizontal, this);
				destroyers_placed++;
			}
		}
		
		// place 4 submarines
		int submarines_placed = 0;
		while(submarines_placed < 4) {
			i = ran.nextInt(20);
			j = ran.nextInt(20);
			Submarine subship = new Submarine();
			if (subship.okToPlaceShipAt(i, j, horizontal, this)) {
				subship.placeShipAt(i, j, horizontal, this);
				submarines_placed++;
			}
			else if(subship.okToPlaceShipAt(i, j, !horizontal, this)) {
				subship.placeShipAt(i, j, !horizontal, this);
				submarines_placed++;
			}
		}
	}
	
	/* ------------------ isOccupied() ------------------------- */
	public boolean isOccupied(int row, int column) {
		// to prevent out of bounds exception
		if (row < 0 || row > 19 || column < 0 || column > 19) {
			return false;
		}
		
		if (ships[row][column].getShipType() != "empty") {
			return true;
		}
        return false;		
	}
	
	/* ----------------- shootAt() ----------------------------- */
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
	
	/* ----------------- getShotsFired() ----------------------- */
	public int getShotsFired() {
		return this.shotsFired;
	}
	
	/* ------------------ getHitCount() ------------------------ */
	public int getHitCount() {
		return this.hitCount;
	}
	
	/* ------------------ getShipsSunk() ----------------------- */
	public int getShipsSunk() {
		return this.shipsSunk;
	}
	
	/* ------------------ isGameOver() ------------------------- */
	public boolean isGameOver() {
		// determine whether all of the ships are sunk
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (ships[i][j].isSunk() == false) {
					return false;
				}
			}
		}
		return true;
	}
	
	/* ------------------ getShipArray() ----------------------- */
	public Ship[][] getShipArray() {
		return this.ships;
	}
	
	/* -------------------- debug_print() ------------------------------ */
	public void debug_print() {
		// todo
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (ships[i][j].getShipType() == "battleship") {
					System.out.print("b |");
				}
				else if (ships[i][j].getShipType() == "battlecruiser"){
					System.out.print("bc|");
				}
				else if (ships[i][j].getShipType() == "cruiser"){
					System.out.print("c |");
				}
				else if (ships[i][j].getShipType() == "light cruiser"){
					System.out.print("lc|");
				}
				else if (ships[i][j].getShipType() == "destroyer"){
					System.out.print("d |");
				}
				else if (ships[i][j].getShipType() == "submarine"){
					System.out.print("s |");
				}
				else {
					System.out.print("- |");
				}
			}
			System.out.println();
		}
	}
	
	/* ----------------------- print() ---------------------------- */
	public void print() {
		for (int i = 0; i < 20; i++) {
			// print grid info to aid user
			if (i == 0) {
				for (int j = 0; j < 20; j++) {
					if (j == 0) {
						System.out.print("   ");
					}
					String formatted = String.format("%02d", j);
					System.out.print(formatted + " ");
				}
				System.out.println();
				for (int j = 0; j < 20; j++) {
					if (j == 0) {
						System.out.print("   ");
					}
					System.out.print("___");
				}
				System.out.println();
			}
			
			// print the ships
			for (int j = 0; j < 20; j++) {
				if (j == 0) {
					String formatted = String.format("%02d", i);
					System.out.print(formatted + "  ");
				}
				System.out.print(ships[i][j] + "  ");
			}
			System.out.println();
		}
	}

}
