package com.jey.rateflix.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jey.rateflix.entity.Movie;
import com.jey.rateflix.entity.Review;
import com.jey.rateflix.exception.MovieNotFoundException;
import com.jey.rateflix.repository.MovieRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovieServiceImp implements MovieService{

    private MovieRepository movieRepository;

    @Override
    public String addMovie(Movie movie) {
        movieRepository.save(movie);
        return "Movie added successfully";
    }

    @Override
    public String removeMovie(Long id) {
        movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("id", id.toString()));
        movieRepository.deleteById(id);
        return "Movie deleted successfully";
    }

    @Override
    public List<Movie> getAllMovies() {
        return (List<Movie> )movieRepository.findAll();
    }

    @Override
    public Movie getMovieByTitle(String title) {
        Movie foundMovie = this.getAllMovies().stream().filter(movie -> movie.getTitle().equals(title)).findFirst().orElse(null);
        if (foundMovie == null) {
            throw new MovieNotFoundException("title", title);
        }
        return foundMovie;
    }

    @Override
    public List<Movie> getMovieByGenre(String genre) {
        return this.getAllMovies().stream().filter(movie -> movie.getGenre().equals(genre)).collect(Collectors.toList());
    }

    @Override
    public List<Review> getMovieReviews(Long id) {
        Movie movie =  this.getAllMovies().stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
        if (movie == null) {
            throw new MovieNotFoundException("id", id.toString());
        }
        return movie.getReviews();
    }
}
