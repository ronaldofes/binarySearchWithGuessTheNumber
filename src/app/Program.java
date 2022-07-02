package app;

import java.util.Scanner;

import domains.BinaryPlayer;
import domains.Game;
import domains.GameNumber;

public class Program {
	public static void main(String[] args) {
		Scanner sc = GameNumber.openScanner();
		int range = GameNumber.askTheNumber(sc, "Please Choose a Range");

		GameNumber number = new GameNumber(range);

		Game game = new Game(number);

		BinaryPlayer computerPlayer = new BinaryPlayer(game, number);
		
		System.out.println("Who will guess the number, you or the computer?");
		System.out.println("Type 1 to Computer.");
		System.out.println("Type 2 to You.");
		sc.nextLine();
		
		String whoPlay = sc.nextLine();
		Boolean result = false;
		while (whoPlay!="1" || whoPlay!="2") {
			
			if("1".equals(whoPlay)) {
				result = computerPlayer.binaryWin();
				break;
			}
			if("2".equals(whoPlay)) {
				result = game.gamePlay();
				break;
			}
			System.out.println("Invalid Option, please try again.");
			whoPlay = sc.nextLine();
		}

		if (result) {
			System.out.println("=================");
			System.out.println("You win in " + number.getTriesToWin() + " tries!");
		} else {
			System.out.println("=================");
			System.out.println("Not good! You loose!");
		}

		GameNumber.closeScanner(sc);
	}
}
