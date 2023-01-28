package edu.wccnet.adytynenko.movieApp.dao;

import java.util.List;

import edu.wccnet.adytynenko.movieApp.entity.Checkout;

public interface CheckoutDAO {
	
	public List<Checkout> getCheckouts();
	
	public List<Checkout> getCheckouts(int customerId);

	public Checkout getCheckout(int id);

	public void saveCheckout(Checkout checkout);
	
}
