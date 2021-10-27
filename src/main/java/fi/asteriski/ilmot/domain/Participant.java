package fi.asteriski.ilmot.domain;

import com.mongodb.lang.Nullable;
import fi.asteriski.ilmot.Gender;
import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.Map;

public class Participant {

    private static final String SEPARATOR = " ";
    @Id
    private String id;
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    @Nullable
    private Gender gender;
    @Nullable
    private Map<String, Object> otherData;
    @Nullable
    private Map<Integer, Event> events;

    public Participant() {
    }

    public Participant(String firstName, String lastName, String email, Gender gender, Map<String, Object> otherData) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = firstName + SEPARATOR + lastName;
        this.email = email;
        this.gender = gender;
        this.otherData = otherData;
        this.events = new HashMap<>();
    }

    public Map<String, Object> getOtherData() {
        return otherData;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addEvent(Event event) {
        events.put(event.hashCode(), event);
    }

    public void removeEvent(Event event) {
        events.remove(event.hashCode());
    }
}
