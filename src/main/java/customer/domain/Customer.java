package customer.domain;

/**
 * User object
 * 
 * @author Vineeth Myneedi
 * 
 */
public class Customer {
	/*
	 * Correspond to the user table
	 */
	
	private String customer_id;
	private String customer_name; 
	private String customer_address;
	private Integer customer_age;
	private String delivery_id;
	/**
	 * @return the customer_id
	 */
	public String getCustomer_id() {
		return customer_id;
	}
	/**
	 * @param customer_id the customer_id to set
	 */
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	/**
	 * @return the customer_name
	 */
	public String getCustomer_name() {
		return customer_name;
	}
	/**
	 * @param customer_name the customer_name to set
	 */
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	/**
	 * @return the customer_address
	 */
	public String getCustomer_address() {
		return customer_address;
	}
	/**
	 * @param customer_address the customer_address to set
	 */
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	/**
	 * @return the customer_age
	 */
	public Integer getCustomer_age() {
		return customer_age;
	}
	/**
	 * @param customer_age the customer_age to set
	 */
	public void setCustomer_age(Integer customer_age) {
		this.customer_age = customer_age;
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