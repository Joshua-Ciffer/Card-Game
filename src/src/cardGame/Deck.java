package src.cardGame;

import java.util.ArrayList;

/**
 * This class represents a deck that contains 52 <code>Card</code> objects.
 *
 * @author Joshua Ciffer
 * @version 06/05/2018
 */
public final class Deck {

	/**
	 * Stores the 52 cards of the deck.
	 */
	private ArrayList<Card> deck;

	/**
	 * Fills the deck with the 52 cards in a random order.
	 */
	public void create() {
		for (int suit = 0; suit < 3; suit++) {
			for (int value = 1; value <= 13; value++) {
				switch (suit) {
					case 0: {	// Hearts.

						break;
					}
					case 1: {	// Diamonds.

						break;
					}
					case 2: {	// Spades.

						break;
					}
					case 3: {	// Clubs.

						break;
					}
				}
			}
		}
		shuffle();
	}

	/**
	 * Shuffles the cards stored in the deck in a random order.
	 */
	public void shuffle() {}

	/**
	 * @return The next card from the top of the deck.
	 */
	public Card draw() {
		return deck.get(0);
	}

}