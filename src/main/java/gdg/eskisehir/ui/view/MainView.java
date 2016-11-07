package gdg.eskisehir.ui.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;
import gdg.eskisehir.ui.component.ParticipantCreationLayout;

/**
 * Created by Samet SEVİM on 4.11.2016.
 */
public class MainView extends VerticalLayout {

    public ParticipantCreationLayout participantCreationLayout;
    public MainView() {

        participantCreationLayout = new ParticipantCreationLayout();
        setMargin(true);
        addComponents(participantCreationLayout);
        setComponentAlignment(participantCreationLayout, Alignment.TOP_CENTER);
    }
}
