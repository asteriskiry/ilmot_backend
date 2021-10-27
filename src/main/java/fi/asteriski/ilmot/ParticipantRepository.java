package fi.asteriski.ilmot;

import fi.asteriski.ilmot.domain.Participant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ParticipantRepository extends MongoRepository<Participant, String> {

    List<Participant> findAllByFirstName(String firstName);

    List<Participant> findAllByLastName(String lastName);

    List<Participant> findAllByName(String Name);

    List<Participant> findAllByGender(Gender gender);
}
