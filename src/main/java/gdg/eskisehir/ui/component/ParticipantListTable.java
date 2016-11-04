package gdg.eskisehir.ui.component;

import com.google.common.eventbus.Subscribe;
import com.vaadin.ui.Table;
import gdg.eskisehir.model.Participant;
import gdg.eskisehir.service.ParticipantService;
import gdg.eskisehir.service.Registry;
import gdg.eskisehir.ui.event.VaadinEvent;
import gdg.eskisehir.ui.event.VaadinEventBus;

/**
 * Created by Samet SEVİM on 4.11.2016.
 */
public class ParticipantListTable extends Table{

    private ParticipantService participantService;

    public ParticipantListTable() {
        setWidth(100,Unit.PERCENTAGE);
        setPageLength(10);
        participantService = Registry.getParticipantService();
        VaadinEventBus.register(this);

        traditionalWork();
    }

    private void traditionalWork(){
        addContainerProperty("Firstname",String.class,null);
        addContainerProperty("Lastname",String.class,null);
        addContainerProperty("Age",Integer.class,null);

        fillTable();
    }

    private void fillTable(){
        removeAllItems();
        removeAllItems();
        for(Participant participant : participantService.getAll()){
            Object id = addItem();
            getContainerProperty(id,"Firstname").setValue(participant.getFirstname());
            getContainerProperty(id,"Lastname").setValue(participant.getLastname());
            getContainerProperty(id,"Age").setValue(participant.getAge());
        }
    }

    @Subscribe
    public void updateUserName(final VaadinEvent.RefreshParticipantTable event) {
        fillTable();
    }
}
