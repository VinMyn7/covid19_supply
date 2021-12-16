package supplier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import supplier.domain.Supplier;




//import java.util.ArrayList;
//import java.util.List;


/**
 * DDL functions performed in database
 */
public class SupplierDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "root"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "mvt@3107"; //TODO change password

	public Supplier findBysupplier_id(String sid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Supplier supplier = new Supplier();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
		    String sql = "SELECT * from supplier WHERE supplier_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,sid);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String supplier_id = resultSet.getString("supplier_id");
		    	if(supplier_id.equals(sid)){
		    		supplier.setDelivery_id(resultSet.getString("delivery_id"));
		    		supplier.setSupplier_id(resultSet.getString("supplier_id"));
		    		supplier.setSupplier_name(resultSet.getString("supplier_name"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return supplier;
	}	
	
	/**
	 * insert Supplier
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void createSupplier(Supplier form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
			
			String sql = "INSERT INTO supplier (supplier_id, supplier_name, delivery_id) VALUES(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getSupplier_id());
		    preparestatement.setString(2,form.getSupplier_name());
		    preparestatement.setString(3,form.getDelivery_id());
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
	public void update(Supplier form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
			
			String sql = "UPDATE supplier SET supplier_name = ?, delivery_id = ? where supplier_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    //preparestatement.setString(1,form.getSupplier_id());
			preparestatement.setString(1,form.getSupplier_name());
		    preparestatement.setString(2,form.getDelivery_id());
		    preparestatement.setString(3,form.getSupplier_id());
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
	public void delete(String sid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
			
			String sql = "delete from supplier where supplier_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,sid);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}