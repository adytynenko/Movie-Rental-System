package edu.wccnet.adytynenko.movieApp.dao;

import java.util.List;

import edu.wccnet.adytynenko.movieApp.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public Customer getCustomer(int id);

}
