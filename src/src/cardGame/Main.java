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
				System.out.println("Enter a number fuckwad.\n");
				userInput.nextLine();
				continue;
			}
			players = new ArrayList<>();
			userInput.nextLine();	// Clears the scanner because it previously accepted a number and now needs to accept a string.
			for (int i = 0; i < numPlayers; i++) {	// Runs for however many players are in the game.
				System.out.print("Enter player #" + (i + 1) + "'s name: ");
				players.add(new Player(i, userInput.nextLine()));	// Asks for each players name and adds them to the game.
			}
			System.out.print("\n");
			deal();
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
		for (int playerNum = 0; playerNum < players.size(); playerNum++) {	// This loop runs one time for each player in the game.
			deck.shuffle();
			for (int card = 0; card < (52 / players.size()); card++) {	// This loop divides the deck up evenly among all of the players in the game.
				players.get(playerNum).getHand().add(deck.draw());	// Takes a card from the deck and places it in the player's deck.
			}
		}
	}

	/**
	 * Runs the game turn by turn until a player wins.
	 * 
	 * The turn loop first checks if a player has won the game, if not, it checks to see what players are still in the game. A player is removed
	 * from the game if they run out of cards. A player wins the game if they are the only player left. Otherwise, a single card is drawn from each
	 * player's hand. Whoever's card has the highest value, that player wins all of the cards that were drawn. They are added to their hand. The turn
	 * then ends. If however, two or more players draw a card of the same value, there is a war. In the case of a war, the players involved draw three
	 * more cards and then one more card to compare against the other players. The player in the war with the highest value of their final card drawn
	 * wins all of the cards involved.
	 */
	private static void play() {
		ArrayList<Card> currentCards = new ArrayList<>();
		ArrayList<Player> playersAtWar = new ArrayList<>();
		int turn = 1;
		while (!hasWinner()) {
			for (int playerNum = 0; playerNum < players.size(); playerNum++) {	// Loops through for each player,
				if (players.get(playerNum).getHand().size() == 0) {
					System.out.println("\n" + players.get(playerNum).getName() + " lost!\n");	// Removes them from the game if they are out of cards.
					players.remove(playerNum);
				}
			}
			if (hasWinner()) {
				System.out.println("\n" + players.get(0).getName() + " won the game!\n");
				break;
			}
			System.out.println("Turn #" + turn++);
			for (int playerNum = 0; playerNum < players.size(); playerNum++) {
				currentCards.add(players.get(playerNum).draw());
				System.out.println(players.get(playerNum).getName() + ": " + currentCards.get(playerNum));
				System.out.println(players.get(playerNum).getHand());
			}
			int greatestCard = 0;
			for (int card = 1; card < currentCards.size(); card++) {
				System.out.println("Here");
				if (currentCards.get(card).getValue() > currentCards.get(greatestCard).getValue()) {
					greatestCard = card;
				} else if (currentCards.get(card).getValue() == currentCards.get(greatestCard).getValue()) {
					playersAtWar.add(players.get(card));
				}
			}
			war(playersAtWar);
			System.out.println("\n" + players.get(greatestCard).getName() + " won the round.\n");
			players.get(greatestCard).getHand().addAll(currentCards);
			currentCards.clear();
			System.out.println();
		}
	}

	/**
	 * @param playersAtWar
	 *        The list of players involved with the war.
	 */
	private static void war(ArrayList<Player> playersAtWar) {
		if (playersAtWar.size() > 0) {

		}
	}

	/**
	 * Determines if a player has won the game. A player wins when their hand contains all of the cards from the deck.
	 *
	 * @return True, if a player has won the game, false if otherwise.
	 */
	private static boolean hasWinner() {
		if (players.size() == 1) {	// If there is one player left in the game, they win. Duh.
			return true;
		} else {
			return false;
		}
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