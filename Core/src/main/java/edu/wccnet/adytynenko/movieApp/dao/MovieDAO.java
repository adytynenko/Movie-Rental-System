package edu.wccnet.adytynenko.movieApp.dao;

import java.util.List;

import edu.wccnet.adytynenko.movieApp.entity.Movie;

public interface MovieDAO {
	
	public List<Movie> getMovies();
	
	public List<Movie> getMovies(String searchType, String searchString);
	
	public Movie getMovie(int id);

	public void saveMovie(Movie movie);
	
}
