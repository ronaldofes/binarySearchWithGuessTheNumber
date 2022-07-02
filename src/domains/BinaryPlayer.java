package domains;

public class BinaryPlayer {
	private Game game;
	private GameNumber number;

	public BinaryPlayer(Game game, GameNumber randomNumber) {
		this.game = game;
		this.number = randomNumber;
	}

	public Boolean binaryWin() {
		Integer begin = 0;
		Integer end = number.getRange();
		while (number.getTries() > 0) {
			Integer mid = (end + begin) % 2 == 0 ? (end + begin) / 2 : (end + begin + 1) / 2;
			game.setChoosenNumber(mid);
			System.out.println(number.getTriesToWin() + " tries. - Number: " + mid);

			if (game.isTheNumber()) {
				System.out.println("The number is: " + mid);
				return true;
			}

			if (mid > number.getRandomNumber()) {
				end = mid - 1;
			}
			if (mid < number.getRandomNumber()) {
				begin = mid + 1;
			}
			number.setTries(number.getTries() - 1);
			number.setTriesToWin(number.getTriesToWin() + 1);
		}
		return false;
	}
}
