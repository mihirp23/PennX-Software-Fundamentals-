
public class Submarine extends Ship {

	Submarine() {
		this.length = 3;
		this.hit = new boolean[this.length];
	}
	
	@Override
	String getShipType() {
		return "submarine";
	}

}
