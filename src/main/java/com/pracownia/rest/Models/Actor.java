package com.pracownia.rest.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Actors")
public class Actor extends Person{

    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    private Set<Movie> movies = new HashSet();

//    @Column(name = "date_added")
//    private ZonedDateTime dateAdded;

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

//    public ZonedDateTime getDateAdded() {
//        return dateAdded;
//    }

//    public void setDateAdded(ZonedDateTime dateAdded) {
//        this.dateAdded = dateAdded;
//    }

    @Override
    public String toString() {
        return "Actor{" +
                "movies=" + movies +
                '}';
    }
}
