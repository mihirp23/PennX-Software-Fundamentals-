import java.util.*;
public class MovieDatabase {
	ArrayList <Movie> movieList= new ArrayList <Movie> ();
	ArrayList <Actor> actorList = new ArrayList <Actor> ();

    public MovieDatabase() {
    	this.movieList = new ArrayList <Movie> ();
    	this.actorList = new ArrayList <Actor> ();
    }

	public ArrayList <Movie> getMovieList() { 
		return this.movieList;
	}
	
	public ArrayList <Actor> getActorList() {
		return this.actorList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
