package supplier.domain;

/**
 * User object
 * 
 * @author Vineeth Myneedi
 * 
 */
public class Supplier {
	/*
	 * Correspond to the user table
	 */
	
	private String supplier_id;
	private String supplier_name; 
	private String delivery_id;
	/**
	 * @return the supplier_id
	 */
	public String getSupplier_id() {
		return supplier_id;
	}
	/**
	 * @param supplier_id the supplier_id to set
	 */
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	/**
	 * @return the supplier_name
	 */
	public String getSupplier_name() {
		return supplier_name;
	}
	/**
	 * @param supplier_name the supplier_name to set
	 */
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	/**
	 * @return the delivery_id
	 */
	public String getDelivery_id() {
		return delivery_id;
	}
	/**
	 * @param delivery_id the delivery_id to set
	 */
	public void setDelivery_id(String delivery_id) {
		this.delivery_id = delivery_id;
	}
	
}