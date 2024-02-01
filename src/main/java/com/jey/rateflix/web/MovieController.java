package com.jey.rateflix.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jey.rateflix.entity.Movie;
import com.jey.rateflix.entity.Review;
import com.jey.rateflix.service.MovieService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {

    MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@Valid @RequestBody Movie movie) {
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        return new ResponseEntity<>( movieService.removeMovie(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovie() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Movie> getMovieByTitle(@PathVariable String title) {
        return new ResponseEntity<>(movieService.getMovieByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        return new ResponseEntity<>(movieService.getMovieByGenre(genre), HttpStatus.OK);
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<List<Review>> getMovieReviews(@PathVariable Long id) {
        return new ResponseEntity<>(movieService.getMovieReviews(id), HttpStatus.OK);
    }
}
