package FormValidation06Boot.FormValidation06BootStart.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import FormValidation06Boot.FormValidation06BootStart.entity.Customer;

@Repository
public class CustomerDaoImp implements CustomerDao {
	
	
	private EntityManager entitymanager;
	
	@Autowired
	public CustomerDaoImp(EntityManager entitymanager)
	{
		this.entitymanager=entitymanager;
	}

	@Override
	public List<Customer> getCustomers() {
		
		Session currentsession=entitymanager.unwrap(Session.class);
		Query<Customer> thequery=currentsession.createQuery("from Customer order by lastName",Customer.class);
		 List<Customer> customers=thequery.getResultList();
		
		return customers;
	}

	@Override
	public void save(Customer theCustomer) {
		Session currentsession=entitymanager.unwrap(Session.class);
		currentsession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomers(int theId) {
		Session currentsession=entitymanager.unwrap(Session.class);
	Customer thecustomer=  currentsession.get(Customer.class, theId);
		return thecustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session currentsession=entitymanager.unwrap(Session.class);
		//Customer thecustomer=  currentsession.get(Customer.class, theId);
		//currentsession.delete(thecustomer);*/
		Query<Customer> thequery=currentsession.
				createQuery("delete from Customer where id=:customerId");
		thequery.setParameter("customerId", theId);
		thequery.executeUpdate();
		
	}

}
