package customer.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.dao.CustomerDao;
import customer.domain.Customer;


/**
 * Servlet implementation class UserServlet
 */

public class CustomerServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServletDelete() {
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
		if(method.equals("search"))
		{
			//System.out.println(request.getParameter("customer_id"));
			try {
				customer = customerDao.findBycustomer_id(request.getParameter("customer_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			if(customer.getCustomer_id() !=null){
						//System.out.println(customer);
						request.setAttribute("customer", customer);
						request.getRequestDispatcher("/jsps/customer/customer_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Customer not found");
				request.getRequestDispatcher("/jsps/customer/customer_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				System.out.println(request.getParameter("customer_id"));
				customerDao.delete(request.getParameter("customer_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Customer Deleted");
			request.getRequestDispatcher("/jsps/customer/customer_read_output.jsp").forward(request, response);
		}
	}	
}
