 package edu.wccnet.adytynenko.movieApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.adytynenko.movieApp.controller.NotFoundException;
import edu.wccnet.adytynenko.movieApp.dao.MovieDAO;
import edu.wccnet.adytynenko.movieApp.entity.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	
	@Autowired
	private MovieDAO movieDAO;
	
	
	@Override
	@Transactional
	public List<Movie> getMovies() {
		return movieDAO.getMovies();
	}
	
	@Transactional
	public Movie getMovie(int id) {
		
		Movie movie = movieDAO.getMovie(id);
		
		if (movie == null) {
			throw new NotFoundException("movie Id not found. Id: " + id);
		}
		
		return movie;
	}

	@Transactional
	public void saveMovie(Movie movie) {
		movieDAO.saveMovie(movie);
	}

	
	@Transactional
	public List<Movie> getMovies(String searchType, String searchString) {
		
		List<Movie> movies = movieDAO.getMovies(searchType, searchString);
		
//		if (movies.isEmpty()) {		
//			movies = movieDAO.getMovies();
//		}
		
		return movies;		
	}

}
