package ardi.springintro.service;

import ardi.springintro.model.Movie;

import java.util.List;

public interface MovieProvider {

    List<Movie> getMovies();

    Movie getMovie(int index);

    boolean saveMovie(Movie movie);

    boolean deleteMovie();

}
