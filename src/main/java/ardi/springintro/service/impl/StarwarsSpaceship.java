package ardi.springintro.service.impl;

import ardi.springintro.model.Spaceship;
import ardi.springintro.model.swapi.model.SwapiSpaceship;
import ardi.springintro.service.SpaceshipProvider;
import ardi.springintro.service.SwapiClient;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class StarwarsSpaceship implements SpaceshipProvider {

    SwapiClient swapiClient;

    public StarwarsSpaceship(SwapiClient swapiClient) {
        this.swapiClient = swapiClient;
    }

    @Override
    public List<Spaceship> getSpaceships() {
        List<SwapiSpaceship> swapiSpaceships = swapiClient.getSpaceships();
        List<Spaceship> response = new ArrayList<>();
        for (SwapiSpaceship swapiSpaceship: swapiSpaceships) {
            Spaceship spaceship = new Spaceship();
            BeanUtils.copyProperties(swapiSpaceship, spaceship);

            response.add(spaceship);
        }

        return response;
    }

    @Override
    public Spaceship getSpaceship(int index) {
        SwapiSpaceship swapiSpaceship = swapiClient.getSpecificSpaceship(index);
        Spaceship spaceship = new Spaceship();
        BeanUtils.copyProperties(swapiSpaceship, spaceship);
        return spaceship;
    }
}
