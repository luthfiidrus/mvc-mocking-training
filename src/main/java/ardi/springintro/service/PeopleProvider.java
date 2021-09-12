package ardi.springintro.service;

import ardi.springintro.model.People;

import java.util.List;

public interface PeopleProvider {
    List<People> getPeople();

    People getPeople(int index);
}
