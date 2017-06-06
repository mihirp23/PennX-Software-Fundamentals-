import java.util.*;

/*
 ***********************************
 * Name : Mihir Patel
 * Date : June 6, 2017
 **********************************
 */

public class MovieDatabase {

    private ArrayList < Movie > movieList = new ArrayList < Movie > ();
    private ArrayList < Actor > actorList = new ArrayList < Actor > ();

    public MovieDatabase() {
        this.movieList = new ArrayList < Movie > ();
        this.actorList = new ArrayList < Actor > ();
    }

    public ArrayList < Movie > getMovieList() {
        return movieList;
    }

    public ArrayList < Actor > getActorList() {
        return actorList;
    }

    /**
     * This method takes in the name of a movie with a list
     * of actors. 
     * If movie already exists, it doesn't add it.
     * If movie is new, it is added to the movieList
     * If any of the actors are new, they are added to actorList
     * @param name - name of the movie to be added
     * @param actors - list of actors starring in the movie
     */
    public void addMovie(String name, String[] actors) {
        Movie newMovie = new Movie();
        newMovie.setName(name);

        ArrayList < Movie > mlist = new ArrayList < Movie > ();
        mlist.add(newMovie);

        ArrayList < Actor > alist = new ArrayList < Actor > ();

        for (int i = 0; i < actors.length; i++) {
            Actor newActor = new Actor();
            newActor.setName(actors[i]);
            newActor.setMovies(mlist);
            alist.add(newActor);
            // make sure there is no existing actor with the same name.
            boolean actor_found = false;
            for (int j = 0; j < actorList.size(); j++) {
                if (actorList.get(j).getName() == actors[i]) {
                    actor_found = true;
                }
            }
            if (!actor_found) {
                actorList.add(newActor);
            }

        }

        // only add the movie object if it already does not exist.
        boolean movie_found = false;
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getName() == newMovie.getName()) {
                movie_found = true;
            }
        }
        if (!movie_found) {
            newMovie.setActors(alist);
            movieList.add(newMovie);
        }


    }

    /**
     * Add a rating for the movie.
     * @param name - name of the movie
     * @param rating - rating of the movie
     */
    public void addRating(String name, double rating) {
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getName() == name) {
                movieList.get(i).setRating(rating);
                return;
            }
        }
    }

    /**
     * Overwrite the current rating of a movie
     * @param name - name of the movie
     * @param newRating - the value of the new rating
     */
    public void updateRating(String name, double newRating) {
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getName() == name) {
                movieList.get(i).setRating(newRating);
            }
        }
    }

    /**
     * @return - name of the actor that has the best 
     * average rating for their movies.
     */
    public String getBestActor() {
        String bestActor = null;
        double max_avg = 0;

        for (Actor actor: actorList) {
            ArrayList < Movie > movies = actor.getMovies();
            if (movies.size() <= 0) continue;
            double sum = 0;
            for (Movie movie: movies) {
                sum += movie.getRating();
            }
            double avg = sum / movies.size();
            if (avg > max_avg) {
                max_avg = avg;
                bestActor = actor.getName();
            }

        }

        return bestActor;
    }

    /**
     * @return - returns the highest rated movie.
     */
    public String getBestMovie() {
        String bestMovie = null;
        double max_rating = 0;
        for (Movie movie: movieList) {
            double rating = movie.getRating();
            if (rating > max_rating) {
                max_rating = rating;
                bestMovie = movie.getName();
            }
        }

        return bestMovie;
    }

    public void display() {
        System.out.println("Movies");
        for (Movie movie: movieList) {
            System.out.println(movie.getName());
            System.out.println(movie.getRating());
            for (Actor actor: movie.getActors()) {
                System.out.println(actor.getName());
            }
        }

    }

    public static void main(String[] args) {
        MovieDatabase md = new MovieDatabase();
        String[] actors = {
            "Al Pacino",
            "Marlon Brando"
        };
        md.addMovie("The Godfather", actors);
        //md.display();
        md.addMovie("The Godfather", actors);
        md.display();


    }

}
