package de.throsenheim.gui.u08.dataaccess;

import java.util.ArrayList;
import java.util.List;

public class DataSeriesDao {
    public DataSeriesEt readDataSeries() {
        return new DataSeriesEt(generateData());
    }

    private List<PointEt> generateData() {
        List<PointEt> result = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            result.add(new PointEt(i, Math.random() * i));
        }

        return result;
    }
}

