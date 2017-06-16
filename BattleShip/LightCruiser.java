/* Name : Mihir Patel
 * Date : June 15, 2017
 * File : LightCruiser.java
 */

public class LightCruiser extends Ship {
    
	/* ---------------- LightCruiser() -------------- */
	LightCruiser() {
		this.length = 5;
		this.hit = new boolean[this.length];
	}
	
	/* ---------------- getShipType() --------------- */
	@Override
	String getShipType() {
		return "light cruiser";
	}

}