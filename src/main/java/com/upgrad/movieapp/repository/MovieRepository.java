package com.upgrad.movieapp.repository;

import com.upgrad.movieapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
