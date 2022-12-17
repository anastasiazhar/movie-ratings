# movie-ratings
Queryable API. Get or add movie ratings.

- get info about a movie:
```
GET http://localhost:8080/{movieName}/{releaseYear}
```
- add your rating for a movie:
```
POST http://localhost:8080/{movieName}/{releaseYear}/{yourRating}
```
