package fi.asteriski.ilmot;

import fi.asteriski.ilmot.domain.ArchivedEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ArchivedEventRepository extends MongoRepository<ArchivedEvent, String> {

    List<ArchivedEvent> findAllByOwner(String owner);
}
