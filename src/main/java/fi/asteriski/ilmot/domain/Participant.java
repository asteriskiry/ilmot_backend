package fi.asteriski.ilmot.domain;

import fi.asteriski.ilmot.Gender;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@RequiredArgsConstructor
public class Participant {

    private static final String SEPARATOR = " ";

    @Getter
    @Setter
    @Id
    private String id;
    @Getter
    private String name;
    private String firstName;
    private String lastName;
    @Getter
    private String email;
    @NonNull
    @Getter
    private Gender gender;
    @NonNull
    @Getter
    private Map<String, Object> otherData;
    @NonNull
    private Map<Integer, Event> events; // FIXME use a simple id string (events id)


    public Participant(String firstName, String lastName, String email, Gender gender, Map<String, Object> otherData) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = firstName + SEPARATOR + lastName;
        this.email = email;
        this.gender = gender;
        this.otherData = otherData;
        this.events = new HashMap<>();
    }

    public void addEvent(Event event) {
        events.put(event.hashCode(), event);
    }

    public void removeEvent(Event event) {
        events.remove(event.hashCode());
    }
}
