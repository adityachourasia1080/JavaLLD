package LLD.BookMyShow.MovieInfoClass;

import LLD.BookMyShow.enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieController {

    HashMap<City, List<Movie>>mapCityToMovie;
    List<Movie>allMovies;

    public void addMovies(City city,Movie movie){
        System.out.println("Adding City " +city +" to Movie "+ movie);
        allMovies.add(movie);
        if (!mapCityToMovie.containsKey(city)){
            mapCityToMovie.put(city,new ArrayList<>());
        }
        List<Movie> temp = mapCityToMovie.get(city);
        temp.add(movie);
        mapCityToMovie.put(city,temp);
        System.out.println("Added City: " +city +" to Movie "+ movie + " Completed");
    }

    public List<Movie> getMoviesByCity(City c){
        if (mapCityToMovie.containsKey(c))  return new ArrayList<>(mapCityToMovie.get(c));
        return new ArrayList<>();
    }

}
