package com.eventzen.service;

import com.eventzen.model.Event;
import com.eventzen.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Method to get all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Method to get a single event by ID
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    // Method to create a new event
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    // Method to update an existing event
    public Event updateEvent(Long id, Event eventDetails) {
        if (eventRepository.existsById(id)) {
            eventDetails.setId(id);
            return eventRepository.save(eventDetails);
        }
        return null;
    }

    // Method to delete an event
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
