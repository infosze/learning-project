package src.hu.ak_akademia.oop.bergengocy_regex;

/**
 * <b>Exercise: Bergengocy's Mobile Tariffs (Bergengóc mobiltelefon tarifák)</b>
 * <p>
 * Class for representing call duration.
 *
 * @author A&amp;K Akadémia (Lajos Czuczor)
 */
public class Duration {

	private final int minute;
	private final int second;

	public Duration(int minute, int second) throws RuntimeException {
		if (minute < 0 || second < 0 || second >= 60) {
			throw new RuntimeException("A megadott időtartam nem értelmezhető!");
		}
		this.minute = minute;
		this.second = second;
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}

	public int getTotalSecond() {
		return minute * 60 + second;
	}

	public int getStartedMinutes() {
		return minute + (second == 0 ? 0 : 1);
	}

}
