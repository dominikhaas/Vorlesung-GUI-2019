package de.throsenheim.gui.u08.unsorted;

import java.util.ArrayList;
import java.util.List;

public class DataSeriesServiceImpl implements DataSeriesService {
    private DataSeriesDao dao = new DataSeriesDao();

    @Override
    public DataSeriesDto loadDataSeries() {
        DataSeriesEt ets = dao.readDataSeries();

        List<PointDto> pointDtos = new ArrayList<>();
        for (PointEt et : ets.getPoints()) {
            pointDtos.add(new PointDto(et.getX(), et.getY()));
        }

        DataSeriesDto result = new DataSeriesDto(pointDtos);
        return result;
    }
}
