package edu.wccnet.adytynenko.movieApp.entity;

public class SearchRequest {
	
	private String searchType;
	
	private String searchString;

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public SearchRequest(String searchType, String searchString) {
		super();
		this.searchType = searchType;
		this.searchString = searchString;
	}

	@Override
	public String toString() {
		return "SearchRequest [searchType=" + searchType + ", searchString=" + searchString + "]";
	}
	
	public SearchRequest() {
		
	}
	

}
