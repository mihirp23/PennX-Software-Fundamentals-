import java.util.*;
public class Actor {
	String name; // actors full name
	ArrayList <Movie> movies = 
			new ArrayList <Movie> (); // movies featuring the actor
	
	
	public void setName(String pname) {
		this.name = pname;
	}
	
	public void setMovies(ArrayList<Movie> ms) {
		this.movies = ms;
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Movie> getMovies() {
		return this.movies;
	}
	
}
