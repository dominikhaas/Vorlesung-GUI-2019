package de.throsenheim.gui.u08.business.dataseries.api;

import java.util.List;

public class DataSeriesDto {
    private List<PointDto> points;

    public DataSeriesDto(List<PointDto> points) {
        this.points = points;
    }

    public List<PointDto> getPoints() {
        return points;
    }
}
