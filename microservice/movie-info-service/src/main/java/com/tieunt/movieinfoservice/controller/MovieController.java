package com.tieunt.movieinfoservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tieunt.movieinfoservice.model.Movie;
import com.tieunt.movieinfoservice.model.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieController {
	@Value("${api.key}")
	private String apiKey;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId) {
		Logger logger = LoggerFactory.getLogger(MovieController.class);
		logger.info("apiKey: " + apiKey);
		MovieSummary movieSummary  = restTemplate.getForObject(
				"http://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, 
				MovieSummary.class
		);
				
		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
	}
}
