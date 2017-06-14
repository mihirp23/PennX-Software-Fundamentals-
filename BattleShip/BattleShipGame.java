import java.util.*;
public class BattleShipGame {

	public static void main(String[] args) {
		Ocean myOcean = new Ocean();
		myOcean.placeAllShipsRandomly();
		do {
			myOcean.print();
			System.out.println("Enter a coordinate");
			Scanner in = new Scanner(System.in);
			int row, col;
			row = in.nextInt();
			col = in.nextInt();
			myOcean.shootAt(row, col);
		}while(myOcean.isGameOver() == false);
        myOcean.print();
	}

}
