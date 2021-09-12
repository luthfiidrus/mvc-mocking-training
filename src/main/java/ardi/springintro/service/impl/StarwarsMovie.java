package ardi.springintro.service.impl;

import ardi.springintro.model.Movie;
import ardi.springintro.model.swapi.model.SwapiFilm;
import ardi.springintro.service.MovieProvider;
import ardi.springintro.service.SwapiClient;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class StarwarsMovie implements MovieProvider {

    List<Movie> movies = new ArrayList<>();
    /*
    *  return daftar movie starwars
    *
    * */

    SwapiClient swapiClient;

    public StarwarsMovie(SwapiClient swapiClient) {
        this.swapiClient = swapiClient;
    }

    @Override
    public List<Movie> getMovies(){
        List<SwapiFilm> swapiFilms = swapiClient.getFilms();
        List<Movie> response = new ArrayList<>();
        for (SwapiFilm swapiFilm: swapiFilms) {
            Movie movie = new Movie();
            movie.setEpisode_id(swapiFilm.getEpisode_id());
            movie.setTitle(swapiFilm.getTitle());

            response.add(movie);
        }

        return response;
    }

    @Override
    public Movie getMovie(int index) {
        SwapiFilm swapiFilm = swapiClient.getSpecificFilms(index);
        Movie movie = new Movie();
        BeanUtils.copyProperties(swapiFilm, movie);
        return movie;
    }

    @Override
    public boolean saveMovie(Movie movie) {
        movies.add(movie);
        return true;
    }

    @Override
    public boolean deleteMovie() {
        movies.clear();
        return true;
    }
}
