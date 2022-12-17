package com.example.reviews.model;

import jakarta.persistence.*;


@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int year;
    private double sumOfRatings = 0;
    private int numOfRatings = 0;
    private String averageRating;

    Movie() {}

    public Movie(String name, int year) {
        this.name = name.toLowerCase();
        this.year = year;
    }

    public Movie(String name, int year, double sumOfRatings, int numOfRatings) {
        this.name = name;
        this.year = year;
        this.sumOfRatings = sumOfRatings;
        this.numOfRatings = numOfRatings;
        averageRating = String.format("%.2f", sumOfRatings / numOfRatings);
    }

    public void addRating(double rating) {
        numOfRatings++;
        sumOfRatings += rating;
        averageRating = String.format("%.2f", sumOfRatings / numOfRatings);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public int getNumOfRatings() {
        return numOfRatings;
    }

    public void setNumOfRatings(int numOfRatings) {
        this.numOfRatings = numOfRatings;
    }

    public double getSumOfRatings() {
        return sumOfRatings;
    }

    public void setSumOfRatings(double sumOfRatings) {
        this.sumOfRatings = sumOfRatings;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", averageRating=" + averageRating +
                ", numOfRatings=" + numOfRatings +
                '}';
    }
}
