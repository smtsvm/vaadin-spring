package gdg.eskisehir.ui.component;

import com.vaadin.ui.*;
import gdg.eskisehir.model.Participant;
import gdg.eskisehir.service.ParticipantService;
import gdg.eskisehir.service.Registry;
import gdg.eskisehir.ui.event.VaadinEvent;
import gdg.eskisehir.ui.event.VaadinEventBus;
import org.vaadin.crudui.impl.crud.GridBasedCrudComponent;

import java.util.Collection;

/**
 * Created by Samet SEVİM on 4.11.2016.
 */
public class ParticipantCreationLayout extends VerticalLayout{

    private ParticipantService participantService;
    public ParticipantCreationLayout(){
        participantService = Registry.getParticipantService();

        crudUIWork();
    }

    private void crudUIWork(){
        GridBasedCrudComponent<Participant> crud = new GridBasedCrudComponent<>(Participant.class, new GridBasedCrudComponent.GridCrudListener<Participant>() {
            @Override
            public Collection<Participant> refreshTable() {
                return participantService.getAll();
            }

            @Override
            public void add(Participant domainObjectToAdd) {
                participantService.addParticipant(domainObjectToAdd);
            }

            @Override
            public void update(Participant domainObjectToUpdate) {
                participantService.addParticipant(domainObjectToUpdate);
            }

            @Override
            public void delete(Participant domainObjectToDelete) {
                participantService.deleteParticipant(domainObjectToDelete);
            }
        });

        crud.showAllOptions(); // shows: refresh table, add, edit, and delete options.

        addComponent(crud); // add the crud into a layout
    }

}
