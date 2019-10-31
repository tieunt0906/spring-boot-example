package com.tieunt.ratingdataservice.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRating {
	private List<Rating> ratings;
}
