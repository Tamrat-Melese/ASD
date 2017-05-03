package statePattern;

public class MediumSpeed implements State {

	private CeilingFan ceilingFan;
	
	public MediumSpeed(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}

	@Override
	public void pullGreen() {
		System.out.println("high speed");
		ceilingFan.setState(ceilingFan.getHighSpeed());
	}

	@Override
	public void pullRed() {
		System.out.println("low speed");
		ceilingFan.setState(ceilingFan.getLowSpeed());
	}
}
