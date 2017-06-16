/* Name : Mihir Patel
 * Date : June 15, 2017
 * File : BattleCruiser.java
 */
public class BattleCruiser extends Ship {
	
	/* ------------- BattleCruiser() ------------- */
	public BattleCruiser() {
		this.length = 7;
		this.hit = new boolean[this.length];
	}

	/* -------------- getShipType() --------------- */
	@Override
	String getShipType() {
		return "battlecruiser";
	}

}