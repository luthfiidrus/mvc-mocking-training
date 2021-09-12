package ardi.springintro.model.swapi.model;

public class SwapiPlanet {
    String name;

    public SwapiPlanet() {
    }

    public SwapiPlanet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
