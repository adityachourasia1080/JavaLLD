package LLD.BookMyShow.TheaterInfoClasses;

import LLD.BookMyShow.enums.City;
import LLD.BookMyShow.MovieInfoClass.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterController {
    HashMap<City, List<Theater>> mapCityToTheater;
    List<Theater>allTheaters;


    public void addTheaterToCity(City c,Theater th){
        if (!mapCityToTheater.containsKey(c)) mapCityToTheater.put(c,new ArrayList<>());
        List<Theater> temp= new ArrayList<>();
        temp.add(th);
        mapCityToTheater.put(c,temp);

        allTheaters.add(th);
    }

    public List<Theater> getAllTheaters() {
        return allTheaters;
    }

    public List<Theater> getCityforTheater(City c){
        if (mapCityToTheater.containsKey(c))  return mapCityToTheater.get(c);
        return new ArrayList<>();
    }

    public Map<Theater, List<Show>> getAllShow(Movie movie, City city) {

        //get all the theater of this city

        Map<Theater, List<Show>> theatreVsShows = new HashMap<>();

        List<Theater> theatres = mapCityToTheater.get(city);

        //filter the theatres which run this movie

        for(Theater theatre : theatres) {

            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.show;

            for(Show show : shows) {
                if(show.movie.movieId == movie.movieId) {
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()) {
                theatreVsShows.put(theatre, givenMovieShows);
            }
        }

        return theatreVsShows;

    }}
