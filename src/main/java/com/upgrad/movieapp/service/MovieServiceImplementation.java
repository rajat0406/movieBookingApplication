package com.upgrad.movieapp.service;

import com.upgrad.movieapp.entity.Movie;
import com.upgrad.movieapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImplementation implements MovieService{


	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie acceptMovieDetails(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public List<Movie> acceptMultipleMovieDetails(List<Movie> movies) {
		List<Movie> savedMovies = new ArrayList<>();
		for (Movie movie : movies){
			savedMovies.add(acceptMovieDetails(movie));
		}
		return savedMovies;
	}

	@Override
	public Movie getMovieDetailsById(int id) {
		return movieRepository.findById(id).get();
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public boolean deleteMovie(int id) {
		Movie savedMovie = getMovieDetailsById(id);
		if(savedMovie == null){
			return false;
		}
		movieRepository.delete(savedMovie);
		return true;
	}

	@Override
	public Movie updateMovieDetails(int id, Movie movie) {
		return null;
	}

	@Override
	public Page<Movie> getMoviesByPagination(Pageable pageable) {
		return movieRepository.findAll(pageable);
	}
}
