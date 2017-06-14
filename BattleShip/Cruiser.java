
public class Cruiser extends Ship {

	Cruiser() {
		this.length = 6;
		this.hit = new boolean[this.length];
	}
	
	@Override
	String getShipType() {
		return "cruiser";
	}

}
