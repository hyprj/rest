package com.pracownia.rest.Controller;

import com.pracownia.rest.Models.Movie;
import com.pracownia.rest.Services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovie(){
        return ResponseEntity.ok(movieService.getMovies());
    }

    @GetMapping("/movies/{title}")
    public ResponseEntity <Optional<Movie>>GetSingleMovie (@PathVariable String title){
        Optional<Movie> movieFromDb = movieService.getSingleMovie(title);
        if (movieFromDb.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(movieFromDb);
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie movieFromDb = movieService.addMovie(movie);
        if (movieFromDb == null){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        else{
            return ResponseEntity.ok(movieFromDb);
        }
    }

    @PutMapping("/movies")
    public ResponseEntity <Movie> editMovie(@RequestBody Movie movie){
        Movie movieFromDb = movieService.editMovie(movie);
        if (movieFromDb == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(movieFromDb);
    }

    @DeleteMapping("/movies/{title}")
    public ResponseEntity<Optional<Movie>> deleteMovie(@PathVariable String title){
        try{

            movieService.deleteMovie(title);
        }
        catch(Exception e){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().build();
    }


    @GetMapping("/movies/studio/{studioName}")
    public ResponseEntity<List<Movie>> getMoviesByStudio(@PathVariable String studioName){
        return ResponseEntity.ok(movieService.getMoviesByStudio(studioName));
    }
}
