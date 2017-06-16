/* Name : Mihir Patel
 * Date : June 15, 2017
 * File : Destroyer.java
 */
public class Destroyer extends Ship {

	/* --------------- Destroyer() ------------- */
	Destroyer(){
		this.length = 4;
		this.hit = new boolean[this.length];
	}
	
	/* --------------- getShipType() ------------- */
	@Override
	String getShipType() {
		return "destroyer";
	}

}