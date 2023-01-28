package edu.wccnet.adytynenko.movieApp.Service;

import java.util.List;

import edu.wccnet.adytynenko.movieApp.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public Customer getCustomer(int id);

}
