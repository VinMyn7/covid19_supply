package customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import customer.domain.Customer;




//import java.util.ArrayList;
//import java.util.List;


/**
 * DDL functions performed in database
 */
public class CustomerDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "root"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "mvt@3107"; //TODO change password

	public Customer findBycustomer_id(String cid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Customer customer = new Customer();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
		    String sql = "SELECT * from customer WHERE customer_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,cid);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String customer_id = resultSet.getString("customer_id");
		    	if(customer_id.equals(cid)){
		    		customer.setCustomer_id(resultSet.getString("customer_id"));
		    		customer.setCustomer_name(resultSet.getString("customer_name"));
		    		customer.setCustomer_address(resultSet.getString("customer_address"));
		    		customer.setCustomer_age(resultSet.getInt("customer_age"));
		    		customer.setDelivery_id(resultSet.getString("delivery_id"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return customer;
	}	
	
	/**
	 * insert Customer
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void createCustomer(Customer form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
			
			String sql = "INSERT INTO customer (customer_id, customer_name, customer_address, customer_age, delivery_id) VALUES(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getCustomer_id());
		    preparestatement.setString(2,form.getCustomer_name());
		    preparestatement.setString(3,form.getCustomer_address());
		    preparestatement.setInt(4, form.getCustomer_age());
		    preparestatement.setString(5,form.getDelivery_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(Customer form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
			
			String sql = "UPDATE customer SET customer_name = ?, customer_address = ?, customer_age = ?, delivery_id = ? where customer_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getCustomer_name());
		    preparestatement.setString(2,form.getCustomer_address());
		    preparestatement.setInt(3, form.getCustomer_age());
		    preparestatement.setString(4,form.getDelivery_id());
		    preparestatement.setString(5,form.getCustomer_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String cid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
			
			String sql = "delete from customer where customer_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,cid);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}