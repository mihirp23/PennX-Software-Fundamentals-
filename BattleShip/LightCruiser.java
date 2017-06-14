
public class LightCruiser extends Ship {

	LightCruiser() {
		this.length = 5;
		this.hit = new boolean[this.length];
	}
	
	@Override
	String getShipType() {
		return "light cruiser";
	}

}
