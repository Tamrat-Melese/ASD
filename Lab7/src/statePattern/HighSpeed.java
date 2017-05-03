package statePattern;

public class HighSpeed implements State {

	private CeilingFan ceilingFan;
	
	public HighSpeed(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}

	@Override
	public void pullGreen() {
		System.out.println("turning off");
		ceilingFan.setState(ceilingFan.getOffSpeed());
	}

	@Override
	public void pullRed() {
		System.out.println("medium speed");
		ceilingFan.setState(ceilingFan.getMediumSpeed());
	}
}