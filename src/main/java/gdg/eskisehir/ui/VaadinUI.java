package gdg.eskisehir.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import gdg.eskisehir.service.ParticipantService;
import gdg.eskisehir.ui.event.VaadinEventBus;
import gdg.eskisehir.ui.view.MainView;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Samet Sevim on 5.10.2016.
 */
@SpringUI
public class VaadinUI extends UI{


    private final VaadinEventBus eventBus = new VaadinEventBus();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        eventBus.register(this);
        setContent(new MainView());
    }

    public static VaadinEventBus getEventBus() {
        return ((VaadinUI)getCurrent()).eventBus;
    }
}
