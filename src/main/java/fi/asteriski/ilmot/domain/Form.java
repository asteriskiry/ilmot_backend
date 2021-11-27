package fi.asteriski.ilmot.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class Form {

    @Id
    @Setter
    private String id;
    @NonNull
    private final Instant dateCreated;
    @NonNull
    private Map<String, Object> formData;
    @NonNull
    private final String userCreated;

}
