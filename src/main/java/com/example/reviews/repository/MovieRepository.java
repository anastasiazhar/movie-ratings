package com.example.reviews.repository;

import com.example.reviews.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findByNameAndYear(String name, int year);
}
