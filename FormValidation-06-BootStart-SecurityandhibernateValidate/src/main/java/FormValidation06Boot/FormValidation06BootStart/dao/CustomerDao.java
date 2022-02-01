package FormValidation06Boot.FormValidation06BootStart.dao;

import java.util.List;
import FormValidation06Boot.FormValidation06BootStart.entity.Customer;


public interface CustomerDao {
	
	public List<Customer> getCustomers();

	public void save(Customer theCustomer);

	public Customer getCustomers(int theId);

	public void deleteCustomer(int theId);
}
