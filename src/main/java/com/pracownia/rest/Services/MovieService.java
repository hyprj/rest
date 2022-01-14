package com.pracownia.rest.Services;

import com.pracownia.rest.Models.Movie;
import com.pracownia.rest.Repo.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies;

    }


    public Movie addMovie(Movie movie){
        Optional<Movie> movieFromDb = movieRepository.findById(movie.getTitle());
        if (movieFromDb.isPresent()){
            return null;
        }
        else{
            Movie newMovie = movieRepository.save(movie);
            return newMovie;
        }
    }

    public Optional<Movie> getSingleMovie(String title){
        return movieRepository.findById(title);
    }

    public Movie editMovie(Movie movie){
        Optional<Movie> movieFromDb = movieRepository.findById(movie.getTitle());
        if (movieFromDb.isEmpty()){
            return null;
        }
        else {
            Movie movieEdited = movieRepository.findById(movie.getTitle()).orElseThrow();
            movieEdited.setGenre(movie.getGenre());
            movieRepository.save(movieEdited);
            return movieEdited;
        }
    }

    public void deleteMovie(String title){
        Movie movieFromDb = movieRepository.findById(title).orElseThrow();
        movieRepository.deleteById(title);
    }

    public List<Movie> getMoviesByStudio (String name){
        return movieRepository.getMoviesByStudio(name);
    }

}
