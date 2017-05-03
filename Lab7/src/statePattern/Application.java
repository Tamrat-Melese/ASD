package statePattern;

public class Application {

	public static void main(String[] args) {
		CeilingFan fan = new CeilingFan();
		fan.pullGreen();
		fan.pullGreen();
		fan.pullGreen();
		fan.pullGreen();
		fan.pullRed();
		fan.pullRed();
	}
}
