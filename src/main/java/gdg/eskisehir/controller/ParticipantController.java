package gdg.eskisehir.controller;

import gdg.eskisehir.model.Participant;
import gdg.eskisehir.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Samet Sevim on 6.10.2016.
 */
@RestController
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;
    @RequestMapping(path = "participant", method = RequestMethod.GET)
    public List<Participant> getAllParticipants(){
        return participantService.getAll();
    }
}
