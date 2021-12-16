package customer.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.dao.CustomerDao;
import customer.domain.Customer;

/**
 * Servlet implementation class UserServlet
 */

public class CustomerServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServletUpdate() {
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
		CustomerDao customerDao = new CustomerDao();
		Customer customer = null;
		
		Map<String,String[]> paramMap = request.getParameterMap();
		Customer form = new Customer();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		System.out.println(info.get(0));
		System.out.println(info.get(1));

		if(method.equals("search"))
		{
			try {
				customer = customerDao.findBycustomer_id(info.get(1));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(customer.getCustomer_id() !=null){
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("/jsps/customer/customer_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Customer not found");
				request.getRequestDispatcher("/jsps/customer/customer_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{

			form.setCustomer_id(info.get(1));
			form.setCustomer_name(info.get(2));
			form.setCustomer_address(info.get(3));
			form.setCustomer_age(Integer.valueOf(info.get(4)));
			form.setDelivery_id(info.get(5));

			try {
				customerDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Customer Updated");
			request.getRequestDispatcher("/jsps/customer/customer_read_output.jsp").forward(request, response);
		}
	}
}