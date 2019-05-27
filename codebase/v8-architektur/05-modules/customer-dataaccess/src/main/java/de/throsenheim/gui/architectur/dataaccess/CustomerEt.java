package de.throsenheim.gui.architectur.dataaccess;

public class CustomerEt {
    private String name;
    private String lastName;

    public CustomerEt(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
