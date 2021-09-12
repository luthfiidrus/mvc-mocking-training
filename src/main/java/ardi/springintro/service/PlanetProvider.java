package ardi.springintro.service;

import ardi.springintro.model.Planet;

import java.util.List;

public interface PlanetProvider {
    List<Planet> getPlanets();

    Planet getPlanet(int index);
}
