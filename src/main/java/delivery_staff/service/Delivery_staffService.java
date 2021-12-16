package delivery_staff.service;


import java.util.List;

import delivery_staff.dao.Delivery_staffDao;
import delivery_staff.domain.Delivery_staff;

/**
 * logic functions such as register, login
 * @author Vineeth Myneedi
 *
 */
public class Delivery_staffService {
	private Delivery_staffDao delivery_staffDao = new Delivery_staffDao();
	
	/**
	 * register a Supplier
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Delivery_staff form) throws Delivery_staffException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Supplier
		Delivery_staff delivery_staff = delivery_staffDao.findBydelivery_id(form.getSupplier_id());
		if(delivery_staff.getDelivery_id() !=null && delivery_staff.getDelivery_id().equals(form.getSupplier_id())) throw new Delivery_staffException("This user name has been registered!");
		delivery_staffDao.createDelivery_staff(form);
	}
	
	public List<Object> findDelivery_staff() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return Delivery_staffDao.findDelivery_staff();
		
	}
}