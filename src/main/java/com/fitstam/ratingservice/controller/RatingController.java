package com.fitstam.ratingservice.controller;

import com.fitstam.ratingservice.entities.Rating;
import com.fitstam.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService service;

    @PostMapping("/createRating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createRating(rating));
    }
    @GetMapping("/getAllRatings")
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.ok(service.getAllRatings());
    }

    @GetMapping("/getRatingByUserId/{userId}")
    public ResponseEntity<List<Rating>> getAllByUserId(@PathVariable String userId){
        return ResponseEntity.ok(service.getAllByUserId(userId));
    }

    @GetMapping("/getRatingByHotelId/{hotelId}")
    public ResponseEntity<List<Rating>> getAllByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(service.getAllByHotelId(hotelId));
    }
}
