
public class BattleShip extends Ship {
	
	BattleShip() {
		this.length = 8;
		this.hit = new boolean[this.length];
	}

	@Override
	String getShipType() {
		return "battleship";
	}

}
