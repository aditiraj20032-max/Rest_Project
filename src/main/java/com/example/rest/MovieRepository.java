package com.example.rest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MovieRepository {
	private static Map<Integer, Movie> allMovies;
	static {
		allMovies=new HashMap<>();
		Movie m1=new Movie(101, "life of pi", "emotional", 125);
		Movie m2=new Movie(102, "life of pi", "emotional", 125);
		Movie m3=new Movie(103, "life of pi", "emotional", 125);
		Movie m4=new Movie(104, "conjuring", "horror", 125);
		Movie m5=new Movie(105, "IT", "horror", 125);
//		Movie m4=new Movie(104, "life of pi", "emotional", 125);
		
		allMovies.put(m1.getMovieId(), m1);
		allMovies.put(m2.getMovieId(), m2);
		allMovies.put(m3.getMovieId(), m3);
		allMovies.put(m4.getMovieId(), m4);
		allMovies.put(m5.getMovieId(), m5);

		
	}
	public static Collection<Movie> getAllMovies(){
		Collection<Movie> allAvailableMovies=allMovies.values();
		return allAvailableMovies;
		
	}
	public static Movie getMovieById(Integer id) {
		Movie foundMovie=allMovies.get(id);
		return foundMovie;
	}
	public static void createNewMovie(Movie movieObject) {
		allMovies.put(movieObject.getMovieId(), movieObject);
	}
	public static void updateMovie(Movie movieObject) {
		allMovies.put(movieObject.getMovieId(), movieObject);
	}
	public static void deleteMovie(Integer movieId) {
		allMovies.remove(movieId);
		
	}
}
