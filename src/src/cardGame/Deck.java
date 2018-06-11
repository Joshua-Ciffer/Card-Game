package src.cardGame;

import java.util.ArrayList;

/**
 * This class represents a deck that contains 52 <code>Card</code> objects.
 *
 * @author Joshua Ciffer
 * @version 06/10/2018
 */
public final class Deck {

	/**
	 * Stores the 52 cards of the deck.
	 */
	private ArrayList<Card> deck;

	/**
	 * Constructs a new <code>Deck</code> object. The deck array list is initialized upon object construction.
	 */
	public Deck() {
		deck = new ArrayList<>();
	}

	/**
	 * Fills the deck with the 52 cards in a random order.
	 */
	public void create() {
		deck.clear();	// Clears any cards that are currently in the deck.
		for (int suit = 0; suit <= 3; suit++) {		// Loop runs from 0 to 3 (runs 4 times), generates all 13 cards for each suit.
			for (int value = 1; value <= 13; value++) {		// This loop runs 1 to 13 (runs 13 times), determines the value of each card.
				switch (suit) {
					case 0: {	// Hearts.
						deck.add(new Card(value, "Hearts"));
						break;
					}
					case 1: {	// Diamonds.
						deck.add(new Card(value, "Diamonds"));
						break;
					}
					case 2: {	// Spades.
						deck.add(new Card(value, "Spades"));
						break;
					}
					case 3: {	// Clubs.
						deck.add(new Card(value, "Clubs"));
						break;
					}
				}
			}
		}
	}

	/**
	 * Shuffles the cards stored in the deck in a random order.
	 */
	public void shuffle() {
		ArrayList<Card> shuffledDeck = new ArrayList<>();	// Creates a new deck.
		int index;
		while (deck.size() > 0) {	// While there are still cards left in the un-shuffled deck,
			index = (int)(Math.random() * deck.size());		// Picks a random card from the un-shuffled deck.
			shuffledDeck.add(deck.remove(index));	// Takes the random card out from the un-shuffled deck and places it in the shuffled deck.
		}
		deck = shuffledDeck;	// Saves the shuffled deck to the deck instance variable. Old deck goes bye bye.
	}

	/**
	 * @return The next card from the top of the deck.
	 */
	public Card draw() {
		if (deck.size() > 0) {	// While there are still cards left in the deck,
			return deck.remove(0);	// Return the first card.
		} else {
			return null;
		}
	}

	/**
	 * @return A string representation of this deck.
	 */
	@Override
	public String toString() {
		String temp = "";
		for (Card card : deck) {
			temp += card.toString() + "\n";
		}
		return temp;
	}

}