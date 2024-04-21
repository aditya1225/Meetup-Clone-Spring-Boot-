package com.aditya.meetup.repository;

import com.aditya.meetup.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClubRepo extends JpaRepository<Club, Integer> {

    Optional<Club> findByTitle(String url);
    @Query("SELECT c FROM Club c WHERE c.title LIKE CONCAT('%',:query,'%')")
    List<Club> searchClubs(@Param("query") String Query);

}
