package edu.wccnet.adytynenko.movieApp.Service;

import java.util.List;

import edu.wccnet.adytynenko.movieApp.entity.Movie;

public interface MovieService {

	public List<Movie> getMovies();
	
	public List<Movie> getMovies(String searchType, String searchString);
	
	public Movie getMovie(int id);

	public void saveMovie(Movie movie);
	
}
