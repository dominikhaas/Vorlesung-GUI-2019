import de.throsenheim.gui.architektur.exercise.customer.business.impl.CustomerServiceImpl;
import de.throsenheim.gui.architektur.exercise.customer.business.api.CustomerService;

module de.throsenheim.gui.architektur.exercise.customer.business {

    requires de.throsenheim.gui.architectur.dataaccess;

    exports de.throsenheim.gui.architektur.exercise.customer.business.api;

    provides CustomerService with CustomerServiceImpl;
}

