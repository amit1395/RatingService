package com.fitstam.ratingservice.service.impl;

import com.fitstam.ratingservice.entities.Rating;
import com.fitstam.ratingservice.repos.RatingRepo;
import com.fitstam.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepo repo;


    @Override
    public Rating createRating(Rating rating) {
        rating.setRatingId(UUID.randomUUID().toString());
        return repo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return repo.findAll();
    }

    @Override
    public List<Rating> getAllByUserId(String userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllByHotelId(String hotelId) {
        return repo.findByHotelId(hotelId);
    }
}
