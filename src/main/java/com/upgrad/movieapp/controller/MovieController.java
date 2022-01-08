package com.upgrad.movieapp.controller;

import com.upgrad.movieapp.dto.MovieDTO;
import com.upgrad.movieapp.entity.Movie;
import com.upgrad.movieapp.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/movie_app")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping(value = "/saveMovie", produces = MediaType.APPLICATION_JSON_VALUE,
	 consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity saveMovie(MovieDTO movieDTO){
		Movie dtoToEntity = modelMapper.map(movieDTO, Movie.class);
		Movie addMovie = movieService.acceptMovieDetails(dtoToEntity);

		MovieDTO saveMovieDTO = modelMapper.map(addMovie, MovieDTO.class);
		return new ResponseEntity(saveMovieDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/findAllMovies", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getAllMovies(){
		List<Movie> movieList = movieService.getAllMovies();
		List<MovieDTO> movieDTOList = new ArrayList<>();

		for (Movie movie: movieList){
			movieDTOList.add(modelMapper.map(movie, MovieDTO.class));
		}

		return new ResponseEntity(movieDTOList, HttpStatus.OK);
	}

	@GetMapping(value = "findMovieById/{id}" , produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getMovieBasedOnId(@PathVariable(name = "id") int id){
		Movie movie = movieService.getMovieDetailsById(id);
		MovieDTO movieDTO = modelMapper.map(movie, MovieDTO.class);

		return new ResponseEntity(movieDTO, HttpStatus.OK);
	}

//	@PutMapping(value = "updateMovie/{id}" , produces = MediaType.APPLICATION_JSON_VALUE,
//			consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity updateMovie(@PathVariable(name = "id") int id, @RequestBody MovieDTO movieDTO){
//		Movie movie = movieService.getMovieDetailsById(id);
//		MovieDTO movieDTO = modelMapper.map(movie, MovieDTO.class);
//
//		return new ResponseEntity(movieDTO, HttpStatus.OK);
//	}
}
