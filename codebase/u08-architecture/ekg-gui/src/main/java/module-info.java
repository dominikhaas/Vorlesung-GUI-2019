import de.throsenheim.gui.u08.business.dataseries.api.DataSeriesService;

module de.throsenheim.gui.architecture.gui {
    requires de.throsenheim.gui.architecture.business;
    requires  javafx.controls;
    requires  javafx.fxml;
    requires java.logging;

    opens de.throsenheim.gui.u08.chart;
    opens de.throsenheim.gui.u08.header;
    opens de.throsenheim.gui.u08.status;
    opens de.throsenheim.gui.u08;

    uses DataSeriesService;
}