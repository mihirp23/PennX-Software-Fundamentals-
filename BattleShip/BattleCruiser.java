
public class BattleCruiser extends Ship {
	
	public BattleCruiser() {
		this.length = 7;
		this.hit = new boolean[this.length];
	}

	@Override
	String getShipType() {
		return "battlecruiser";
	}

}
