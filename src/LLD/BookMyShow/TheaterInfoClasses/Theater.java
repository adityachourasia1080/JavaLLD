package LLD.BookMyShow.TheaterInfoClasses;

import LLD.BookMyShow.enums.City;

import java.util.List;

public class Theater {

    public  Theater(int theaterId,City city, List<Screen> screen,List<Show> show){
        this.city=city;
        this.theaterId=theaterId;
        this.screen=screen;
        this.show=show;
    }
    public int theaterId;
    public City city;
    public List<Screen> screen;
    public List<Show> show;

}
