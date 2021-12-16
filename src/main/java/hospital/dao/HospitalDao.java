package hospital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hospital.domain.Hospital;




//import java.util.ArrayList;
//import java.util.List;


/**
 * DDL functions performed in database
 */
public class HospitalDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "root"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "mvt@3107"; //TODO change password

	public Hospital findByhospital_id(String hid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Hospital hospital = new Hospital();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
		    String sql = "SELECT * from hospital WHERE hospital_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,hid);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String hospital_id = resultSet.getString("hospital_id");
		    	if(hospital_id.equals(hid)){
		    		hospital.setHospital_id(resultSet.getString("hospital_id"));
		    		hospital.setHospital_name(resultSet.getString("hospital_name"));
		    		hospital.setHospital_address(resultSet.getString("hospital_address"));
		    		hospital.setDelivery_id(resultSet.getString("delivery_id"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return hospital;
	}	
	
	/**
	 * insert Hospital
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void createHospital(Hospital form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
			
			String sql = "INSERT INTO hospital (hospital_id, hospital_name, hospital_address, delivery_id) VALUES(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getHospital_id());
		    preparestatement.setString(2,form.getHospital_name());
		    preparestatement.setString(3,form.getHospital_address());
		    preparestatement.setString(4,form.getDelivery_id());
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
	public void update(Hospital form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
			
			String sql = "UPDATE hospital SET hospital_name = ?, hospital_address = ?, delivery_id = ? where hospital_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getHospital_name());
			preparestatement.setString(2,form.getHospital_address());
		    preparestatement.setString(3,form.getDelivery_id());
		    preparestatement.setString(4,form.getHospital_id());
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
	public void delete(String hid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
			
			String sql = "delete from hospital where hospital_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,hid);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}