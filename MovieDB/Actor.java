import java.util.*;

/*
 ***********************************
 * Name : Mihir Patel
 * Date : June 6, 2017
 **********************************
 */

public class Actor {
    private String name; // name of the actor or actress
    private ArrayList < Movie > movies = new ArrayList < Movie > (); // movies that actor has acted in 

    public ArrayList < Movie > getMovies() {
        return movies;
    }

    public void setMovies(ArrayList < Movie > movies) {
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
