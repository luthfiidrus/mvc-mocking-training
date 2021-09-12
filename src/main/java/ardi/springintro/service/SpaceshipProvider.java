package ardi.springintro.service;

import ardi.springintro.model.Spaceship;

import java.util.List;

public interface SpaceshipProvider {
    List<Spaceship> getSpaceships();

    Spaceship getSpaceship(int index);
}
