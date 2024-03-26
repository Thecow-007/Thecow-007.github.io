package deliverables;

/**
 * class to create some instances of Deliverable and process them polymorphically
 * @author Daniel Bierman
 *
 */
public class DeliverableTest {
	final static boolean ThinCrust=true;
	/** Main method tests the Deliverable interface and it's 2 classes: Pizza and SudsOrder.
	 * @param args command line arguments. Not used in this method.
	 */
	public static void main(String[] args) {
		Pizza pizza1 = new Pizza(12, "pesto", ThinCrust);
		pizza1.addMushrooms();
		pizza1.addOnion();
		pizza1.addOlives();
		pizza1.addGreenPepper();
		
		Pizza pizza2 = new Pizza(14, "marinara");
		pizza2.addPepperoni();
		pizza2.addMushrooms();
		pizza2.addGreenPepper();
		pizza2.extraCheese();
		
		Deliverable[] deliverableItems = {
				pizza1,
				pizza2,
				new SudsOrder("Rollicking Root Beer", 6, 473),
				new SudsOrder("Super Citrus Fizz", 4, 473)
		}; 
		
		//Print out column headers with spacing: 20, 15, 10.
		System.out.printf("%-20s%15s%10s\n","Item", "Number/Size", "Cost");
		
		int pizzaCounter = 1; //Increments pizza's for display purposes.
		
		for(Deliverable deliverable: deliverableItems) {
			String name = "";
			double NumberSize = 0;
			
			if(deliverable instanceof Pizza) {
				name = "Pizza " + pizzaCounter;
				NumberSize = ((Pizza) deliverable).getSizeInInches();
				
				//increment pizza counter for displaying name.
				pizzaCounter++;
			}
			else if(deliverable instanceof SudsOrder) {
				name = ((SudsOrder) deliverable).getName();
				NumberSize = ((SudsOrder) deliverable).getNumber();
			}
			
			System.out.printf("%-20s%15.0f%10.2f\n",name, NumberSize, deliverable.getDeliveryCosts());
		}

	}//main()

}//class
