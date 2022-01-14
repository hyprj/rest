package com.pracownia.rest.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Studios")
public class Studio {
    @Id
    private String name;
    private String address;

    @OneToOne()
    @JoinColumn(name="ceo_id")
    private Ceo ceo;

    @OneToMany()
    @JoinColumn(name="studio_name")
    private List<Movie> movies = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Ceo getCeo() {
        return ceo;
    }

    public void setCeo(Ceo ceo) {
        this.ceo = ceo;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Studio{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", ceo=" + ceo +
                ", movies=" + movies +
                '}';
    }
}
