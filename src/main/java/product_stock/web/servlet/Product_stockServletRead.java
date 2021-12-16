package product_stock.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product_stock.dao.Product_stockDao;
import product_stock.domain.Product_stock;


/**
 * Servlet implementation class UserServlet
 */

public class Product_stockServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product_stockServletRead() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product_stock product_stock = null;
		Product_stockDao product_stockDao = new Product_stockDao();
		
		try {
			product_stock = product_stockDao.findByproduct_id(request.getParameter("product_id"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(product_stock.getSupplier_id()!=null){
					System.out.println(product_stock);
					request.setAttribute("product_stock", product_stock);
					request.getRequestDispatcher("/jsps/product_stock/product_stock_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Product Stock not found");
			request.getRequestDispatcher("/jsps/product_stock/product_stock_read_output.jsp").forward(request, response);
		}
	}
	
}