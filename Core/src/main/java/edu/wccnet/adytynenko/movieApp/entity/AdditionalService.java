package edu.wccnet.adytynenko.movieApp.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class AdditionalService {
	
	public Map<String, String> populateGenre() {
		Map<String,String> genreList = new LinkedHashMap<String,String>();
		genreList.put("Action","Action");
		genreList.put("Adventure","Adventure");
		genreList.put("Animation","Animation");
		genreList.put("Comedy","Comedy");
		genreList.put("Crime","Crime");
		genreList.put("Drama","Drama");
		genreList.put("Documentary","Documentary");
		genreList.put("Family","Family");
		genreList.put("Fantasy","Fantasy");
		genreList.put("Horror","Horror");
		genreList.put("Mystery","Mystery");
		genreList.put("Romance","Romance");
		genreList.put("Sci-fi","Sci-fi");
		genreList.put("Thriller","Thriller");
		
		return genreList;
	}
	
	
	public Map<String, String> populateRating() {
		Map<String,String> ratingList = new LinkedHashMap<String,String>();
		ratingList.put("G","G");
		ratingList.put("PG","PG");
		ratingList.put("PG-13","PG-13");
		ratingList.put("R","R");
		ratingList.put("X","X");
		
		return ratingList;
	}
	
	
	public Map<String, String> populateSearch() {
		Map<String,String> searchList = new LinkedHashMap<String,String>();
		searchList.put("title","Title");
		searchList.put("DESC","DESC");
		
		return searchList;
}

}
