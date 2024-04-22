package com.aditya.meetup.mapper;

import com.aditya.meetup.dto.EventDto;
import com.aditya.meetup.model.Event;

public class EventMapper {

    public static Event mapToEvent(EventDto eventDto) {
        return Event.builder()
                .Id(eventDto.getId())
                .name(eventDto.getName())
                .startTime(eventDto.getStartTime())
                .endTime(eventDto.getEndTime())
                .type(eventDto.getType())
                .createdOn(eventDto.getCreatedOn())
                .updatedOn(eventDto.getUpdatedOn())
                .photoUrl(eventDto.getPhotoUrl())
                .club(eventDto.getClub())
                .build();

    }

    public static EventDto mapToEventDto(Event event) {
        return EventDto.builder()
                .Id(event.getId())
                .name(event.getName())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .type(event.getType())
                .createdOn(event.getCreatedOn())
                .updatedOn(event.getUpdatedOn())
                .photoUrl(event.getPhotoUrl())
                .club(event.getClub())
                .build();

    }
}
