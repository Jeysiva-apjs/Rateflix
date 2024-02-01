# RateFlix Movie API Documentation

This document outlines the endpoints and usage of the RateFlix Movie API.

## Base URL

The base URL for all endpoints is: `/movie`

## Endpoints

### Add Movie

Add a new movie to the database.

- **URL:** `/add`
- **Method:** `POST`
- **Request Body:** JSON Object representing the Movie entity.
  - Required Fields:
    - `title` (String): Title of the movie.
    - `genre` (String): Genre of the movie.
- **Success Response:**
  - **Code:** `201 CREATED`
  - **Content:** Message indicating successful addition of the movie.
- **Error Response:**
  - **Code:** `400 BAD REQUEST`
  - **Content:** Error message if the request body is invalid.

### Delete Movie

Delete a movie from the database by its ID.

- **URL:** `/delete/{id}`
- **Method:** `DELETE`
- **Path Parameters:**
  - `id` (Long): ID of the movie to be deleted.
- **Success Response:**
  - **Code:** `200 OK`
  - **Content:** Message indicating successful deletion of the movie.
- **Error Response:**
  - **Code:** `404 NOT FOUND`
  - **Content:** Error message if the movie with the specified ID is not found.

### Get All Movies

Retrieve a list of all movies from the database.

- **URL:** `/all`
- **Method:** `GET`
- **Success Response:**
  - **Code:** `200 OK`
  - **Content:** List of Movie entities.
- **Error Response:**
  - **Code:** `404 NOT FOUND`
  - **Content:** Error message if no movies are found in the database.

### Get Movie by Title

Retrieve a movie from the database by its title.

- **URL:** `/title/{title}`
- **Method:** `GET`
- **Path Parameters:**
  - `title` (String): Title of the movie to retrieve.
- **Success Response:**
  - **Code:** `200 OK`
  - **Content:** Movie entity with the specified title.
- **Error Response:**
  - **Code:** `404 NOT FOUND`
  - **Content:** Error message if the movie with the specified title is not found.

### Get Movies by Genre

Retrieve a list of movies from the database by their genre.

- **URL:** `/genre/{genre}`
- **Method:** `GET`
- **Path Parameters:**
  - `genre` (String): Genre of the movies to retrieve.
- **Success Response:**
  - **Code:** `200 OK`
  - **Content:** List of Movie entities with the specified genre.
- **Error Response:**
  - **Code:** `404 NOT FOUND`
  - **Content:** Error message if no movies with the specified genre are found.

### Get Movie Reviews

Retrieve reviews for a movie from the database by its ID.

- **URL:** `/reviews/{id}`
- **Method:** `GET`
- **Path Parameters:**
  - `id` (Long): ID of the movie to retrieve reviews for.
- **Success Response:**
  - **Code:** `200 OK`
  - **Content:** List of Review entities for the specified movie.
- **Error Response:**
  - **Code:** `404 NOT FOUND`
  - **Content:** Error message if the movie with the specified ID is not found.


### Add Review
- **URL:** `/review/movie/{movieId}`
- **Method:** `POST`
- **Description:** Adds a review for a specific movie.
- **Parameters:**
  - `movieId` (path): The ID of the movie for which the review is being added.
  - Request Body: JSON object representing the review.
    - `id` (optional): Unique identifier for the review.
    - `rating` (required): Rating of the movie (integer).
    - `comment` (optional): Textual comment or review.
- **Response:**
  - `201 Created`: Review added successfully.
  - `404 Not Found`: If the specified movie ID is not found.

### Get All Reviews
- **URL:** `/review/all`
- **Method:** `GET`
- **Description:** Retrieves all reviews for all movies.
- **Response:**
  - `200 OK`: Returns a list of review objects.
  - `404 Not Found`: If no reviews are found.

### Delete Review
- **URL:** `/review/delete/{id}`
- **Method:** `DELETE`
- **Description:** Deletes a review by its ID.
- **Parameters:**
  - `id` (path): The ID of the review to be deleted.
- **Response:**
  - `200 OK`: Review deleted successfully.
  - `404 Not Found`: If the specified review ID is not found.

