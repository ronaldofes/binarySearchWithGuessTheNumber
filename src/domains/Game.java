package domains;

public class Game {
	private Integer choosenNumber;

	GameNumber number;

	public Game(GameNumber number) {
		this.number = number;
	}

	public Integer getChoosenNumber() {
		return choosenNumber;
	}

	public void setChoosenNumber(Integer choosenNumber) {
		this.choosenNumber = choosenNumber;
	}

	public Boolean isTheNumber() {
		return this.choosenNumber.intValue() == number.getRandomNumber().intValue();
	}

	public String whereIsTheNumber() {
		if (this.choosenNumber > number.getRandomNumber()) {
			return "The random number is less than choosen number";
		}
		return "The random number is greater than choosen number";
	}

	public boolean gamePlay() {
		while (number.getTries() >= 1) {
			setChoosenNumber(GameNumber.askTheNumber(GameNumber.openScanner(), "Please choose a number"));
			if (isTheNumber()) {
				return true;
			}
			if (number.getTries()>1) {
				System.out.println(whereIsTheNumber());
			}
			number.setTries(number.getTries() - 1);
			number.setTriesToWin(number.getTriesToWin() + 1);
		}
		return false;
	}

}
