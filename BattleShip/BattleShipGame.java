/* Name : Mihir Patel
 * Date : June 15, 2017
 * File : BattleShipGame.java
 */

public class BattleShipGame {

	public static void main(String[] args) {
		Ocean myOcean = new Ocean();
		myOcean.placeAllShipsRandomly();
		myOcean.print();
	}

}