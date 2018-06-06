package src.cardGame;


/**
 * 
 *
 * @author Joshua Ciffer
 * @version 06/05/2018
 */
public final class Main {

	private static Deck deck;
	
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
		deck = new Deck();
	}
	
}