package fi.asteriski.ilmot;

public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException(String id) {
        super(String.format("Event with id '%s' not found.", id));
    }
}
