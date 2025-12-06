package LLD.BookMyShow;

import LLD.BookMyShow.MovieInfoClass.Movie;
import LLD.BookMyShow.MovieInfoClass.MovieController;
import LLD.BookMyShow.TheaterInfoClasses.*;
import LLD.BookMyShow.enums.City;
import LLD.BookMyShow.enums.ScreenType;
import LLD.BookMyShow.enums.SeatType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BookMyShowApp {

    MovieController movieController;
    TheaterController theatreController;

    BookMyShowApp() {
        movieController = new MovieController();
        theatreController = new TheaterController();
    }


    public static void main(String args[]) {

        BookMyShowApp bookMyShow = new BookMyShowApp();

        bookMyShow.initialize();

        //user1
        bookMyShow.createBooking(City.Bangalore, "Avengers");
        //user2
        bookMyShow.createBooking(City.Bangalore, "Avengers");

    }

    private void createBooking(City userCity, String movieName) {


        //1. search movie by my location
        List<Movie> movies = movieController.getMoviesByCity(userCity);

        //2. select the movie which you want to see. i want to see avengers
        Movie interestedMovie = null;
        for (Movie movie : movies) {

            if ((movie.getMovieName()).equals(movieName)) {
                interestedMovie = movie;
            }
        }

        //3. get all show of this movie in Bangalore location
        Map<Theater, List<Show>> showsTheatreWise = theatreController.getAllShow(interestedMovie, userCity);

        //4. select the particular show user is interested in
        Map.Entry<Theater,List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        //5. select the seat
        int seatNumber = 67;
        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);
            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat screenSeat : interestedShow.getScreen().getSeats()) {
                if(screenSeat.getSeatNo() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");
    }



    private void initialize() {

        createMovies();
        createTheaters();
    }

    private void createTheaters() {

        Seat s1= new Seat(991, SeatType.Reckliner);
        Seat s2= new Seat(992,SeatType.Normal);
        Screen screen1 = new Screen(123, new ArrayList<>(Arrays.asList(s1,s2)), ScreenType.ULTRAHD);
        Show show = new Show(movieController.getMoviesByCity(City.Bangalore).getFirst(),screen1,8.00,new ArrayList<>());
        Theater th1= new Theater(56,City.Bangalore,new ArrayList<>(Arrays.asList(screen1)),new ArrayList<>(Arrays.asList(show)));

        Seat s3= new Seat(881, SeatType.Reckliner);
        Seat s4= new Seat(882,SeatType.Normal);
        Screen screen2 = new Screen(231, new ArrayList<>(Arrays.asList(s3,s4)),ScreenType.T3D);
        Show show2 = new Show(movieController.getMoviesByCity(City.Bangalore).getFirst(),screen2,12.00,new ArrayList<>());
        Theater th2= new Theater(57,City.Bangalore,new ArrayList<>(Arrays.asList(screen2)),new ArrayList<>(Arrays.asList(show2)));
        
        theatreController.addTheaterToCity(City.Bangalore,th1);
        theatreController.addTheaterToCity(City.Bangalore,th2);
    }

    private void createMovies() {

        Movie Avengers = new Movie(123,"Avengers",120);
        Movie SpiderMan= new Movie(234,"SpiderMan",132);

        movieController.addMovies(City.Nagpur,Avengers);
        movieController.addMovies(City.Bangalore,SpiderMan);

    }

}
