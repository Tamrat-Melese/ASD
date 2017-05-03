package statePattern;

public class OffSpeed implements State {

	private CeilingFan ceilingFan;
	
	public OffSpeed(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}

	@Override
	public void pullGreen() {
		System.out.println("low speed");
		ceilingFan.setState(ceilingFan.getLowSpeed());
	}

	@Override
	public void pullRed() {
		System.out.println("high speed");
		ceilingFan.setState(ceilingFan.getHighSpeed());
	}

}
