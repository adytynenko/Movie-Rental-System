 package edu.wccnet.adytynenko.movieApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.adytynenko.movieApp.controller.NotFoundException;
import edu.wccnet.adytynenko.movieApp.dao.CustomerDAO;
import edu.wccnet.adytynenko.movieApp.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}


	@Override
	@Transactional
	public Customer getCustomer(int id) {
		
		Customer customer = customerDAO.getCustomer(id);
		if (customer == null) {
			throw new NotFoundException("customer Id not found. Id: " + id);
		}
		
		return customerDAO.getCustomer(id);
	}

	
}
