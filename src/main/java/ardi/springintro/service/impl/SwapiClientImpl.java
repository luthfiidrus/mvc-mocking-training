package ardi.springintro.service.impl;

import ardi.springintro.model.swapi.model.*;
import ardi.springintro.model.swapi.SwapiResponse;
import ardi.springintro.service.SwapiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class SwapiClientImpl implements SwapiClient {

  @Autowired
  @Qualifier("swapiWebClient")
  private WebClient swapiWebClient;

  @Override
  public List<SwapiFilm> getFilms() {
    SwapiResponse<SwapiFilm> response = swapiWebClient.get()
        .uri("/films")
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<SwapiResponse<SwapiFilm>>() {})
        .block();
    return response.getResults();
  }

  @Override
  public SwapiFilm getSpecificFilms(int index) {
    return swapiWebClient.get()
            .uri("/films/" + index)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiFilm>() {})
            .block();
  }

  @Override
  public List<SwapiPeople> getPeople() {
    SwapiResponse<SwapiPeople> response = swapiWebClient.get()
            .uri("/people")
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiResponse<SwapiPeople>>() {})
            .block();
    return response.getResults();
  }

  @Override
  public SwapiPeople getSpecificPeople(int index) {
    return swapiWebClient.get()
            .uri("/people/" + index)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiPeople>() {})
            .block();
  }

  @Override
  public List<SwapiPlanet> getPlanets() {
    SwapiResponse<SwapiPlanet> response = swapiWebClient.get()
            .uri("/planets")
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiResponse<SwapiPlanet>>() {})
            .block();
    return response.getResults();
  }

  @Override
  public SwapiPlanet getSpecificPlanet(int index) {
    return swapiWebClient.get()
            .uri("/planets/" + index)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiPlanet>() {})
            .block();
  }

  @Override
  public List<SwapiSpaceship> getSpaceships() {
    SwapiResponse<SwapiSpaceship> response = swapiWebClient.get()
            .uri("/starships")
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiResponse<SwapiSpaceship>>() {})
            .block();
    return response.getResults();
  }

  @Override
  public SwapiSpaceship getSpecificSpaceship(int index) {
    return swapiWebClient.get()
            .uri("/starships/" + index)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiSpaceship>() {})
            .block();
  }

  @Override
  public List<SwapiSpecies> getSpecies() {
    SwapiResponse<SwapiSpecies> response = swapiWebClient.get()
            .uri("/species")
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiResponse<SwapiSpecies>>() {})
            .block();
    return response.getResults();
  }

  @Override
  public SwapiSpecies getSpecificSpecies(int index) {
    return swapiWebClient.get()
            .uri("/species/" + index)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiSpecies>() {})
            .block();
  }

  @Override
  public List<SwapiVehicle> getVehicles() {
    SwapiResponse<SwapiVehicle> response = swapiWebClient.get()
            .uri("/vehicles")
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiResponse<SwapiVehicle>>() {})
            .block();
    return response.getResults();
  }

  @Override
  public SwapiVehicle getSpecificVehicle(int index) {
    return swapiWebClient.get()
            .uri("/vehicles/" + index)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiVehicle>() {})
            .block();
  }
}
