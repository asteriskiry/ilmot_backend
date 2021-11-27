package fi.asteriski.ilmot.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.lang.Nullable;

import java.time.Instant;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Event {

    private static final String ROOT_PATH_TO_IMG_FILES = ""; // FIXME tee konffilla

    @Id
    private String id;
    @NonNull
    private String owner;
    @NonNull
    private String name;
    @NonNull
    private Instant startDate;
    @NonNull
    private String place;
    @NonNull
    private String description;
    @Nullable
    private String bannerImg;
    @Nullable
    private Map<String, Object> otherData;
    private Form form;


    private Event(Event event) {
        this.owner = event.owner;
        this.name = event.name;
        this.startDate = event.startDate;
        this.place = event.place;
        this.description = event.description;
        this.bannerImg = event.bannerImg;
        this.otherData = event.otherData;
    }

    public Event(String owner, String name, Instant startDate, String place, String description, Form form) {
        this.owner = owner;
        this.name = name;
        this.startDate = startDate;
        this.place = place;
        this.description = description;
        this.form = form;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(500);
        String separator = ", ";
        stringBuilder.append("[");
        stringBuilder.append("Owner: ").append(owner).append(separator);
        stringBuilder.append("Name: ").append(name).append(separator);
        stringBuilder.append("Place: ").append(place).append(separator);
        stringBuilder.append("StartDate: ").append(startDate).append(separator);
        stringBuilder.append("Description: ").append(description).append("]");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event other = (Event) obj;
        return Objects.equals(owner, other.owner) && Objects.equals(name, other.name) && Objects.equals(startDate, other.startDate) && Objects.equals(description, other.description);
/*
 private String owner;
    private String name;
    private Instant startDate;
    private String place;
    private String description;
 */
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, name, startDate, place, description);
    }

    public static ArchivedEvent archiveEvent(Event eventToArchive) {
        Event event = new Event(eventToArchive);
        return new ArchivedEvent(event, new Participant[0], Instant.now()); // FIXME
    }
}
