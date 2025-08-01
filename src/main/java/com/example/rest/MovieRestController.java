package com.example.rest;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins= {"http://localhost:8000"}) //ojet server
public class MovieRestController {
	@RequestMapping("/movie-api") // default GET
	public Collection<Movie> getAllMovies(){
		Collection<Movie> movieCollection=MovieRepository.getAllMovies();
		return movieCollection;
	}
	@RequestMapping("/movie-api/{id}")
	public Movie getSingleMovie(@PathVariable Integer id) {
		Movie loaded_movie=MovieRepository.getMovieById(id);
		if (loaded_movie==null) {
			throw new MovieNotFoundException("Movie not found!");
		}
		return loaded_movie;
	}
	@RequestMapping("movie-api/having-genre/{genre}")
	public Collection<Movie> getAllMovieHavingGenre(@PathVariable String genre){
		Collection<Movie> movieCollection=MovieRepository.getAllMovies();
		//collection ->stream
		Stream<Movie> filteredStream=
		movieCollection.stream().filter(currentMovie ->currentMovie.getGenre().equals(genre));
		//stream -> collection
		return filteredStream.collect(Collectors.toList());
		
//		return MovieRepository.getAllMovies().stream().filter(cm -> cm.getGenre().equals(genre))
//				.collect(Collectors.toList());
	}
	
	@RequestMapping(value="/movie-api", method = RequestMethod.POST)
	public void addNewMovie(@RequestBody Movie m) {
		System.out.println("Accepted new movie."+m);
		MovieRepository.createNewMovie(m);
		
	}
	@PutMapping("/movie-api")
	public void updateMovie(@RequestBody Movie m) {
		MovieRepository.updateMovie(m);
	}
	@DeleteMapping("/movie-api/{Id}")
	public void deleteMovie(@PathVariable Integer Id) {
		MovieRepository.deleteMovie(Id);
	}
	@PostMapping("/movie-info")
	public void acceptMovieInfo(@RequestBody MovieInfo movieInfoRef) {
		System.out.println(movieInfoRef);
	}
	
	
}
