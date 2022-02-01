package FormValidation06Boot.FormValidation06BootStart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import FormValidation06Boot.FormValidation06BootStart.entity.Customer;
import FormValidation06Boot.FormValidation06BootStart.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder)
	{
		StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true); 
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
	}
	
	//dependency injection
	private CustomerService customerservice;
	
	@Autowired
	public CustomerController(CustomerService customerservice)
	{
		this.customerservice=customerservice;
	}
	
	@GetMapping("/list")
	public String listCustomers(Model theModel)
	{
		List<Customer> customer=customerservice.getCustomers();
		//addAttribute bind data from java object(here database) to customers that is passed to jsp
		theModel.addAttribute("customers", customer);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd( Model theModel)
	{
		
		//since no data so it simply return empty field
		Customer theCustomer=new Customer();
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	//saving to database
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer")Customer theCustomer,BindingResult theBindingResult)
	{
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		}
		else {
		//get data from customer entered in jsp
		customerservice.saveCustomer(theCustomer);
		return "redirect:/customer/list";
		}
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int theId,Model theModel)
	{
		Customer theCustomer=customerservice.getCustomers(theId);
		//pre-populate data
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId")int theId,Model theModel)
	{
		//Customer theCustomer=customerservice.getCustomers(theId);
		//theModel.addAttribute("customer",theCustomer);
		customerservice.deleteCustomer(theId);
		return "redirect:/customer/list";
	}

}
