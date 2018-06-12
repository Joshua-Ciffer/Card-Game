package src.cardGame;

import java.util.ArrayList;

/**
 * This class represents a single player of the card game. The player stores a hand of cards that gets added to and removed from.
 *
 * @author Joshua Ciffer
 * @version 06/10/2018
 */
public final class Player {

	/**
	 * The cards the player currently has.
	 */
	private ArrayList<Card> hand;

	/**
	 * The number of the player in the game. Used to keep track of what cards belong to who and such.
	 */
	private final int number;

	/**
	 * The player's name.
	 */
	private final String name;

	/**
	 * Constructs a new <code>Player</code>.
	 * 
	 * @param number
	 *        The number of the player in the game.
	 * @param name
	 *        The player's name.
	 */
	public Player(int number, String name) {
		hand = new ArrayList<>();
		this.number = number;
		this.name = name;
	}

	/**
	 * @return The card from the top of the player's hand.
	 */
	public Card draw() {
		if (hand.size() > 0) {	// If there are still cards left in the player's hand,
			return hand.remove(0);	// Take the first card.
		} else {
			return null;
		}
	}

	/**
	 * @return The player's hand.
	 */
	public ArrayList<Card> getHand() {
		return hand;
	}

	/**
	 * @return The number of this player.
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return The player's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return A string representation of this player.
	 */
	@Override
	public String toString() {
		String temp = name;
		for (Card card : hand) {
			temp += "\n" + card.toString();
		}
		return temp;
	}

}