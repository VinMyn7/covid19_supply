package customer.service;


import customer.dao.CustomerDao;
import customer.domain.Customer;

/**
 * logic functions such as register, login
 * @author Vineeth Myneedi
 *
 */
public class CustomerService {
	private CustomerDao customerDao = new CustomerDao();
	
	/**
	 * register a Supplier
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Customer form) throws CustomerException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Supplier
		Customer customer = customerDao.findBycustomer_id(form.getCustomer_id());
		if(customer.getCustomer_id() !=null && customer.getCustomer_id().equals(form.getCustomer_id())) throw new CustomerException("This user name has been registered!");
		customerDao.createCustomer(form);
	}
}