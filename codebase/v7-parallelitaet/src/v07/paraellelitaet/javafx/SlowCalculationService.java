package v07.paraellelitaet.javafx;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class SlowCalculationService extends Service<String> {
    @Override
    protected Task<String> createTask() {
        return new SlowCalculationTask();
    }
}
