package assignment1;

/**
 * This class represents the information required to price and register the car
 * model
 */

/** CarRegistration class represents the registration information for a specific vehicle and customer.
 * Inherits from the CarSelection class
 * @author Daniel Bierman
 * @version 1.2
 */
public class CarRegistration extends CarSelection {
	// variable to hold the buyer's first name
	private double basePrice;
	private double upgradeCoefficient; // value range: 1(no upgrade) to 2 (highest level upgrade)
	private double colorIndex; // value range: 0 (default color) to 5000
	private String firstName;
	private String lastName;
	private String gender;
	private int birthYear;
	// private String occupation;
	private double yearlyIncome;

	/**
	 * Integer of current year
	 */
	public static int currentYear = 2024;

	/**
	 * Constructor to instantiate a car registration object of the class
	 * 
	 * @param basePrice Base price of Customer's vehicle
	 * @param upgradeCoefficient double representing the upgrade coefficient, ranges from 1-2 with 1 representing no upgrades, and 2 representing fully upgraded
	 * @param colorIndex double representing color index, ranges from 0-5000
	 * @param firstName Customer's first name
	 * @param lastName Customer's last name
	 * @param gender Customer's gender
	 * @param birthYear Customer's gender
	 * @param yearlyIncome Customer's yearly income
	 */
	public CarRegistration(double basePrice, double upgradeCoefficient, double colorIndex, String firstName,
			String lastName, String gender, int birthYear, double yearlyIncome) {
		super();
		this.basePrice = basePrice;
		this.upgradeCoefficient = upgradeCoefficient;
		this.colorIndex = colorIndex;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthYear = birthYear;
		this.yearlyIncome = yearlyIncome;
	}// constructor

	/**
	 * This method calculates a customer's age
	 * @return Customer's Age
	 */
	public int getCustomerAge() {
		return currentYear - birthYear;
	}

	/**
	 * This function checks whether a customer is eligible to purchase the car and
	 * prints out a message about it.
	 * A car's price should not be more than 20% of the customer's yearly salary.
	 * @return boolean describing whether customer is pre-approved, based on calculated price of the vehicle.
	 */
	public boolean isPreApproved() {
		return (calculateCarPrice(basePrice, upgradeCoefficient, colorIndex) <= yearlyIncome * 0.2);
		
	}

	/**
	 * This function check if a customer is eligible to drive and prints a relevant
	 * message. A customer's age should be at least 16 years to be eligible
	 * to drive.
	 * @return boolean describing whether customer is old enough to drive.
	 */
	public boolean isEligibleToDrive() {
		if (this.getCustomerAge() >= 16) {
			return true;
		}
		return false;
	}

	/**
	 * This function obtains the customer's information and formats it into a printable String.
	 * @return String containing all customer info, with field titles and values separated by commas.
	 */
	public String retrieveCustomerInfo() {
		String customerInfo = String.format(
				"Customer first name: %s, Lastname: %s, Gender: %s, Age: %d, Birth year: %d, The customer is%s eligible to drive, The customer is%s preapproved.",
				firstName, lastName, gender, this.getCustomerAge(), birthYear, this.isEligibleToDrive() ? "" : " *not*",
				this.isPreApproved() ? "" : " *not*");
		return customerInfo;
	}

	/**Gets the Customer's first name
	 * @return String of customer's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the Customer's first name
	 * @param firstName Customer's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the base price of the vehicle
	 * @return double of base price of customer's vehicle
	 */
	public double getBasePrice() {
		return basePrice;
	}

	/**
	 * Sets the base price of the vehicle
	 * @param basePrice base price of customer's vehicle
	 */
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * Gets the upgrade coefficient of the customer's vehicle
	 * @return double of the upgrade coefficient, ranges from 1-2 with 1 representing no upgrades, and 2 representing fully upgraded
	 */
	public double getUpgradeCoefficient() {
		return upgradeCoefficient;
	}

	/**
	 * Sets the upgrade coefficient of the customer's vehicle
	 * @param upgradeCoefficient double representing the upgrade coefficient, ranges from 1-2 with 1 representing no upgrades, and 2 representing fully upgraded
	 */
	public void setUpgradeCoefficient(double upgradeCoefficient) {
		this.upgradeCoefficient = upgradeCoefficient;
	}

	/**
	 * Gets the color index of the customer's vehicle
	 * @return double representing color index, ranges from 0-5000
	 */
	public double getColorIndex() {
		return colorIndex;
	}

	/**
	 * Sets the color index of the customer's vehicle
	 * @param colorIndex double representing color index, ranges from 0-5000
	 */
	public void setColorIndex(double colorIndex) {
		this.colorIndex = colorIndex;
	}

	/**
	 * Gets the customer's last name
	 * @return String of customer's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the customer's last name
	 * @param lastName Customer's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the customer's gender
	 * @return String of customer's gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the customer's gender
	 * @param gender customer's gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**Gets the customer's birth year
	 * @return integer of customer's birth year
	 */
	public int getBirthYear() {
		return birthYear;
	}

	/**
	 * Sets the customer's birth year
	 * @param birthYear customer's birth year
	 */
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	/**
	 * Gets the customer's yearly income
	 * @return double of customer's yearly income
	 */
	public double getYearlyIncome() {
		return yearlyIncome;
	}

	/**
	 * Sets the customer's yearly income
	 * @param yearlyIncome customer's yearly income
	 */
	public void setYearlyIncome(double yearlyIncome) {
		this.yearlyIncome = yearlyIncome;
	}
}// class