package srp.src;

import java.util.Map;

/**
 * Created by vicboma on 23/06/14.
 */
public class MovieRentals {

    private Map<Movie, Boolean> mapMovies;

    public MovieRentals(Map<Movie, Boolean> mapMovies) {
        this.mapMovies = mapMovies;
    }

    public Boolean refund(Movie movie) {
        return this.mapMovies.put(movie, false);
    }

    public Boolean rental(Movie movie) {
        return this.mapMovies.put(movie, true);
    }

    public Boolean isRental(Movie movieID) {
        Boolean result = false;

        if (this.mapMovies.containsKey(movieID))
            result = this.mapMovies.get(movieID);

        return result;
    }
}
