package com.aditya.meetup.mapper;

import com.aditya.meetup.dto.ClubDto;
import com.aditya.meetup.model.Club;

import java.util.stream.Collectors;

import static com.aditya.meetup.mapper.EventMapper.mapToEventDto;

public class ClubMapper {
    public static Club mapToClubDto(ClubDto club) {
        Club club1 = new Club();
        club1.setId(club.getId());
        club1.setTitle(club.getTitle());
        club1.setPhotoUrl(club.getPhotoUrl());
        club1.setContent(club.getContent());
        club1.setCreatedOn(club.getCreatedOn());
        club1.setUpdatedOn(club.getUpdatedOn());
        return club1;
    }

    public static ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = new ClubDto();
        clubDto.setId(club.getId());
        clubDto.setTitle(club.getTitle());
        clubDto.setPhotoUrl(club.getPhotoUrl());
        clubDto.setContent(club.getContent());
        clubDto.setEvents(club.getEvents().stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList()));
        clubDto.setCreatedOn(club.getCreatedOn());
        clubDto.setUpdatedOn(club.getUpdatedOn());
        return clubDto;
    }
}
