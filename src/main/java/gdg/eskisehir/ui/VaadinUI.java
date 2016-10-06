package gdg.eskisehir.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import gdg.eskisehir.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Samet Sevim on 5.10.2016.
 */
@SpringUI(path = "gdg")
public class VaadinUI extends UI{

    @Autowired
    private ParticipantService participantService;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new Label("It works"));

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
        });

        VerticalLayout contentLayout = new VerticalLayout(formLayout,saveParticipantButton);
        contentLayout.setMargin(true);
        setContent(contentLayout);
    }
}
