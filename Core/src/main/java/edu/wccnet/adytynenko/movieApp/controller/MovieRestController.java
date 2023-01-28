package edu.wccnet.adytynenko.movieApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.wccnet.adytynenko.movieApp.Service.CheckoutService;
import edu.wccnet.adytynenko.movieApp.Service.MovieService;
import edu.wccnet.adytynenko.movieApp.entity.Checkout;
import edu.wccnet.adytynenko.movieApp.entity.Movie;

@RestController
@RequestMapping("/api")
public class MovieRestController {
	
	@Autowired
	private MovieService movieService;
	@Autowired
	private CheckoutService checkoutService;
	
	//checkouts
	@GetMapping("/checkouts")
	public List<Checkout> getCheckouts() {
		return checkoutService.getCheckouts();
	}
	
	@GetMapping("/checkouts/customer/{customerId}")
	public List<Checkout> getCheckouts(@PathVariable int customerId) {
		return checkoutService.getCheckouts(customerId);
	}
	
	//movies
	@GetMapping("/movies")
	public List<Movie> getMovies() {
		
		return movieService.getMovies(); 
	}
	
	@GetMapping("/movies/title/{title}")
	public List<Movie> getMovies(String searchType, @PathVariable String title) {
		
		List<Movie> movies = movieService.getMovies("title", title);
		
		if (movies.isEmpty()) {
			throw new NotFoundException("movie title not found. Title: " + title);
		}
		
		return movies;
	}
	
	@ExceptionHandler
	public ResponseEntity<MovieErrorResponse> handleException(NotFoundException e){
		MovieErrorResponse error = new MovieErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<MovieErrorResponse> handleException(Exception e){
		MovieErrorResponse error = new MovieErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
