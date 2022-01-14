package com.pracownia.rest.Repo;

import com.pracownia.rest.Models.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudioRepository extends JpaRepository<Studio, String> {
    @Query(nativeQuery =true, value = "Select * from Studios WHERE address = ?1" )
    List<Studio> getStudioByAdress(String address);
}
