package supplier.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supplier.dao.SupplierDao;
import supplier.domain.Supplier;


/**
 * Servlet implementation class UserServlet
 */

public class SupplierServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierServletRead() {
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
		Supplier supplier = null;
		SupplierDao supplierDao = new SupplierDao();
		
		try {
			supplier = supplierDao.findBysupplier_id(request.getParameter("supplier_id"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(supplier.getSupplier_id()!=null){
					System.out.println(supplier);
					request.setAttribute("supplier", supplier);
					request.getRequestDispatcher("/jsps/supplier/supplier_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Supplier not found");
			request.getRequestDispatcher("/jsps/supplier/supplier_read_output.jsp").forward(request, response);
		}
	}
	
}