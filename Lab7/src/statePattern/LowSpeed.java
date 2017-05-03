package statePattern;

public class LowSpeed implements State {
	
	private CeilingFan ceilingFan;
	
	public LowSpeed(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}

	@Override
	public void pullGreen() {
		System.out.println("medium speed");
		ceilingFan.setState(ceilingFan.getMediumSpeed());
	}

	@Override
	public void pullRed() {
		System.out.println("turning off");
		ceilingFan.setState(ceilingFan.getOffSpeed());
	}

}
