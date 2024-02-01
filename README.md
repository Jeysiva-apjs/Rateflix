# Rateflix

Rateflix is a movie rating application designed for users to review and rate movies.

## Built With 
1. Java
2. Spring Boot
3. Junit
4. Mockito

## Functionality

- Allows users to **add a new movie** to the database.
- Enables users to **remove an existing movie** from the database.
- Lets users **find a movie by its title**.
- Allows users to di**scover movies based on their genre**.
- Enables users to **rate and leave reviews for movies**.


## API Documentation

### Add Movie

**URL:** `/movie/add`
**Description:** Add a new movie to the database.
**Input:** JSON Object representing the Movie entity with `title`, `description`, and `genre` fields.
**Output:** 
- `201 CREATED` if successful with a message.
- `400 BAD REQUEST` if the request body is invalid.

### Delete Movie

**URL:** `/movie/delete/{id}`
**Description:** Delete a movie from the database by its ID.
**Input:** Long `id` as path parameter.
**Output:** 
- `200 OK` if successful with a message.
- `404 NOT FOUND` if the movie with the specified ID is not found.

### Get All Movies

**URL:** `/movie/all`
**Description:** Retrieve a list of all movies from the database.
**Input:** None.
**Output:** 
- `200 OK` with a list of Movie entities.
- `404 NOT FOUND` if no movies are found in the database.

### Get Movie by Title

**URL:** `/movie/title/{title}`
**Description:** Retrieve a movie from the database by its title.
**Input:** String `title` as path parameter.
**Output:** 
- `200 OK` with the Movie entity having the specified title.
- `404 NOT FOUND` if the movie with the specified title is not found.

### Get Movies by Genre

**URL:** `/movie/genre/{genre}`
**Description:** Retrieve a list of movies from the database by their genre.
**Input:** String `genre` as path parameter.
**Output:** 
- `200 OK` with a list of Movie entities having the specified genre.
- `404 NOT FOUND` if no movies with the specified genre are found.

### Get Movie Reviews

**URL:** `/movie/reviews/{id}`
**Description:** Retrieve reviews for a movie from the database by its ID.
**Input:** Long `id` as path parameter.
**Output:** 
- `200 OK` with a list of Review entities for the specified movie.
- `404 NOT FOUND` if the movie with the specified ID is not found.

### Add Review

**URL:** `/review/movie/{movieId}`
**Description:** Adds a review for a specific movie.
**Input:** 
- Long `movieId` as path parameter.
- JSON object representing the review with `rating` and `review` fields.
**Output:** 
- `201 Created` if successful.
- `404 Not Found` if the specified movie ID is not found.

### Get All Reviews

**URL:** `/review/all`
**Description:** Retrieves all reviews for all movies.
**Input:** None.
**Output:** 
- `200 OK` with a list of review objects.
- `404 Not Found` if no reviews are found.

### Delete Review

**URL:** `/review/delete/{id}`
**Description:** Deletes a review by its ID.
**Input:** Long `id` as path parameter.
**Output:** 
- `200 OK` if successful.
- `404 Not Found` if the specified review ID is not found.

