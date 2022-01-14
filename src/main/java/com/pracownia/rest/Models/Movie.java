package com.pracownia.rest.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Movies")
public class Movie {

    @Id
    private String title;
    private String genre;
    @Column(name="studio_name")
    private String studioName;

    @ManyToMany(cascade =  {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH})
    @JoinTable(name = "Appearances",
        joinColumns = @JoinColumn(name="movie_title"),
        inverseJoinColumns = @JoinColumn(name="actor_id")
    )
    private Set<Actor> actors = new HashSet();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }
}
