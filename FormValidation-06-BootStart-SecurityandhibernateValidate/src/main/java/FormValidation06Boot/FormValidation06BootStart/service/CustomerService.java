package FormValidation06Boot.FormValidation06BootStart.service;

import java.util.List;

import FormValidation06Boot.FormValidation06BootStart.entity.Customer;


public interface CustomerService {
	
	List<Customer> getCustomers();

	void saveCustomer(Customer theCustomer);

	Customer getCustomers(int theId);

	void deleteCustomer(int theId);

}
