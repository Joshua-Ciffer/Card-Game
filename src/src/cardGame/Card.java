package src.cardGame;

/**
 * This class represents a single playing card with its face value, value, and suit.
 *
 * @author Joshua Ciffer
 * @version 06/05/2018
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
	 * Constructs a new <code>Card</code>.
	 *
	 * @param faceValue
	 *        The face value of this card.
	 * @param value
	 *        The value of this card.
	 * @param suit
	 *        The suit of this card.
	 */
	public Card(String faceValue, int value, String suit) {
		this.faceValue = faceValue;
		this.value = value;
		this.suit = suit;
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
		return faceValue + " of " + suit + ".";
	}

}