package com.jey.rateflix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.jey.rateflix.entity.Movie;
import com.jey.rateflix.repository.MovieRepository;
import com.jey.rateflix.service.MovieServiceImp;


@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest{

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImp movieService;

    @Test
    public void should_ReturnSuccessMessage_WhenMovieAdded() {
        Movie movie = new Movie("Movie 1", "Description 1", "Genre 1", 0.0);
        when(movieRepository.save(movie)).thenReturn(movie);
        assertEquals("Movie added successfully", movieService.addMovie(movie));
    }

    @Test
    public void should_ReturnSuccessMessage_WhenMovieRemoved() {
        Movie movie = new Movie("Movie 1", "Description 1", "Genre 1", 0.0);
        when(movieRepository.findById(1L)).thenReturn(java.util.Optional.of(movie));
        assertEquals("Movie deleted successfully", movieService.removeMovie(1L));
    }

    @Test
    public void should_ReturnMovies_WhenGetAllMovies() {
        Movie movie1 = new Movie("Movie 1", "Description 1", "Genre 1", 0.0);
        Movie movie2 = new Movie("Movie 2", "Description 2", "Genre 2", 0.0);
        List<Movie> movies = Arrays.asList(movie1, movie2);
        when(movieRepository.findAll()).thenReturn(movies);
        assertEquals(movies.size(), movieService.getAllMovies().size());
    }

    @Test
    public void should_ReturnMovie_WhenGetByTitle() {
        Movie movie1 = new Movie("Movie 1", "Description 1", "Genre 1", 0.0);
        Movie movie2 = new Movie("Movie 2", "Description 2", "Genre 2", 0.0);
        List<Movie> movies = Arrays.asList(movie1, movie2);
        when(movieService.getAllMovies()).thenReturn(movies);
        assertEquals("Movie 1", movieService.getMovieByTitle("Movie 1").getTitle());
    }

    @Test
    public void should_ReturnMovie_WhenGetByGenre(){
        Movie movie1 = new Movie("Movie 1", "Description 1", "Genre 1", 0.0);
        Movie movie2 = new Movie("Movie 2", "Description 2", "Genre 2", 0.0);
        List<Movie> movies = Arrays.asList(movie1, movie2);
        when(movieService.getAllMovies()).thenReturn(movies);
        assertEquals("Genre 1", movieService.getMovieByGenre("Genre 1").get(0).getGenre());
    }

}