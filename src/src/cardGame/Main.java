package src.cardGame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * 
 *
 * @author Joshua Ciffer
 * @version 06/05/2018
 */
public final class Main {

	private static ArrayList<Player> players;

	private static Deck deck;

	private static int numPlayers;
	
	private static Scanner userInput;

	/**
	 * Don't let anyone instantiate this class.
	 */
	private Main() {}

	/**
	 *
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		userInput = new Scanner(System.in);
		do {
			System.out.println("Main Menu");
			System.out.print("How many players do you want to have?: ");
			try {
				numPlayers = userInput.nextInt();
			} catch (InputMismatchException e) {
				userInput.next();
				System.out.println("Enter a number fuckwad.");
				continue;
			}
			userInput.nextLine();
			for (int i = 0; i < numPlayers; i++) {
				System.out.print("Enter player #" + (i + 1) + "'s name: ");
				players.add(new Player(userInput.nextLine()));
			}
			deal();
			for (Player player : players) {
				System.out.println(player.toString() + "\n\n\n\n");
			}
			play();
		} while (true);
	}

	/**
	 *
	 */
	private static void deal() {
		deck = new Deck();
		deck.create();
		deck.shuffle();
		for (int playerNum = 0; playerNum < players.size(); playerNum++) {
			for (int card = 0; card < (52 / players.size()); card++) {
				players.get(playerNum).getHand().add(deck.draw());
			}
		}
	}
	
	/**
	 *
	 *
	 */
	private static void play() {
		while (!hasWinner()) {
			for (int playerNum = 0; playerNum < players.size(); playerNum++) {
				if (players.get(playerNum).getHand().size() == 0) {
					System.out.println("\n" + players.get(playerNum).getName() + " lost!\n");
					players.remove(playerNum);
				}
			}
			System.out.println();
		}
	}

	private static boolean hasWinner() {
		for (int playerNum = 0; playerNum < players.size(); playerNum++) {
			if (players.get(playerNum).getHand().size() == 52) {
				return true;
			}
		}
		return false;
	}
	
}