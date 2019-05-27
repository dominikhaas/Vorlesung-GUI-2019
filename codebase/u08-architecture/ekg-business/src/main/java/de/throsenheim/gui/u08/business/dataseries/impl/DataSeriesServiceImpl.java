package de.throsenheim.gui.u08.business.dataseries.impl;



import de.throsenheim.gui.u08.business.dataseries.api.DataSeriesDto;
import de.throsenheim.gui.u08.business.dataseries.api.DataSeriesService;
import de.throsenheim.gui.u08.business.dataseries.api.PointDto;
import de.throsenheim.gui.u08.business.protocol.ProtocolServiceFactory;
import de.throsenheim.gui.u08.business.protocol.api.ProtocolEntry;
import de.throsenheim.gui.u08.dataaccess.DataSeriesDao;
import de.throsenheim.gui.u08.dataaccess.DataSeriesEt;
import de.throsenheim.gui.u08.dataaccess.PointEt;


import java.util.ArrayList;
import java.util.List;

public class DataSeriesServiceImpl implements DataSeriesService {
    private DataSeriesDao dao = new DataSeriesDao();

    @Override
    public DataSeriesDto loadDataSeries() {
        ProtocolServiceFactory.getService().writeProtocol(new ProtocolEntry("loadDataSeries"));

        DataSeriesEt ets = dao.readDataSeries();

        List<PointDto> pointDtos = new ArrayList<>();
        for (PointEt et : ets.getPoints()) {
            pointDtos.add(new PointDto(et.getX(), et.getY()));
        }

        DataSeriesDto result = new DataSeriesDto(pointDtos);
        return result;
    }
}
