package ardi.springintro.model;

public class Spaceship {
    String name;
    String model;

    public Spaceship() {
    }

    public Spaceship(String name, String model) {
        this.name = name;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
