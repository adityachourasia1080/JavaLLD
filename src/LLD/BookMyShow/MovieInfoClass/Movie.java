package LLD.BookMyShow.MovieInfoClass;


public class Movie {

    public Movie(int movieId,String movieName,int duration){
        this.movieId=movieId;
        this.movieName=movieName;
        this.duration=duration;
    }

    public String getMovieName(){
        return movieName;
    }

    public int movieId;
    public String movieName;
    public int duration;

}
