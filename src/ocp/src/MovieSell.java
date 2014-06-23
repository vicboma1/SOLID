package ocp.src;

import ocp.api.Playable;

import java.util.HashSet;

/**
 * Created by vicboma on 23/06/14.
 */
public class MovieSell {

    private HashSet<Playable> setMovies;

    public MovieSell(HashSet<Playable> setMovies) {
        this.setMovies = setMovies;
    }

    public Boolean sell(Playable movie) {
        Boolean result = false;

        if (this.setMovies.contains(movie))
            result = this.setMovies.remove(movie);

        return result;
    }
}
