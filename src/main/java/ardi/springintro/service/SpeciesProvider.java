package ardi.springintro.service;

import ardi.springintro.model.Species;

import java.util.List;

public interface SpeciesProvider {
    List<Species> getSpecies();

    Species getSpecies(int index);
}
