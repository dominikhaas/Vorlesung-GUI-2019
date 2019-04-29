package v4.mvp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class IntervalModel {
    private IntegerProperty value = new SimpleIntegerProperty();

    public int getValue() {
        return value.get();
    }

    public IntegerProperty valueProperty() {
        return value;
    }

    public void setValue(int value) {
        this.value.set(value);
    }

    public void increase() {
        this.setValue(this.getValue() + 1);
    }

    public void decrease() {
        this.setValue(this.getValue() - 1);
    }
}
