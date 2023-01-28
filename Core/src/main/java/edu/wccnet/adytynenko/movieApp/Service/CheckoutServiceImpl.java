 package edu.wccnet.adytynenko.movieApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.adytynenko.movieApp.controller.NotFoundException;
import edu.wccnet.adytynenko.movieApp.dao.CheckoutDAO;
import edu.wccnet.adytynenko.movieApp.entity.Checkout;

@Service
public class CheckoutServiceImpl implements CheckoutService {
	
	@Autowired
	private CheckoutDAO checkoutDAO;
	
	@Transactional
	public List<Checkout> getCheckouts() {
		return checkoutDAO.getCheckouts();
	}
	
	@Transactional
	public List<Checkout> getCheckouts(int customerId) {
		List<Checkout> checkouts = checkoutDAO.getCheckouts(customerId);
		
		if (checkouts.isEmpty()) {
			throw new NotFoundException("customer Id not found. Id: " + customerId);
		}
		return checkouts;
	}
	
	
	@Transactional
	public Checkout getCheckout(int id) {
		
		Checkout checkout = checkoutDAO.getCheckout(id);
		
		if (checkout == null) {
			throw new NotFoundException("checkout Id not found. Id: " + id);
		}
		
		return checkoutDAO.getCheckout(id);
	}
	
	@Transactional
	public void saveCheckout(Checkout checkout) {
		checkoutDAO.saveCheckout(checkout);
	}


	
}
