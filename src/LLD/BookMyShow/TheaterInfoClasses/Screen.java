package LLD.BookMyShow.TheaterInfoClasses;

import LLD.BookMyShow.enums.ScreenType;

import java.util.List;

public class Screen {

    public Screen(int screenId, List<Seat> seat, ScreenType sc){
        this.screenId=screenId;
        this.screenType=sc;
        this.seats=seat;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public int screenId;
    public List<Seat> seats;
    ScreenType screenType;

}
