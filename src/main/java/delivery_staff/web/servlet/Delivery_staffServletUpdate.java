package delivery_staff.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_staff.dao.Delivery_staffDao;
import delivery_staff.domain.Delivery_staff;

/**
 * Servlet implementation class UserServlet
 */

public class Delivery_staffServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Delivery_staffServletUpdate() {
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
		Delivery_staffDao delivery_staffDao = new Delivery_staffDao();
		Delivery_staff delivery_staff = null;
		
		Map<String,String[]> paramMap = request.getParameterMap();
		Delivery_staff form = new Delivery_staff();
		List<String> info = new ArrayList<String>();
		
		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		
		if(method.equals("search"))
		{
			try {
				delivery_staff = delivery_staffDao.findBydelivery_id(info.get(1));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(delivery_staff.getDelivery_id() !=null){
				request.setAttribute("delivery_staff", delivery_staff);
				request.getRequestDispatcher("/jsps/delivery_staff/delivery_staff_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "delivery_staff not found");
				request.getRequestDispatcher("/jsps/delivery_staff/delivery_staff_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			form.setDelivery_id(info.get(1));
			form.setDelivery_staff_id(info.get(2));
			form.setDelivery_date(java.sql.Date.valueOf(info.get(3)));
			form.setSupplier_id(info.get(4));
			
			
			try {
				delivery_staffDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "delivery_staff Updated");
			request.getRequestDispatcher("/jsps/delivery_staff/delivery_staff_read_output.jsp").forward(request, response);
		}
	}
}