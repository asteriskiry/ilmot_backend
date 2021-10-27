package fi.asteriski.ilmot;

import fi.asteriski.ilmot.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/event/{id}")
    public Event getEvent(@PathVariable String id) {
        return eventService.getEvent(id);
    }

    @GetMapping("/event/all")
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @DeleteMapping("/event/{id}")
    void deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
    }

    @DeleteMapping("/event/{id}/archive")
    void archiveEvent(@PathVariable String id) {
        eventService.archiveEvent(id);
    }
}
