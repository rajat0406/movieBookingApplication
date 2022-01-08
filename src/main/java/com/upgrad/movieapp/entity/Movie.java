package com.upgrad.movieapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;

	@Column(nullable = false, unique = true, length = 50)
	private String movieName;

	@Column(name = "movie_desc", length = 500, nullable = false)
	private String movieDescription;

	@Column(nullable = false)
	private LocalDateTime releaseDate;

	@Column(nullable = false)
	private int duration;

	@Column(nullable = false)
	private String coverPhotoURL;

	@Column(nullable = false)
	private String trailerURL;
}
