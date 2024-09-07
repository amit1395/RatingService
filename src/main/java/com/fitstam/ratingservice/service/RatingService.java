package com.fitstam.ratingservice.service;

import com.fitstam.ratingservice.entities.Rating;
import com.fitstam.ratingservice.repos.RatingRepo;

import java.util.List;

public interface RatingService {

    //create
    Rating createRating(Rating rating);
    //getAll
    List<Rating> getAllRatings();
    //getallbyuserid;
    List<Rating> getAllByUserId(String userId);

    //getallbyhotelid
    List<Rating> getAllByHotelId(String hotelId);
}
