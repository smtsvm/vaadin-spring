package gdg.eskisehir.service;

import gdg.eskisehir.model.Participant;
import gdg.eskisehir.repository.ParticipantRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Samet Sevim on 5.10.2016.
 */
@Service
public class ParticipantService implements InitializingBean{

    @Autowired
    ParticipantRepository participantRepository;

    public void addParticipant(String username, String firstname, String lastname, int age){
        Participant participant = new Participant();
        participant.setUsername(username);
        participant.setFirstname(firstname);
        participant.setLastname(lastname);
        participant.setAge(age);
        participantRepository.save(participant);
    }

    public void addParticipant(Participant participant){
        participantRepository.save(participant);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
//        addParticipant("samet.sevim","Samet","Sevim",28);
    }

    public List<Participant> getAll() {
        return (List<Participant>) participantRepository.findAll();
    }

    public void deleteParticipant(Participant participant) {
        participantRepository.delete(participant);
    }
}
