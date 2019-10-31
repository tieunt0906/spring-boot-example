package com.tieunt.moviecatalogservice.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tieunt.moviecatalogservice.model.Rating;
import com.tieunt.moviecatalogservice.model.UserRating;

@Service
public class UserRatingInfo {
	@Autowired
	private RestTemplate restTemplate;

//	place into @Service to wrapper bt proxy
	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public UserRating getUserRating(String userId) {
		return restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" + userId, UserRating.class);
	}

	public UserRating getFallbackUserRating(String userId) {
		return new UserRating(Arrays.asList(new Rating("0", 0)));
	}
}
