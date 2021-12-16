package delivery_staff.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author Vineeth Myneedi
 * 
 */
public class Delivery_staff {
	/*
	 * Correspond to the user table
	 */
	 
	private String delivery_id;
	private String delivery_staff_id;
	private Date delivery_date;
	private String supplier_id;
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
	/**
	 * @return the delivery_staff_id
	 */
	public String getDelivery_staff_id() {
		return delivery_staff_id;
	}
	/**
	 * @param delivery_staff_id the delivery_staff_id to set
	 */
	public void setDelivery_staff_id(String delivery_staff_id) {
		this.delivery_staff_id = delivery_staff_id;
	}
	/**
	 * @return the delivery_date
	 */
	public Date getDelivery_date() {
		return delivery_date;
	}
	/**
	 * @param delivery_date the delivery_date to set
	 */
	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}
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
	
	
}