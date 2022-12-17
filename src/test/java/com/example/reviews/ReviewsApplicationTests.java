package com.example.reviews;

import com.example.reviews.model.Movie;
import com.example.reviews.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ReviewsApplicationTests {

	@Autowired
	MovieRepository movieRepository;


	@Test
	public void executingPostRequest() {
		String name = "c";
		int year = 2000;
		int rating = 6;
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<>("");
		ResponseEntity<String> response = restTemplate
				.exchange("http://localhost:8080/" + name + "/" + year + "/" + rating,
					HttpMethod.POST, request, String.class);

		assertEquals("your rating was submitted successfully", response.getBody());
	}

	@Test
	public void executingGetRequest() {
		String name = "c";
		int year = 2000;
		Movie movie = new Movie("c", 2000);
		movieRepository.save(movie);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Movie> response = restTemplate
				.getForEntity("http://localhost:8080/" + name + "/" + year,
						Movie.class);
		assertEquals(movieRepository.findByNameAndYear(name, year).toString(), response.getBody().toString());
	}
}
