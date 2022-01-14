package com.pracownia.rest.Repo;

import com.pracownia.rest.Models.Ceo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CeoRepository extends JpaRepository<Ceo, Long> {
    @Query(nativeQuery = true, value = "select * from Ceos where salary = (select MAX(salary) from Ceos)")
    Ceo getCeoWithTheHighestSalary();
}
