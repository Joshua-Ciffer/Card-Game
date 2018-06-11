package src.cardGame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * The main entry point of the program. Contains the actual game logic and menus.
 *
 * @author Joshua Ciffer
 * @version 06/11/2018
 */
public final class Main {

	/**
	 * Stores all of the current players in the game.
	 */
	private static ArrayList<Player> players;

	/**
	 * The game deck.
	 */
	private static Deck deck;

	/**
	 * The number of players currently in the game.
	 */
	private static int numPlayers;

	/**
	 * Accepts user input from the console.
	 */
	private static Scanner userInput;

	/**
	 * Don't let anyone instantiate this class (prevents an object of this class from being created).
	 */
	private Main() {}

	/**
	 * The main entry point. Also provides the main menu for the game and determines the flow of the program.
	 *
	 * @param args
	 *        Command line arguments.
	 */
	public static void main(String[] args) {
		userInput = new Scanner(System.in);
		while (true) {
			System.out.print("Main Menu\nHow many players do you want to have?: ");
			try {
				numPlayers = userInput.nextInt();
			} catch (InputMismatchException e) {	// Makes sure the program doesn't crash if the user doesn't enter an integer.
				userInput.next();	// Clears the scanner, prevents a weird infinite loop bug.
				System.out.println("Enter a number fuckwad.");
				continue;
			}
			players = new ArrayList<>();
			userInput.nextLine();	// Clears the scanner because it previously accepted a number and now needs to accept a string.
			for (int i = 0; i < numPlayers; i++) {	// Runs for however many players are in the game.
				System.out.print("Enter player #" + (i + 1) + "'s name: ");
				players.add(new Player(userInput.nextLine()));	// Asks for each players name and adds them to the game.
			}
			deal();
			for (Player player : players) {		// DEBUG USE, REMOVE FROM THE FINAL GAME.
				System.out.println(player.toString() + "\n\n\n\n");
			}
			play();
			while (true) {
				System.out.print("Keep playing? Yes or No: ");
				switch (userInput.nextLine().toLowerCase()) {
					case "yes": {
						break;
					}
					case "no": {
						terminate();
						break;
					}
					default: {
						System.out.println("\nPlease enter Yes to continue playing or No to stop playing.\n");
						continue;
					}
				}
				break;
			}
		}
	}

	/**
	 * Creates a new deck, shuffles it, and deals out cards equally to all players.
	 */
	private static void deal() {
		deck = new Deck();
		deck.create();
		deck.shuffle();
		for (int playerNum = 0; playerNum < players.size(); playerNum++) {	// This loop runs one time for each player in the game.
			for (int card = 0; card < (52 / players.size()); card++) {	// This loop divides the deck up evenly among all of the players in the game.
				players.get(playerNum).getHand().add(deck.draw());	// Takes a card from the deck and places it in the player's deck.
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

	/**
	 * Determines if a player has won the game. A player wins when their hand contains all of the cards from the deck.
	 *
	 * @return True, if a player has won the game, false if otherwise.
	 */
	private static boolean hasWinner() {
		for (int playerNum = 0; playerNum < players.size(); playerNum++) {	// Loops through one time for each player in the game.
			if (players.get(playerNum).getHand().size() == 52) {	// If one player has all the cards,
				return true;										// then they won the game.
			}
		}
		return false;
	}

	/**
	 * Removes all pointers to objects, closes resources, and terminates the program.
	 */
	private static void terminate() {
		players = null;
		deck = null;
		numPlayers = 0;
		userInput.close();
		userInput = null;
		System.exit(0);
	}

}