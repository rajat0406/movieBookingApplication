package com.upgrad.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
	private int movieId;

	private String movieName;

	private String movieDescription;

	private LocalDateTime releaseDate;

	private int duration;

	private String coverPhotoURL;

	private String trailerURL;
}
