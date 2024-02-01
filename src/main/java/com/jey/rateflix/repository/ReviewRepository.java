package com.jey.rateflix.repository;

import org.springframework.data.repository.CrudRepository;

import com.jey.rateflix.entity.Review;

public interface ReviewRepository extends CrudRepository<Review, Long>{
    
}
