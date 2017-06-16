/* Name : Mihir Patel
 * Date : June 15, 2017
 * File : EmptySea.java
 */
public class EmptySea extends Ship {
	
	/* -------------- EmptySea() -------------- */
	EmptySea() {
		this.length = 1;
	}

	/* -------------- shootAt() --------------- */
	@Override
	boolean shootAt(int row, int column) {
		return false;
	}
	
	/* ------------- isSunk() ------------------ */
	@Override
	boolean isSunk() {
		return false;
	}
	
	/* --------------- toString() --------------- */
	@Override
	public String toString() {
		return "-";
	}
	
	/* --------------- getShipType() --------------- */
	@Override
	String getShipType() {
		return "empty";
	}

}