package deliverables;

/**
 * Suds Order class represents a drink order item, of a drink, a certain amount
 * of them, and their size in milliliters.
 * 
 * @author Daniel Bierman
 *
 */
public class SudsOrder implements Deliverable {
	private String name;
	private int number;
	private int size_in_ml;

	/**
	 * Creates a new Suds Order drink item, with a name, number and a size in
	 * milliliters
	 * 
	 * @param name       The drink's name
	 * @param number     the amount of drinks
	 * @param size_in_ml the size of the drink in milliliters.
	 */
	public SudsOrder(String name, int number, int size_in_ml) {
		this.name = name;
		this.number = number;
		this.size_in_ml = size_in_ml;
	}

	/**
	 * Gets the name of the drink.
	 * 
	 * @return The drink's name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the number of drinks in this order item.
	 * 
	 * @return The number of drinks in this order item.
	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * Gets the drink's size in milliliters.
	 * 
	 * @return The drink's size in milliliters
	 */
	public int getSize_in_ml() {
		return this.size_in_ml;
	}

	/**
	 * Gets this order items string.
	 * 
	 * @return The string representation of this order item. Contains names values
	 *         separated by commas and colons.
	 */
	public String toString() {
		return String.format("Name: %s, Number: %s, Size in ML: %s", name, number, size_in_ml);
	}

	/**
	 * Gets the cost to deliver this item.
	 * 
	 * @return The delivery cost for this order item.
	 */
	public double getDeliveryCosts() {
		return (this.getNumber() * 0.75);
	}
}
