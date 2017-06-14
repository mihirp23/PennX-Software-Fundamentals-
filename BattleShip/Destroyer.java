
public class Destroyer extends Ship {

	Destroyer(){
		this.length = 4;
		this.hit = new boolean[this.length];
	}
	
	@Override
	String getShipType() {
		return "destroyer";
	}

}
