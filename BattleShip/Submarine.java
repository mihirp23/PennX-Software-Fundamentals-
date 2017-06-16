/* Name : Mihir Patel
 * Date : June 15, 2017
 * File : Submarine.java
 */

public class Submarine extends Ship {

	/* ----------------- Submarine() -------------- */
	Submarine() {
		this.length = 3;
		this.hit = new boolean[this.length];
	}
	
	/* ---------------- getShipType() ------------ */
	@Override
	String getShipType() {
		return "submarine";
	}

}