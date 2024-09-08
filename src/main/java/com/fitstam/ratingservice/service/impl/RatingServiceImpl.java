package com.fitstam.ratingservice.service.impl;

import com.fitstam.ratingservice.entities.Hotel;
import com.fitstam.ratingservice.entities.Rating;
import com.fitstam.ratingservice.external.HotelService;
import com.fitstam.ratingservice.repos.RatingRepo;
import com.fitstam.ratingservice.service.RatingService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepo repo;

    @Autowired
    public HotelService hotelService;
    @Override
    public Rating createRating(Rating rating) {
        rating.setRatingId(UUID.randomUUID().toString());
        return repo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        List<Rating> ratingStream = repo.findAll().stream().map(rating -> {
            Hotel hotel = hotelService.getHotelsByHotelId(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        return ratingStream;
    }

    @Override
    public List<Rating> getAllByUserId(String userId) {
        List<Rating> collect = repo.findByUserId(userId).stream().map(rating -> {
            Hotel hotel = hotelService.getHotelsByHotelId(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<Rating> getAllByHotelId(String hotelId) {
        List<Rating> ratinglist = repo.findByHotelId(hotelId);
        List<Rating> finalRatingList = ratinglist.stream().map(rating -> {
            Hotel hotel = hotelService.getHotelsByHotelId(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        return finalRatingList;
    }
}
