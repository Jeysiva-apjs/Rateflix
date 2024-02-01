package com.jey.rateflix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.jey.rateflix.entity.Movie;
import com.jey.rateflix.entity.Review;
import com.jey.rateflix.exception.MovieNotFoundException;
import com.jey.rateflix.repository.MovieRepository;
import com.jey.rateflix.repository.ReviewRepository;
import com.jey.rateflix.service.MovieServiceImp;
import com.jey.rateflix.service.ReviewServiceImp;

@RunWith(MockitoJUnitRunner.class)
public class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private ReviewServiceImp reviewService;


    
}
