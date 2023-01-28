package edu.wccnet.adytynenko.movieApp.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "checkout")
public class Checkout {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "checkout_date")
	private LocalDateTime checkoutDate;
	
	@Column(name = "returned_date")
	private LocalDateTime returnedDate;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "movie_id")
	private Movie movie;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDateTime checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public LocalDateTime getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(LocalDateTime returnedDate) {
		this.returnedDate = returnedDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	

	public Checkout(Customer customer, Movie movie) {
		super();
		this.customer = customer;
		this.movie = movie;
	}

	
	@Override
	public String toString() {
		return "Checkout [id=" + id + ", movie=" + movie.getTitle() + ", checkoutDate=" + checkoutDate + ", returnedDate=" + returnedDate
				+ ", customer=" + customer.getId() + "]";
	}

	public Checkout() {
		
	}
	
	public Checkout(Customer customer) {
			this.customer = customer;
		}

}
