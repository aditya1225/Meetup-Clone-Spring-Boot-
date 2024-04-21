package com.aditya.meetup.service.impl;

import com.aditya.meetup.dto.ClubDto;
import com.aditya.meetup.model.Club;
import com.aditya.meetup.repository.ClubRepo;
import com.aditya.meetup.service.ClubService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.aditya.meetup.mapper.ClubMapper.mapToClubDto;

@Service
@NoArgsConstructor

public class ClubServiceImpl implements ClubService {
    private ClubRepo clubrepo;

    @Autowired
    public ClubServiceImpl(ClubRepo clubrepo) {
        this.clubrepo = clubrepo;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubrepo.findAll();
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }


    @Override
    public Club saveClub(ClubDto clubDto) {
        Club club=mapToClubDto(clubDto);
        return clubrepo.save(club);
    }

    @Override
    public ClubDto findById(Integer Id) {
        Club club = clubrepo.findById(Id).orElse(null);
        return mapToClubDto(club);
    }



    @Override
    public void updateClub(ClubDto club) {
        Club club2 = mapToClubDto(club);
        clubrepo.save(club2);

    }

    @Override
    public void delete(Integer clubId) {
        clubrepo.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs=clubrepo.searchClubs(query);
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }


}
