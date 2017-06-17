/* Name : Mihir Patel
 * Date : June 15, 2017
 * File : BattleShipGame.java
 */

import java.util.*;
public class BattleshipGame {

	public static void main(String[] args) {
		Ocean myOcean = new Ocean();
		myOcean.placeAllShipsRandomly();
		myOcean.print();
		while (myOcean.isGameOver() == false) {
			System.out.println("Take five shots");
			Scanner in = new Scanner(System.in);
			int [] shots = new int[10];
			boolean invalid_input = false;
			for (int i = 0; i < 10; i++) {
				if (in.hasNextInt()) {
					shots[i] = in.nextInt();
				}
				else {
					System.out.println("You must provide 10 numbers!");
					invalid_input = true;
					break;
				}
			}
			if (invalid_input) {
				continue;
			}
			
			for (int i = 0; i < shots.length; i += 2) {
			    int x = shots[i];
			    int y = shots[i + 1];
			    System.out.println("Shooting at " + x + " , " + y);
			    if (myOcean.shootAt(x, y) == true) {
			        System.out.println("You just shot " + myOcean.ships[x][y].getShipType());	
			    }
			}
			
			myOcean.print();
		}
 }

}