package ardi.springintro.controller;

import ardi.springintro.model.Spaceship;
import ardi.springintro.service.SpaceshipProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpaceshipsController {

    @Autowired
    private SpaceshipProvider starwarsSpaceship;

    @GetMapping("/spaceships")
    public List<Spaceship> getSpaceships() {
        List<Spaceship> spaceships = starwarsSpaceship.getSpaceships();

        return spaceships;
    }

    @GetMapping("/spaceships/{index}")
    public Spaceship getSpaceship(@PathVariable(name = "index") int urutan) {
        Spaceship spaceship = starwarsSpaceship.getSpaceship(urutan);

        return spaceship;
    }
}
