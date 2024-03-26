package deliverables;

/**
 * Represents a pizza. The pizza has a size in inches, a types of sauce, and
 * various options such as thin crust, ham, pepperoni, extra cheese, olives,
 * mushrooms, green peppers tomatoes and onions.
 * 
 * @author Daniel Bierman
 *
 */
public class Pizza implements Deliverable {
	private int size_in_inches;
	private String type_of_sauce;
	private boolean thin_crust;
	private boolean ham;
	private boolean pepperoni;
	private boolean extra_cheese;
	private boolean olives;
	private boolean mushrooms;
	private boolean green_pepper;
	private boolean tomatoes;
	private boolean onion;

	/**
	 * Creates a pizza with a given size in inches, and type of sauce. It is
	 * automatically assumed that it is not a thin_crust pizza.
	 * 
	 * @param size_in_inches size of pizza in inches.
	 * @param type_of_sauce  type of sauce used on pizza.
	 */
	public Pizza(int size_in_inches, String type_of_sauce) {
		this(size_in_inches, type_of_sauce, false);
	}

	/**
	 * Creates a pizza with a given size in inches, type of sauce, and whether it is
	 * thin crust.
	 * 
	 * @param size_in_inches size of pizza in inches.
	 * @param type_of_sauce  type of sauce used on pizza.
	 * @param thin_crust     if the pizza is thin crust, true means it is.
	 */
	public Pizza(int size_in_inches, String type_of_sauce, boolean thin_crust) {
		if (!(size_in_inches == 14) && !(size_in_inches == 12)) {
			throw new IllegalArgumentException("Pizza must have size 12\" or 14\"");
		}
		this.size_in_inches = size_in_inches;
		this.type_of_sauce = type_of_sauce;
		this.thin_crust = thin_crust;
	}

	/**
	 * Adds extra cheese to the pizza. Does not change anything if it is already on
	 * pizza.
	 */
	public void extraCheese() {
		this.extra_cheese = true;
	}

	/**
	 * Adds green peppers to the pizza. Does not change anything if it is already on
	 * pizza.
	 */
	public void addGreenPepper() {
		this.green_pepper = true;
	}

	/**
	 * Adds Ham to the pizza. Does not change anything if it is already on pizza.
	 */
	public void addHam() {
		this.ham = true;
	}

	/**
	 * Adds mushrooms to the pizza. Does not change anything if it is already on
	 * pizza.
	 */
	public void addMushrooms() {
		this.mushrooms = true;
	}

	/**
	 * Adds olives to the pizza. Does not change anything if it is already on pizza.
	 */
	public void addOlives() {
		this.olives = true;
	}

	/**
	 * Adds onion to the pizza. Does not change anything if it is already on pizza.
	 */
	public void addOnion() {
		this.onion = true;
	}

	/**
	 * Adds pepperoni to the pizza. Does not change anything if it is already on
	 * pizza.
	 */
	public void addPepperoni() {
		this.pepperoni = true;
	}

	/**
	 * Adds tomatoes to the pizza. Does not change anything if it is already on
	 * pizza.
	 */
	public void addTomatoes() {
		this.tomatoes = true;
	}

	/**
	 * Gets the size of the pizza in inches
	 * 
	 * @return int the size of the pizza in inches
	 */
	public int getSizeInInches() {
		return this.size_in_inches;
	}

	/**
	 * Returns the delivery cost for this pizza
	 * 
	 * @return double the delivery cost in dollars of this pizza.
	 */
	public double getDeliveryCosts() {
		int pizza_size = this.getSizeInInches();
		if (pizza_size == 12) {
			return 3.50;
		} else if (pizza_size == 14) {
			return 4.75;
		} else {
			return -1; // Should never happen, due to invalid argument exception in constructor.
		}
	}
}
