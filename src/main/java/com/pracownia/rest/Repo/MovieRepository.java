package com.pracownia.rest.Repo;

import com.pracownia.rest.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, String> {
    @Query(nativeQuery = true, value = "Select * FROM Movies where studio_name = ?1" )
    List<Movie> getMoviesByStudio(String nazwaStudia);
}
