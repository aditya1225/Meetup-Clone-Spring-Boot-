package com.aditya.meetup.service;

import com.aditya.meetup.dto.ClubDto;
import com.aditya.meetup.model.Club;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClubService {
    List<ClubDto> findAllClubs();

    Club saveClub(ClubDto clubDto);
    ClubDto findById(Integer Id);

    void updateClub(ClubDto club);

    void delete(Integer clubId);

    List<ClubDto> searchClubs(String query);
}
