package fi.asteriski.ilmot.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Getter
public class ArchivedEvent {

    @Setter
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
}
