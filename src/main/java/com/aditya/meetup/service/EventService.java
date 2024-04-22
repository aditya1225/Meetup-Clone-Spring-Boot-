package com.aditya.meetup.service;

import com.aditya.meetup.dto.EventDto;

import java.util.List;

public interface EventService {
    void createEvent(Integer clubId, EventDto eventDto);
    List<EventDto> findAllEvents();

    EventDto findByEventId(Integer eventId);

    void updateEvent(EventDto event);

    void deleteEvent(Integer eventId);
}
