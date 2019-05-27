package de.throsenheim.gui.u08.business.protocol.api;

public class ProtocolEntry {
    private long timestamp;
    private String action;

    public ProtocolEntry(String action) {
        this.timestamp = System.currentTimeMillis();
        this.action = action;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getAction() {
        return action;
    }
}
