package fi.asteriski.ilmot.domain;

import org.springframework.data.annotation.Id;

import java.time.Instant;

public class ArchivedEvent {

    @Id
    private String id;
    private final Event originalEvent;
    private final String owner;
    private final Participant[] participants; // FIXME ?
    private final Instant dateArchived;

    public ArchivedEvent(Event originalEvent, Participant[] participants, Instant dateArchived) {
        this.originalEvent = originalEvent;
        this.owner = originalEvent.getOwner();
        this.participants = participants;
        this.dateArchived = dateArchived;
    }

    public Event getOriginalEvent() {
        return originalEvent;
    }

    public String getOwner() {
        return owner;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public Instant getDateArchived() {
        return dateArchived;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
