package gdg.eskisehir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Samet SEVİM on 4.11.2016.
 */
@Component
public class Registry {

    private static Registry instance;
    @PostConstruct
    private void init() {
        instance = this;
    }

    public static Registry get() {
        return instance;
    }

    //ParticipantService
    @Autowired
    private ParticipantService participantService;
    public static ParticipantService getParticipantService(){
        return instance.participantService;
    }
}
