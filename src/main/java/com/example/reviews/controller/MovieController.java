package com.example.reviews.controller;

import com.example.reviews.model.Movie;
import com.example.reviews.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/{name}/{year}")
    @ResponseBody
    public Movie getMovieInfo(@PathVariable String name, @PathVariable int year) {
        return movieRepository.findByNameAndYear(name, year);
    }

    @PostMapping("/{name}/{year}/{rating}")
    @ResponseBody
    public String submitMovieRating(@PathVariable String name, @PathVariable int year, @PathVariable int rating) {
        if (year < 1900 || year >= LocalDate.now().getYear()) {
            return "the year is incorrect";
        }
        if (rating < 0 || rating > 10) {
            return "the ratings can only go from 1 to 10";
        }

        if (movieRepository.findByNameAndYear(name, year) != null) {
            Movie movie = movieRepository.findByNameAndYear(name, year);
            movie.addRating(rating);
            movieRepository.save(movie);
        } else {
            Movie movie = new Movie(name, year);
            movie.addRating(rating);
            movieRepository.save(movie);
        }
        return "your rating was submitted successfully";
    }
}
