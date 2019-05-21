package v07.paraellelitaet.javafx;

import javafx.concurrent.Task;

public class SlowCalculationTask extends Task<String> {



    @Override
    protected String call() throws Exception {

        System.out.println("Thread in call: " + Thread.currentThread().getName());
        for(int i = 0; i < 10; i++) {
            if(isCancelled()) {
                break;
            }

            Thread.sleep(300);
            updateMessage("Step " + (i + 1) + "/10");
            updateProgress(i, 10);
        }

        return "5";
    }
}
