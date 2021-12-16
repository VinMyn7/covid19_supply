package delivery_staff.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_staff.dao.Delivery_staffDao;
import delivery_staff.domain.Delivery_staff;


/**
 * Servlet implementation class UserServlet
 */

public class Delivery_staffServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delivery_staffServletRead() {
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
		Delivery_staff delivery_staff = null;
		Delivery_staffDao delivery_staffDao = new Delivery_staffDao();
		
		try {
			delivery_staff = delivery_staffDao.findBydelivery_id(request.getParameter("delivery_id"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(delivery_staff.getDelivery_id()!=null){
					System.out.println(delivery_staff);
					request.setAttribute("delivery_staff", delivery_staff);
					request.getRequestDispatcher("/jsps/delivery_staff/delivery_staff_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "delivery_staff not found");
			request.getRequestDispatcher("/jsps/delivery_staff/delivery_staff_read_output.jsp").forward(request, response);
		}
	}
	
}