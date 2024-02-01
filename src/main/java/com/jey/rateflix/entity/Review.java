package com.jey.rateflix.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rating")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long id;

    @Column(name = "rating")
    @NotBlank(message = "Rating cannot be blank")
    private double rating;

    @Column(name = "review")
    @NotBlank(message = "Review cannot be blank")
    private String review;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Review(double rating, String review) {
        this.rating = rating;
        this.review = review;
    }
    
}
