package de.fhrosenheim.gui.u06.eventbus;

import java.util.*;

/**
 * Sehr einfache Implementierung eines Event Bus.
 * 
 * @author dominik.haas
 */
public class SimpleEventBus implements EventBus {
    
    private static final SimpleEventBus INSTANCE = new SimpleEventBus();
    
    private final Map<Class, Set<IEventBusListener>> subscriptionsOrclassToListeners = new HashMap<>();

    private SimpleEventBus() {
        //singleton
    }

    public static SimpleEventBus getBus() {
        return INSTANCE;
    }

    @Override
    public void publish(Event event) {
        Class eventType = event.getClass();
        Set<IEventBusListener> listeners = subscriptionsOrclassToListeners.get(eventType);
        if(listeners != null) {
            for (IEventBusListener listener : listeners) {
                listener.onEvent(event);
            }
        }
    }

    @Override
    public <T extends Event> void subscribe(Class<T> type, IEventBusListener<T> listener) {
        if(!subscriptionsOrclassToListeners.containsKey(type)) {
            subscriptionsOrclassToListeners.put(type, new HashSet<>());
        }
        subscriptionsOrclassToListeners.get(type).add(listener);
    }
}
