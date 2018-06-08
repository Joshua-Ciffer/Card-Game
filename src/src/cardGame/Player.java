package src.cardGame;

import java.util.ArrayList;

/**
 * This class represents a single player of the card game.
 *
 * @author Joshua Ciffer
 * @version 06/06/2018
 */
public final class Player {

	/**
	 * The cards the player has.
	 */
	private ArrayList<Card> hand;

	/**
	 * The player's name.
	 */
	private String name;

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
	
	public Card draw() {
		return hand.remove(0);
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
	
	@Override
	public String toString() {
		String temp = name;
		for (Card card : hand) {
			temp += "\n" + card.toString();
		}
		return temp;
	}

}