package com.pracownia.rest.Repo;

import com.pracownia.rest.Models.Actor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorsRepository extends JpaRepository<Actor, Long> {
    @Query(nativeQuery = true, value = "select movie_title from Appearances where actor_id =?1")
    List<String> getActorsMovies(long id);

    @Query(nativeQuery = true, value = "select * from Actors")
    List<Actor> findAllActors(Pageable page);
}

//done