package assignment1;

/**
 * CarSelection is a base class to be extended for a vehicle purchase process,
 * which is also named as Assignment 1. It contains a method to to calculate a
 * vehicle price. It also contains a function that uses a wrong formula to
 * calculate a vehicle's price.
 * 
 * @author Daniel Bierman
 * @version 1.1
 */

public class CarSelection {
	/**
	 * This method returns the price of a vehicle of a particular model based on its
	 * base price, upgrade coefficient and color choice.
	 * 
	 * @param basePrice          base price for the particular model
	 * @param upgradeCoefficient dealer markup
	 * @param colorIndex         addition for premium color
	 * @return total model price including all markup and premium prices
	 */

	public double calculateCarPrice(double basePrice, double upgradeCoefficient, double colorIndex) {
		return basePrice * upgradeCoefficient + colorIndex;
	}

}