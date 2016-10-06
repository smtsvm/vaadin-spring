package gdg.eskisehir.repository;

import gdg.eskisehir.model.Participant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Samet Sevim on 5.10.2016.
 */
public interface ParticipantRepository extends CrudRepository<Participant,Long> {

    Participant findByUsername(String username);


    // select * from Participant where firstname = :firstname
    List<Participant> findByFirstname(String firstname);

    List<Participant> findByFirstnameAndAge(String firstname, int age);
}
