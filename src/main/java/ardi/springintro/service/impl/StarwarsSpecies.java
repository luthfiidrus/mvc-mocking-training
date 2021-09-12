package ardi.springintro.service.impl;

import ardi.springintro.model.Species;
import ardi.springintro.model.swapi.model.SwapiSpecies;
import ardi.springintro.service.SpeciesProvider;
import ardi.springintro.service.SwapiClient;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class StarwarsSpecies implements SpeciesProvider {

    SwapiClient swapiClient;

    public StarwarsSpecies(SwapiClient swapiClient) {
        this.swapiClient = swapiClient;
    }

    @Override
    public List<Species> getSpecies() {
        List<SwapiSpecies> swapiSpecies = swapiClient.getSpecies();
        List<Species> response = new ArrayList<>();
        for (SwapiSpecies swapiSpecies1: swapiSpecies) {
            Species species = new Species();
            BeanUtils.copyProperties(swapiSpecies1, species);

            response.add(species);
        }

        return response;
    }

    @Override
    public Species getSpecies(int index) {
        SwapiSpecies swapiSpecies = swapiClient.getSpecificSpecies(index);
        Species species = new Species();
        BeanUtils.copyProperties(swapiSpecies, species);
        return species;
    }
}
