package de.throsenheim.gui.u08.business.protocol;

import de.throsenheim.gui.u08.business.protocol.api.ProtocolService;
import de.throsenheim.gui.u08.business.protocol.impl.ProtocolServiceImpl;

public class ProtocolServiceFactory {
    public static ProtocolService getService() {
        return new ProtocolServiceImpl();
    }
}
