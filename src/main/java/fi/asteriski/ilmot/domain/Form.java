package fi.asteriski.ilmot.domain;

import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.Map;

public class Form {

    @Id
    private String id;
    private final Instant dateCreated;
    private Map<String, Object> formData;
    private final String userCreated;

    public Form(Instant dateCreated, Map<String, Object> formData, String userCreated) {
        this.dateCreated = dateCreated;
        this.formData = formData;
        this.userCreated = userCreated;
    }

    public Map<String, Object> getFormData() {
        return formData;
    }

    public Instant getDateCreated() {
        return dateCreated;
    }

    public String getUserCreated() {
        return userCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
