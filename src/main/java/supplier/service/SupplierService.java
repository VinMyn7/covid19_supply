package supplier.service;


import supplier.dao.SupplierDao;
import supplier.domain.Supplier;

/**
 * logic functions such as register, login
 * @author Vineeth Myneedi
 *
 */
public class SupplierService {
	private SupplierDao supplierDao = new SupplierDao();
	
	/**
	 * register a Supplier
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Supplier form) throws SupplierException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Supplier
		Supplier supplier = supplierDao.findBysupplier_id(form.getSupplier_id());
		if(supplier.getSupplier_id() !=null && supplier.getSupplier_id().equals(form.getSupplier_id())) throw new SupplierException("This user name has been registered!");
		supplierDao.createSupplier(form);
	}
}