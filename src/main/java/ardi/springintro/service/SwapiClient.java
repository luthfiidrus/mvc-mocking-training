package ardi.springintro.service;

import ardi.springintro.model.swapi.model.*;

import java.util.List;

public interface SwapiClient {
  List<SwapiFilm> getFilms();
  SwapiFilm getSpecificFilms(int index);

  List<SwapiPeople> getPeople();
  SwapiPeople getSpecificPeople(int index);

  List<SwapiPlanet> getPlanets();
  SwapiPlanet getSpecificPlanet(int index);

  List<SwapiSpaceship> getSpaceships();
  SwapiSpaceship getSpecificSpaceship(int index);

  List<SwapiSpecies> getSpecies();
  SwapiSpecies getSpecificSpecies(int index);

  List<SwapiVehicle> getVehicles();
  SwapiVehicle getSpecificVehicle(int index);
}
