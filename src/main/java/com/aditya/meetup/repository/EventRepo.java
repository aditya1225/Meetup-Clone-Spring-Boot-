package com.aditya.meetup.repository;

import com.aditya.meetup.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event,Integer> {
}
