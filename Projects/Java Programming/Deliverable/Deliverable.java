package deliverables;

/**Deliverable Interface represents objects which are deliverable and have a delivery cost.
 * @author Daniel Bierman
 *
 */
public interface Deliverable {
	
	/** gets Delivery costs for the deliverable item
	 * @return double Delivery costs for the deliverable item
	 */
	public abstract double getDeliveryCosts();

}
