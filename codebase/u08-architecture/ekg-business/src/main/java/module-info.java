import de.throsenheim.gui.u08.business.dataseries.api.DataSeriesService;
import de.throsenheim.gui.u08.business.dataseries.impl.DataSeriesServiceImpl;

module de.throsenheim.gui.architecture.business {
    requires de.throsenheim.gui.architecture.dataaccess;
    exports de.throsenheim.gui.u08.business.dataseries.api;

    provides DataSeriesService with DataSeriesServiceImpl;
}