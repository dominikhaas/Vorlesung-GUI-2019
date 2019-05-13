package de.fhrosenheim.gui.u06.eventbus;


/**
 * The callback interface.
 */
public interface IEventBusListener<T extends Event> {

    /**
     * Method will be called by the bus if the event type is subscribed by this
     * listener.
     *
     * @param event the event.
     */
    void onEvent(T event);
}
