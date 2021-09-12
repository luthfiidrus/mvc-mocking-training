package ardi.springintro.service.impl;

import ardi.springintro.model.People;
import ardi.springintro.model.swapi.model.SwapiPeople;
import ardi.springintro.service.PeopleProvider;
import ardi.springintro.service.SwapiClient;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class StarwarsPeople implements PeopleProvider {

    SwapiClient swapiClient;

    public StarwarsPeople(SwapiClient swapiClient) {
        this.swapiClient = swapiClient;
    }

    @Override
    public List<People> getPeople() {
        List<SwapiPeople> swapiPeople = swapiClient.getPeople();
        List<People> response = new ArrayList<>();
        for (SwapiPeople person: swapiPeople) {
            People people = new People();
            BeanUtils.copyProperties(person, people);

            response.add(people);
        }

        return response;
    }

    @Override
    public People getPeople(int index) {
        SwapiPeople swapiPeople = swapiClient.getSpecificPeople(index);
        People people = new People();
        BeanUtils.copyProperties(swapiPeople, people);
        return people;
    }
}
