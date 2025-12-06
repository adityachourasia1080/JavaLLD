package LLD.BookMyShow.TheaterInfoClasses;

import LLD.BookMyShow.MovieInfoClass.Movie;

import java.util.ArrayList;
import java.util.List;

public class Show {

    public Show(Movie movie,Screen screen, double startTime,List<Seat> seat){
        this.bookedSeats=seat;
        this.movie=movie;
        this.screen=screen;
        this.startTime=startTime;
    }

    public List<Integer> getBookedSeatIds() {
        List<Integer> bookedIds = new ArrayList<>();
        for (Seat s: bookedSeats){
            bookedIds.add(s.getSeatNo());
        }
        return bookedIds;
    }

    public Screen getScreen() {
        return screen;
    }

    Movie movie;
    Screen screen;
    double startTime;
    List<Seat> bookedSeats;
}
