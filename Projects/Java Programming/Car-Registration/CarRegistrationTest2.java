package assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit class to test the CarSelection Class.
 * Currently just tests the isPreApproved method.
 * @author Daniel Bierman
 *
 */
public class CarRegistrationTest2 {
	/**
	 * Tests the isPreApproved method of the CarRegistration class.
	 */
	@Test
	public void testIsPreapproved() {
		/* Car's total price is around $2010,
		 * Income of $100,000 should be well above 5 times the cost of car.
		 */
		CarRegistration cr = new CarRegistration(1000, 2, 10, "Daniel", "Bierman", "male", 2005, 100000);
		boolean result = cr.isPreApproved();
		boolean expected = true;
		assertEquals(expected, result);
	}

}
