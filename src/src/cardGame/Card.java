package src.cardGame;

/**
 * This class represents a single playing card with its face value, value, and suit.
 *
 * @author Joshua Ciffer
 * @version 06/10/2018
 */
public final class Card {

	/**
	 * The face value of this card. Example: King, ace, five.
	 */
	private final String faceValue;

	/**
	 * The numerical value of this card. Example: 1-13.
	 */
	private final int value;

	/**
	 * The suit of this card. Example: Hearts, diamonds, spades, clubs.
	 */
	private final String suit;

	/**
	 * The possible face values of the card.
	 */
	private static final String[] faceValues = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

	/**
	 * Constructs a new <code>Card</code>.
	 *
	 * @param value
	 *        The value of this card.
	 * @param suit
	 *        The suit of this card.
	 */
	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;
		this.faceValue = faceValues[value - 1];		// Determines the face value based off of what the numerical value of the card is.
	}

	/**
	 * @return The face value of this card.
	 */
	public String getFaceValue() {
		return faceValue;
	}

	/**
	 * @return The value of this card.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return The suit of this card.
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * @return A string representation of this card.
	 */
	@Override
	public String toString() {
		return faceValue + " of " + suit;
	}

}