package com.upgrad.movieapp.service;

import com.upgrad.movieapp.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {

	public Movie acceptMovieDetails(Movie movie);

	public List<Movie> acceptMultipleMovieDetails(List<Movie> movies);

	public Movie getMovieDetailsById(int id);

	public List<Movie> getAllMovies();

	public boolean deleteMovie(int id);

	public Movie updateMovieDetails(int id, Movie movie);

	public Page<Movie> getMoviesByPagination(Pageable pageable);
}
