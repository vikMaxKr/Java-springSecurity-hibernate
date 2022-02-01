package FormValidation06Boot.FormValidation06BootStart.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import FormValidation06Boot.FormValidation06BootStart.dao.CustomerDao;
import FormValidation06Boot.FormValidation06BootStart.entity.Customer;

@Service
public class CustomerServiceImp implements CustomerService {
	
	
	private CustomerDao customerdao;
	
	@Autowired
	public CustomerServiceImp(CustomerDao customerdao)
	{
		this.customerdao=customerdao;
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerdao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		 customerdao.save(theCustomer);

	}

	@Override
	@Transactional
	public Customer getCustomers(int theId) {
		
		return customerdao.getCustomers(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerdao.deleteCustomer(theId);

	}

}
