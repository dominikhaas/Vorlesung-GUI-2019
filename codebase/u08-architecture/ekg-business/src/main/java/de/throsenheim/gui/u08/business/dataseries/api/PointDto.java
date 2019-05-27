package de.throsenheim.gui.u08.business.dataseries.api;

public class PointDto {
    private Number x;
    private Number y;

    public PointDto(Number x, Number y) {
        this.x = x;
        this.y = y;
    }

    public Number getX() {
        return x;
    }

    public Number getY() {
        return y;
    }
}
