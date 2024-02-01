package com.jey.rateflix.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jey.rateflix.entity.Movie;
import com.jey.rateflix.entity.Review;
import com.jey.rateflix.exception.MovieNotFoundException;
import com.jey.rateflix.exception.ReviewNotFoundException;
import com.jey.rateflix.repository.MovieRepository;
import com.jey.rateflix.repository.ReviewRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ReviewServiceImp implements ReviewService{

    ReviewRepository reviewRepository;
    MovieRepository movieRepository;

    @Override
    public String addReview(Review review, Long movieId) { 
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("id", movieId.toString()));
        review.setMovie(movie);
        reviewRepository.save(review);
        return "Review added successfully";
    }

    @Override
    public String deleteReview(Long movieId) {
        movieRepository.findById(movieId).orElseThrow(() -> new ReviewNotFoundException("id", movieId.toString()));
        reviewRepository.deleteById(movieId);
        return "Review deleted successfully";
    }

    @Override
    public List<Review> getAllReviews() {
        return (List<Review>) reviewRepository.findAll();
    }


    
}
