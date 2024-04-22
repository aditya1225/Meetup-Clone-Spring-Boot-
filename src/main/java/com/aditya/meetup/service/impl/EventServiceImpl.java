package com.aditya.meetup.service.impl;

import com.aditya.meetup.dto.EventDto;
import com.aditya.meetup.mapper.EventMapper;
import com.aditya.meetup.model.Club;
import com.aditya.meetup.model.Event;
import com.aditya.meetup.repository.ClubRepo;
import com.aditya.meetup.repository.EventRepo;
import com.aditya.meetup.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aditya.meetup.mapper.EventMapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.aditya.meetup.mapper.EventMapper.mapToEvent;
import static com.aditya.meetup.mapper.EventMapper.mapToEventDto;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private EventRepo eventRepo;
    private ClubRepo clubRepo;

    @Autowired
    public EventServiceImpl(EventRepo eventRepo, ClubRepo clubRepo) {
        this.eventRepo = eventRepo;
        this.clubRepo = clubRepo;
    }

    @Override
    public void createEvent(Integer clubId, EventDto eventDto) {
        Club club=clubRepo.findById(clubId).orElse(null);
        Event event= mapToEvent(eventDto);
        event.setClub(club);
        eventRepo.save(event);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events=eventRepo.findAll();
        return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public EventDto findByEventId(Integer eventId) {
        Event event=eventRepo.findById(eventId).get();
        return mapToEventDto(event);
        }

    @Override
    public void updateEvent(EventDto event) {
        Event event2=mapToEvent(event);
        eventRepo.save(event2);
    }

    @Override
    public void deleteEvent(Integer eventId) {
        eventRepo.deleteById(eventId);
    }


}
