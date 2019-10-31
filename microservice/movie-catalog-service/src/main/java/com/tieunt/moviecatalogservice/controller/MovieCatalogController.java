package com.tieunt.moviecatalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tieunt.moviecatalogservice.model.CatalogItem;
import com.tieunt.moviecatalogservice.model.UserRating;
import com.tieunt.moviecatalogservice.service.MovieInfo;
import com.tieunt.moviecatalogservice.service.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	MovieInfo moviInfo;

	@Autowired
	UserRatingInfo userRatingInfo;

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		UserRating userRatings = userRatingInfo.getUserRating(userId);

		return userRatings.getRatings().stream().map(rating -> moviInfo.getCatalogItem(rating))
				.collect(Collectors.toList());
	}
}
