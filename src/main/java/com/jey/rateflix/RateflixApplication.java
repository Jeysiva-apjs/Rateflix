package com.jey.rateflix;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jey.rateflix.entity.Movie;
import com.jey.rateflix.entity.Review;
import com.jey.rateflix.service.MovieService;
import com.jey.rateflix.service.ReviewService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class RateflixApplication implements CommandLineRunner{

	MovieService movieService;
	ReviewService reviewService;

	public static void main(String[] args) {
		SpringApplication.run(RateflixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			Movie movie = new Movie("Movie " + (i + 1), "Description " + (i + 1), "Genre " + (i + 1), 0.0);
			movieService.addMovie(movie);
			
			for (int j = 0; j < 25; j++) {
				Review review = new Review(5.0, "Review " + (j + 1));
				reviewService.addReview(review, movie.getId());	
			}
		}
	}

}
