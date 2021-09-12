package ardi.springintro.model.swapi.model;

public class SwapiSpaceship {
    String name;
    String model;

    public SwapiSpaceship() {
    }

    public SwapiSpaceship(String name, String model) {
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
