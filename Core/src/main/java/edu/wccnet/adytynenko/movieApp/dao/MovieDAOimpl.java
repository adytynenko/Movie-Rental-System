package edu.wccnet.adytynenko.movieApp.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.adytynenko.movieApp.entity.Movie;

@Repository
public class MovieDAOimpl implements MovieDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Movie> getMovies() {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Movie> query = session.createQuery("from Movie",
				Movie.class);		
		return query.getResultList();
	}
	
	@Override
	public Movie getMovie(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Movie.class, id);
	}
	
	@Override
	public void saveMovie(Movie movie) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(movie);
	}

	public List<Movie> getMovies(String searchType, String searchString) {
		
		String queryStr = "";
		
		if (searchType.equals("title")) {
			queryStr = "from Movie m where m.title like :searchString";
		} else {
			queryStr = "from Movie m where m.description like :searchString";
		}
		
		Session session = sessionFactory.getCurrentSession();
		Query<Movie> query = session.createQuery(queryStr, Movie.class);
		query.setParameter("searchString", "%"+searchString.toUpperCase()+"%");
		
		return query.getResultList();
	}

}
