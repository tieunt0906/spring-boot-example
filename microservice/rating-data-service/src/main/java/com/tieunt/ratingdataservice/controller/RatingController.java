package com.tieunt.ratingdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tieunt.ratingdataservice.model.Rating;
import com.tieunt.ratingdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {
	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		return new Rating(movieId, 4);
	}
	
	@GetMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("550", 4),
				new Rating("100", 3)
		);
		
		return new UserRating(ratings);
	}
}
