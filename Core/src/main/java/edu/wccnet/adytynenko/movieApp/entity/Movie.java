package edu.wccnet.adytynenko.movieApp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "field is required")
	@Column(name = "title")
	private String title;
	
	@NotBlank(message = "field is required")
	@Size(min = 4, message = "year should be in format YYYY")
	@Column(name = "year")
	private String year;
	
	@NotBlank(message = "field is required")
	@Column(name = "genre")
	private String genre;
	
	@NotBlank(message = "field is required")
	@Column(name = "length")
	private String length;
	
	@NotBlank(message = "field is required")
	@Pattern(regexp = "^[0-9]{2} [A-Z]{1}[a-z]{2} [0-9]{4}$", message = "date should be in format \"DD Mon YYYY\" ")
	@Column(name = "release_date")
	private String releaseDate;
	
	@Column(name = "rating")
	private String rating;
	
	@NotBlank(message = "field is required")
	@Column(name = "description")
	private String description;
	
	@NotBlank(message = "field is required")
	@Pattern(regexp = "[1-9]{1}[0-9]?", message = "total copies cannot be 0")
	@Column(name = "total_copies")
	private String totalCopies;
	
	@Column(name = "available_copies")
	private String availableCopies;
	
	@JsonIgnore
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Checkout> checkouts = new ArrayList<Checkout>();
	
	
	public List<Checkout> getCheckouts() {
		return checkouts;
	}

	public void setCheckouts(List<Checkout> checkouts) {
		this.checkouts = checkouts;
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}



	public String getLength() {
		return length;
	}



	public void setLength(String length) {
		this.length = length;
	}



	public String getReleaseDate() {
		return releaseDate;
	}



	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}



	public String getRating() {
		return rating;
	}



	public void setRating(String rating) {
		this.rating = rating;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getTotalCopies() {
		return totalCopies;
	}



	public void setTotalCopies(String totalCopies) {
		this.totalCopies = totalCopies;
	}



	public String getAvailableCopies() {
		return availableCopies;
	}



	public void setAvailableCopies(String availableCopies) {
		this.availableCopies = availableCopies;
	}



	public Movie(String title, String year, String genre, String length, String releaseDate, String rating, String description,
			String totalCopies, String availableCopies) {
		super();
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.length = length;
		this.releaseDate = releaseDate;
		this.rating = rating;
		this.description = description;
		this.totalCopies = totalCopies;
		this.availableCopies = availableCopies;
	}


	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", genre=" + genre + ", length=" + length
				+ ", releaseDate=" + releaseDate + ", rating=" + rating + ", description=" + description
				+ ", totalCopies=" + totalCopies + ", availableCopies=" + availableCopies + "]";
	}


	public Movie() {
		
	}

}
