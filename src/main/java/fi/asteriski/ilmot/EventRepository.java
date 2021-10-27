package fi.asteriski.ilmot;

import fi.asteriski.ilmot.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {

    List<Event> findAllByOwner(String owner);

    List<Event> findAllByPlace(String place);
}
