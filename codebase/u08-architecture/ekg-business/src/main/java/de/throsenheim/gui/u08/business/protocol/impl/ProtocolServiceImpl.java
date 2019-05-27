package de.throsenheim.gui.u08.business.protocol.impl;

import de.throsenheim.gui.u08.business.protocol.api.ProtocolEntry;
import de.throsenheim.gui.u08.business.protocol.api.ProtocolService;


public class ProtocolServiceImpl implements ProtocolService {

    @Override
    public void writeProtocol(ProtocolEntry entry) {
        System.out.println("Protocol: " + entry.getAction() + "@" + entry.getTimestamp());
    }
}
