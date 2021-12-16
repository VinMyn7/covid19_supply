package delivery_staff.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_staff.domain.Delivery_staff;
import delivery_staff.service.Delivery_staffException;
import delivery_staff.service.Delivery_staffService;


/**
 * Servlet implementation class UserServlet
 */

public class Delivery_staffServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delivery_staffServletCreate() {
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
		Delivery_staffService delivery_staffservice = new Delivery_staffService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Delivery_staff form = new Delivery_staff();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setDelivery_id(info.get(0));	
		form.setDelivery_staff_id(info.get(1));
		form.setDelivery_date(java.sql.Date.valueOf(info.get(2)));
		form.setSupplier_id(info.get(3));
		
		
		try {
			delivery_staffservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | Delivery_staffException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}