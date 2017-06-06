import java.util.*;
public class Movie {
	String name; // movie name
	ArrayList <Actor> actors = 
			new ArrayList <Actor> (); // actors in the movie
	double rating; // movie's rating
	
	public void setName(String pname) {
		this.name = pname;
	}
	
	public void setActors(ArrayList <Actor> as) {
		this.actors = as;
	}
	
	public void setRating(double r) {
		this.rating = r;
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList <Actor> getActors () {
		return this.actors;
	}
	
	public double getRating () {
		return this.rating;
	}

}
