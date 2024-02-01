package com.jey.rateflix.service;

import java.util.List;

import com.jey.rateflix.entity.Review;


public interface ReviewService{

    String addReview(Review review, Long movieId);
    String deleteReview(Long movieId);
    List<Review> getAllReviews();

}
