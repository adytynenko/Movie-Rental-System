package edu.wccnet.adytynenko.movieApp.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.wccnet.adytynenko.movieApp.Service.CheckoutService;
import edu.wccnet.adytynenko.movieApp.Service.CustomerService;
import edu.wccnet.adytynenko.movieApp.Service.MovieService;
import edu.wccnet.adytynenko.movieApp.entity.Customer;
import edu.wccnet.adytynenko.movieApp.entity.Movie;
import edu.wccnet.adytynenko.movieApp.entity.SearchRequest;
import edu.wccnet.adytynenko.movieApp.entity.AdditionalService;
import edu.wccnet.adytynenko.movieApp.entity.Checkout;

@Controller
public class MainController {
	
	@Autowired
	private AdditionalService additionalService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private CheckoutService checkoutService;
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("customers", customerService.getCustomers());
		
		return "home";
	}
	
	@GetMapping("/customerHistory")
	public String customerHistory(Model model, @RequestParam("customerId") int id) {
		
		model.addAttribute("checkouts", checkoutService.getCheckouts(id));
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customerName", customer.getFirstName() + " " + customer.getLastName());
		model.addAttribute("customerId", customer.getId());
		
		return "customer-page";

	}
	
	@GetMapping("/movie")
	public String movie(Model model, @RequestParam("movieId") int movieId) {
		
		Movie movie = movieService.getMovie(movieId);
		model.addAttribute("movie", movie);
		
		return "movie";
	}
	
	@GetMapping("/movies")
	public String listMovies(Model model, @RequestParam("customerId") int customerId) {
		
		model.addAttribute("movies", movieService.getMovies());
		model.addAttribute("customerId", customerId);
		
		return "list-movies";
	}
	
	@GetMapping("/addMovie")
	public String addMovie(Model model, @RequestParam("customerId") int customerId) {
		
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		model.addAttribute("customerId", customerId);
		
		return "add-movie";
	}
	
	@RequestMapping("/processMovie")
	public String processMovie(Model model, @Valid @ModelAttribute("movie") Movie movie, BindingResult result, @RequestParam("customerId") int customerId) {
		model.addAttribute("customerId", customerId);
		
		if(result.hasErrors()) {
			return "add-movie";
			
		} else {
			
			movie.setAvailableCopies(movie.getTotalCopies());
			movieService.saveMovie(movie);
			
			return "redirect:/movies";
		}
	}

	@InitBinder
	public void initialBinderForTrimmingSpaces(WebDataBinder webDataBinder) {
	    StringTrimmerEditor stringTrimEditor = new StringTrimmerEditor(true);
	    webDataBinder.registerCustomEditor(String.class, stringTrimEditor);
	}
	
	
	@RequestMapping("/searchForm")
	public ModelAndView searchForm(Model model, @RequestParam("customerId") int customerId) {

		model.addAttribute("customerId", customerId);
		
		return new ModelAndView("search-form", "newSearch", new SearchRequest());
		
	}
		
	@RequestMapping("/searchOutput")
	public String searchOutput(Model model, @ModelAttribute("newSearch") SearchRequest searchRequest, @RequestParam("customerId") int customerId) {
		
		String searchType = searchRequest.getSearchType();
		String searchString = searchRequest.getSearchString();
		
		List<Movie> movies = new ArrayList<>();
		
		if (searchType == null || searchString == null) {
			movies = movieService.getMovies();
		} else {
			movies = movieService.getMovies(searchType, searchString);
		}
		
		model.addAttribute("movies", movies);
		model.addAttribute("customerId", customerId);
		
		return "list-movies";
	}
	
	
	@RequestMapping("/returnMovie")
	public String returnMovie(Model model, @RequestParam("checkoutId") int checkoutId, @RequestParam("customerId") int customerId) {
		
		Checkout checkout = checkoutService.getCheckout(checkoutId);
		checkout.setReturnedDate(LocalDateTime.now());
		model.addAttribute("checkout", checkout);
		model.addAttribute("customerId", customerId);
		checkoutService.saveCheckout(checkout);
		Movie movie = checkout.getMovie();
		String availableCopies = movie.getAvailableCopies();
		int availableCopiesInt = (Integer.parseInt(availableCopies))+1;
		movie.setAvailableCopies(String.valueOf(availableCopiesInt));
		
		//movie.setAvailableCopies((movie.getAvailableCopies())+1);
		
		movieService.saveMovie(movie);
			
		return "redirect:/customerHistory";
	}
	
	
	@RequestMapping("/checkoutMovie")
	public String checkoutMovie(Model model, @RequestParam("movieId") int movieId, @RequestParam("customerId") int customerId) {
		
		Movie movie = movieService.getMovie(movieId);
		String availableCopies = movie.getAvailableCopies();
		int availableCopiesInt = (Integer.parseInt(availableCopies))-1;
		movie.setAvailableCopies(String.valueOf(availableCopiesInt));
		
		//movie.setAvailableCopies(availableCopiesInt-1);
		
		movieService.saveMovie(movie);
		Customer customer = customerService.getCustomer(customerId);
		Checkout checkout = new Checkout(customer, movie);
		checkout.setCheckoutDate(LocalDateTime.now());
		model.addAttribute("checkout", checkout);
		model.addAttribute("customerId", customer.getId());
		checkoutService.saveCheckout(checkout);
		
		return "redirect:/customerHistory";
		
	}
	
	@ModelAttribute
	public void populateFormWithData(Model model) {
		model.addAttribute("genreList", additionalService.populateGenre());
		model.addAttribute("ratingList", additionalService.populateRating());
		model.addAttribute("searchList", additionalService.populateSearch());
	}
		
}
