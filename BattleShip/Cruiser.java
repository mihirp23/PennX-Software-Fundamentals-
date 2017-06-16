/* Name : Mihir Patel
 * Date : June 15, 2017
 * File : Cruiser.java
 */

public class Cruiser extends Ship {

	/* --------------- Cruiser() ------------- */
	Cruiser() {
		this.length = 6;
		this.hit = new boolean[this.length];
	}
	
	/* --------------- getShipType() -------------- */
	@Override
	String getShipType() {
		return "cruiser";
	}

}