package product_stock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import product_stock.domain.Product_stock;




//import java.util.ArrayList;
//import java.util.List;


/**
 * DDL functions performed in database
 */
public class Product_stockDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "root"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "mvt@3107"; //TODO change password

	public Product_stock findByproduct_id(String pid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Product_stock product_stock = new Product_stock();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
		    String sql = "SELECT * from product_stock WHERE product_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,pid);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String product_id = resultSet.getString("product_id");
		    	if(product_id.equals(pid)){
		    		product_stock.setProduct_id(resultSet.getString("product_id"));
		    		product_stock.setProduct_name(resultSet.getString("product_name"));
		    		product_stock.setAvailable_quantity(resultSet.getInt("available_quantity"));
		    		product_stock.setSupplier_id(resultSet.getString("supplier_id"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return product_stock;
	}	
	
	/**
	 * insert Product_stock
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void createProduct_stock(Product_stock form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
			
			String sql = "INSERT INTO product_stock (product_id, product_name, available_quantity, supplier_id) VALUES(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getProduct_id());
		    preparestatement.setString(2,form.getProduct_name());
		    preparestatement.setInt(3,form.getAvailable_quantity());
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
	public void update(Product_stock form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
			
			String sql = "UPDATE product_stock SET product_name = ?, available_quantity = ?, supplier_id = ? where product_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setString(3,form.getSupplier_id());
		    preparestatement.setString(1,form.getProduct_name());
		    preparestatement.setInt(2,form.getAvailable_quantity());
		    preparestatement.setString(4,form.getProduct_id());
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
	public void delete(String pid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply", MySQL_user, MySQL_password);
			
			String sql = "delete from product_stock where product_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,pid);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static List<Object> findProductQuantity() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply","root", "mvt@3107");
			String sql = "select SUM(available_quantity) from product_stock;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Product_stock product_stock = new Product_stock();
		    	product_stock.setAvailable_quantity(resultSet.getInt("SUM(available_quantity)"));
		    	list.add(product_stock);
		    }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public static List<Object> findProductName() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid19_supply","root", "mvt@3107");
			String sql = "SELECT DISTINCT product_name  FROM product_stock WHERE EXISTS (SELECT * FROM supplier WHERE product_stock.supplier_id = supplier.supplier_id)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Product_stock product_stock = new Product_stock();
		    	product_stock.setProduct_name(resultSet.getString("product_name"));
		    	list.add(product_stock);
		    }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}