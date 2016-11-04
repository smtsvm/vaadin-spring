package gdg.eskisehir.ui.event;

/**
 * Created by Samet SEVİM on 4.11.2016.
 */
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import gdg.eskisehir.ui.VaadinUI;


/**
 * A simple wrapper for Guava event bus. Defines static convenience methods for
 * relevant actions.
 */
public class VaadinEventBus implements SubscriberExceptionHandler {

    private final EventBus eventBus = new EventBus(this);

    public static void post(final Object event) {
        VaadinUI.getEventBus().eventBus.post(event);
    }

    public static void register(final Object object) {
        VaadinUI.getEventBus().eventBus.register(object);
    }

    public static void unregister(final Object object) {
        VaadinUI.getEventBus().eventBus.unregister(object);
    }

    @Override
    public final void handleException(final Throwable exception,
                                      final SubscriberExceptionContext context) {
    }
}