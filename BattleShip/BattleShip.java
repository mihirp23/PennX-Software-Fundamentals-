/* Name : Mihir Patel
 * Date : June 15, 2017
 * File : BattleShip.java
 */
public class BattleShip extends Ship {
	
	/* ---------------- BattleShip() ----------- */
	BattleShip() {
		this.length = 8;
		this.hit = new boolean[this.length];
	}

	/* ---------------- getShipType() ---------- */
	@Override
	String getShipType() {
		return "battleship";
	}

}