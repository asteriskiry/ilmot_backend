package fi.asteriski.ilmot;

import fi.asteriski.ilmot.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ArchivedEventRepository archivedEventRepository;

    Event getEvent(String id) {
        return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
    }

    List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }

    public void archiveEvent(String id) {
        Event event = eventRepository.findById(id).orElse(null);
        archivedEventRepository.save(Event.archiveEvent(event));
        eventRepository.deleteById(id);
    }
}
