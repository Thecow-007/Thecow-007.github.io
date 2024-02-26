package assignment1;

import java.util.Scanner;

/**
 * Simple class to test the CarRegistration class by allowing user to enter values into the terminal
 * and outputting those inputs in the toString() method of CarRegistration
 * @author Daniel Bierman
 * @version 1.4
 */
public class CarRegistrationTest {

	/**
	 * Basic test of the CarRegistration class, allows user to enter values into the terminal,
	 * then prints String representation of the car registration
	 * @param args unused command line argument
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double basePrice = 0;
		double upgradeCoefficient = 0; // value range: 1(no upgrade) to 2 (highest level upgrade)
		double colorIndex = 0; // value range: 0 (default color) to 5000
		String firstName = "";
		String lastName = "";
		String gender = "";
		int birthYear = 0;
		double yearlyIncome = 0;
		
		//flag that tests for valid input from the user
		boolean validInput = false;
		
		do {
			try {
				System.out.println("Please enter the base price of the vehicle: ");
				basePrice = sc.nextDouble();
				
				System.out.println("Please enter the upgrade Coefficient: ");
				upgradeCoefficient = sc.nextDouble();
				
				System.out.println("Please enter the Color Index");
				colorIndex = sc.nextDouble();
				
				sc.nextLine(); //clear the input stream
				
				System.out.println("Please enter the customer's firstname: ");
				firstName = sc.nextLine();
				
				System.out.println("Please enter the customer's lastname: ");
				lastName = sc.nextLine();
				
				System.out.println("Please enter the customer's gender: ");
				gender = sc.nextLine();
				
				System.out.println("Please enter the customer's birthyear: ");
				birthYear = sc.nextInt();
				
				System.out.println("Please enter the customer's yearly income: ");
				yearlyIncome = sc.nextDouble();
				
				//no errors, so flag is set true
				validInput = true;
			}
			catch(Exception e){
				System.out.println("Invalid input. Please re-submit the form.");
				sc.next();
				validInput = false;
			}
		}while(!validInput);
		
		CarRegistration cr = new CarRegistration(basePrice, upgradeCoefficient, colorIndex, firstName, lastName, gender, birthYear, yearlyIncome);;
		System.out.println(cr.retrieveCustomerInfo());
	}

}
