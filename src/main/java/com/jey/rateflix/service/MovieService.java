package com.jey.rateflix.service;

import java.util.List;

import com.jey.rateflix.entity.Movie;
import com.jey.rateflix.entity.Review;

public interface MovieService {

    String addMovie(Movie movie);
    String removeMovie(Long id);
    List<Movie> getAllMovies();
    Movie getMovieByTitle(String title);
    List<Movie> getMovieByGenre(String genre);
    List<Review> getMovieReviews(Long id);

    
}
