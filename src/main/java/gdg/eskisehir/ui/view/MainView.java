package gdg.eskisehir.ui.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;
import gdg.eskisehir.ui.component.ParticipantCreationLayout;
import gdg.eskisehir.ui.component.ParticipantListTable;

/**
 * Created by Samet SEVİM on 4.11.2016.
 */
public class MainView extends VerticalLayout {

    public ParticipantCreationLayout participantCreationLayout;
    public ParticipantListTable participantListTable;
    public MainView() {

        participantCreationLayout = new ParticipantCreationLayout();
        participantListTable = new ParticipantListTable();
        setMargin(true);
        addComponents(participantCreationLayout,participantListTable);
        setComponentAlignment(participantCreationLayout, Alignment.TOP_CENTER);
    }
}
