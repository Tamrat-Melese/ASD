package statePattern;

public class CeilingFan {
	
	private State offSpeed; 
	private State lowSpeed;
	private State mediumSpeed;
	private State highSpeed;
	
	private State state;
	
	public CeilingFan() {
		offSpeed = new OffSpeed(this);
		lowSpeed = new LowSpeed(this);
		mediumSpeed = new MediumSpeed(this);
		highSpeed = new HighSpeed(this);
		
		state = offSpeed;
	}

	public void pullGreen() {
		state.pullGreen();
	}

	public void pullRed() {
		state.pullRed();
	}

	void setState(State state) {
		this.state = state;
	}
    public State getState() {
        return state;
    }

	public State getOffSpeed() {
		return offSpeed;
	}

	public State getLowSpeed() {
		return lowSpeed;
	}

	public State getMediumSpeed() {
		return mediumSpeed;
	}

	public State getHighSpeed() {
		return highSpeed;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("CeilingFan is " + state + "\n");
		return result.toString();
	}
	
	
}
