package dip.src;

import dip.api.Movie;
import dip.api.MovieRentals;

import java.util.Map;

/**
 * Created by vicboma on 23/06/14.
 */
public class MovieRentalsImpl  implements MovieRentals {

    private Map<Movie, Boolean> mapMovies;

    public MovieRentalsImpl(Map<Movie, Boolean> mapMovies) {
        this.mapMovies = mapMovies;
    }

    public Boolean refund(Movie movieImpl) {
        return this.mapMovies.put(movieImpl, false);
    }

    public Boolean rental(Movie movieImpl) {
        return this.mapMovies.put(movieImpl, true);
    }

    public Boolean isRental(Movie movieImplID) {
        Boolean result = false;

        if (this.mapMovies.containsKey(movieImplID))
            result = this.mapMovies.get(movieImplID);

        return result;
    }
}
