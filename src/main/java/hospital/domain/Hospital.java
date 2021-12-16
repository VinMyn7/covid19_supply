package hospital.domain;

/**
 * User object
 * 
 * @author Vineeth Myneedi
 * 
 */
public class Hospital {
	/*
	 * Correspond to the user table
	 */
	
	private String hospital_id;
	private String hospital_name; 
	private String hospital_address;
	private String delivery_id;
	/**
	 * @return the hospital_id
	 */
	public String getHospital_id() {
		return hospital_id;
	}
	/**
	 * @param hospital_id the hospital_id to set
	 */
	public void setHospital_id(String hospital_id) {
		this.hospital_id = hospital_id;
	}
	/**
	 * @return the hospital_name
	 */
	public String getHospital_name() {
		return hospital_name;
	}
	/**
	 * @param hospital_name the hospital_name to set
	 */
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	/**
	 * @return the hospital_address
	 */
	public String getHospital_address() {
		return hospital_address;
	}
	/**
	 * @param hospital_address the hospital_address to set
	 */
	public void setHospital_address(String hospital_address) {
		this.hospital_address = hospital_address;
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