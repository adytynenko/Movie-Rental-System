package edu.wccnet.adytynenko.movieApp.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.adytynenko.movieApp.entity.Checkout;
import edu.wccnet.adytynenko.movieApp.entity.Customer;

@Repository
public class CheckoutDAOimpl implements CheckoutDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Checkout> getCheckouts() {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Checkout> query = session.createQuery("from Checkout",
				Checkout.class);
		
		return query.getResultList();

	}
	
	@Override
	public List<Checkout> getCheckouts(int customerId) {
		
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, customerId);
		Query<Checkout> query = session.createQuery("from Checkout c where c.customer = :customer",
				Checkout.class);
		query.setParameter("customer", customer);
		List<Checkout> checkouts = query.getResultList();
		return checkouts;

	}
	
	public Checkout getCheckout(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Checkout> query = session.createQuery("from Checkout c where c.id = :checkoutId",
				Checkout.class);
		query.setParameter("checkoutId", id);
		Checkout checkout = query.getSingleResult();
		
		return checkout;
		
	}
	
	
	public void saveCheckout(Checkout checkout) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(checkout);
	}
	
}
