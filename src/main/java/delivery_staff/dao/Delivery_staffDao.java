package delivery_staff.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import delivery_staff.domain.Delivery_staff;




//import java.util.ArrayList;
//import java.util.List;


/**
 * DDL functions performed in database
 */
public class Delivery_staffDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "root"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "mvt@3107"; //TODO change password

	public Delivery_staff findBydelivery_id(String did) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Delivery_staff delivery_staff = new Delivery_staff();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
		    String sql = "SELECT * from delivery_staff WHERE delivery_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,did);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String delivery_id = resultSet.getString("delivery_id");
		    	if(delivery_id.equals(did)){
		    		delivery_staff.setDelivery_id(resultSet.getString("delivery_id"));
		    		delivery_staff.setDelivery_staff_id(resultSet.getString("delivery_staff_id"));
		    		delivery_staff.setDelivery_date(java.sql.Date.valueOf(resultSet.getString("delivery_date")));
		    		delivery_staff.setSupplier_id(resultSet.getString("supplier_id"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return delivery_staff;
	}	
	
	/**
	 * insert Supplier
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void createDelivery_staff(Delivery_staff form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
			
			String sql = "INSERT INTO Delivery_staff (delivery_id, delivery_staff_id, delivery_date, supplier_id) VALUES(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getDelivery_id());
		    preparestatement.setString(2,form.getDelivery_staff_id());
		    preparestatement.setDate(3,form.getDelivery_date());
		    preparestatement.setString(4,form.getSupplier_id());
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
	public void update(Delivery_staff form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
			
			String sql = "UPDATE delivery_staff SET delivery_staff_id = ?, delivery_date = ?, supplier_id = ? where delivery_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setString(1,form.getDelivery_staff_id());
		    preparestatement.setDate(2,form.getDelivery_date());
		    preparestatement.setString(3,form.getSupplier_id());
		    preparestatement.setString(4,form.getDelivery_id());
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
	public void delete(String did) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
			
			String sql = "delete from supplier where delivery_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1, did);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public static List<Object> findDelivery_staff() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply","root", "mvt@3107");
			String sql = "select * from delivery_staff where delivery_id !='DEL345' order by(delivery_date);";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Delivery_staff delivery_staff = new Delivery_staff();
	    		delivery_staff.setDelivery_id(resultSet.getString("delivery_id"));
	    		delivery_staff.setDelivery_staff_id(resultSet.getString("delivery_staff_id"));
	    		delivery_staff.setDelivery_date(java.sql.Date.valueOf(resultSet.getString("delivery_date")));
	    		delivery_staff.setSupplier_id(resultSet.getString("supplier_id"));
	    		list.add(delivery_staff);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
}