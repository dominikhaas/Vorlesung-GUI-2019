package de.fhrosenheim.gui.u07.eventbus;


/**
 * The callback interface.
 */
public interface IEventBusListener<T> {

    /**
     * Method will be called by the bus if the event type is subscribed by this
     * listener.
     *
     * @param event the event.
     */
    void onEvent(T event);
}
