package de.throsenheim.gui.u08.dataaccess;

import java.util.Collections;
import java.util.List;

public class DataSeriesEt {

    private List<PointEt> points;

    public DataSeriesEt(List<PointEt> points ) {
        this.points = Collections.unmodifiableList(points);
    }

    public List<PointEt> getPoints() {
        return points;
    }
}
