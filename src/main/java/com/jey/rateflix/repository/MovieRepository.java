package com.jey.rateflix.repository;

import org.springframework.data.repository.CrudRepository;

import com.jey.rateflix.entity.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long>{

    
} 