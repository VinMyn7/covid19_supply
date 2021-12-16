package product_stock.domain;

/**
 * User object
 * 
 * @author Vineeth Myneedi
 * 
 */
public class Product_stock {
	/*
	 * Correspond to the user table
	 */
	private String product_id; 
	private String product_name;
	private Integer available_quantity;
	private String supplier_id;
	/**
	 * @return the product_id
	 */
	public String getProduct_id() {
		return product_id;
	}
	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	/**
	 * @return the product_name
	 */
	public String getProduct_name() {
		return product_name;
	}
	/**
	 * @param product_name the product_name to set
	 */
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	/**
	 * @return the available_quantity
	 */
	public Integer getAvailable_quantity() {
		return available_quantity;
	}
	/**
	 * @param available_quantity the available_quantity to set
	 */
	public void setAvailable_quantity(Integer available_quantity) {
		this.available_quantity = available_quantity;
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