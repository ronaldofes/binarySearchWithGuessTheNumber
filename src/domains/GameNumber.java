package domains;

import java.util.Scanner;

public class GameNumber {
	private Integer range;
	private Integer randomNumber;
	private Integer tries;
	private Integer triesToWin = 1;

	public GameNumber(Integer range) {
		setRange(range);
		setRandomNumber(createRandomNumber());
		setTries(createNumberOfTries());
	}

	private Integer createRandomNumber() {
		return (int) Math.round((Math.random() * (range)));
		
	}

	public void setRandomNumber(Integer randomNumber) {
		this.randomNumber = randomNumber;
	}

	public Integer createNumberOfTries() {
		Integer tries = 1;
		Integer aux = range;
		while (aux >= 2) {
			tries++;
			aux /= 2;
		}
		return tries;
	}
	
	public static Integer askTheNumber(Scanner sc, String message) {
		System.out.println(message);
		return sc.nextInt();
	}

	public static Scanner openScanner() {
		return new Scanner(System.in);
	}

	public static void closeScanner(Scanner sc) {
		sc.close();
	}

	public void setTries(Integer tries) {
		this.tries = tries;
	}

	public void setRange(Integer range) {
		this.range = range;
	}

	public Integer getRange() {
		return range;
	}

	public Integer getRandomNumber() {
		return randomNumber;
	}

	public Integer getTries() {
		return tries;
	}

	public Integer getTriesToWin() {
		return triesToWin;
	}

	public void setTriesToWin(Integer triesToWin) {
		this.triesToWin = triesToWin;
	}

}
