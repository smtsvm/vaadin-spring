package gdg.eskisehir.ui.component;

import com.vaadin.ui.*;
import gdg.eskisehir.service.ParticipantService;
import gdg.eskisehir.service.Registry;
import gdg.eskisehir.ui.event.VaadinEvent;
import gdg.eskisehir.ui.event.VaadinEventBus;

/**
 * Created by Samet SEVİM on 4.11.2016.
 */
public class ParticipantCreationLayout extends VerticalLayout{

    private ParticipantService participantService;
    public ParticipantCreationLayout(){
        participantService = Registry.getParticipantService();

        traditionalWork();
    }

    public void traditionalWork(){
        TextField usernameField = new TextField("Username");
        TextField firstnameField = new TextField("Firstname");
        TextField lastnameField = new TextField("Lastname");
        TextField ageField = new TextField("Age");


        FormLayout formLayout = new FormLayout(usernameField,firstnameField,lastnameField,ageField);

        Button saveParticipantButton = new Button("Save");
        saveParticipantButton.addClickListener(e->{
            participantService.addParticipant(usernameField.getValue(), firstnameField.getValue(), lastnameField.getValue(), Integer.parseInt(ageField.getValue()));
            Notification.show("Save Success :)");
            usernameField.setValue("");
            firstnameField.setValue("");
            lastnameField.setValue("");
            ageField.setValue("");
            VaadinEventBus.post(new VaadinEvent.RefreshParticipantTable());
        });

        addComponents(formLayout,saveParticipantButton);
        setMargin(true);
    }
}
