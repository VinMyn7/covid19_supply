package product_stock.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product_stock.dao.Product_stockDao;
import product_stock.domain.Product_stock;

/**
 * Servlet implementation class UserServlet
 */

public class Product_stockServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Product_stockServletUpdate() {
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

		String method = request.getParameter("method");
		Product_stockDao Product_stockDao = new Product_stockDao();
		Product_stock product_stock = null;
		
		Map<String,String[]> paramMap = request.getParameterMap();
		Product_stock form = new Product_stock();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}

		if(method.equals("search"))
		{
			try {
				product_stock = Product_stockDao.findByproduct_id(info.get(1));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(product_stock.getProduct_id()!=null){
				request.setAttribute("product_stock", product_stock);
				request.getRequestDispatcher("/jsps/product_stock/product_stock_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Product Stock not found");
				request.getRequestDispatcher("/jsps/product_stock/product_stock_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			form.setProduct_id(info.get(1));
			form.setProduct_name(info.get(2));
			form.setAvailable_quantity(Integer.valueOf(info.get(3)));
			form.setSupplier_id(info.get(4));

			try {
				Product_stockDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Product_stock Updated");
			request.getRequestDispatcher("/jsps/product_stock/product_stock_read_output.jsp").forward(request, response);
		}
	}
}