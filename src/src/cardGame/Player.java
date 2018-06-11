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
	 * The player's name.
	 */
	private final String name;

	/**
	 * Constructs a new <code>Player</code>.
	 *
	 * @param name
	 *        The player's name.
	 */
	public Player(String name) {
		hand = new ArrayList<>();
		this.name = name;
	}

	/**
	 * @return The card from the top of the player's hand.
	 */
	public Card draw() {
		Card temp;
		try {
			temp = hand.remove(0);
			return temp;
		} catch (NullPointerException e) {	// If there is no cards in the player's hand, return null.
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