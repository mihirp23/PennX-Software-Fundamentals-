import java.util.*;

/*
 ***********************************
 * Name : Mihir Patel
 * Date : June 6, 2017
 **********************************
 */

public class Movie {
    private String name; // name of the movie
    private ArrayList < Actor > actors = new ArrayList < Actor > (); // actors in the movie
    double rating; // freshness rating from rotten tomatoes

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList < Actor > getActors() {
        return actors;
    }
    public void setActors(ArrayList < Actor > actors) {
        this.actors = actors;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
}
