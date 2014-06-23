package srp.test;

import srp.src.Movie;
import srp.src.MovieRentals;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieImplRentalsTest {

    @org.junit.Test
    public void testIsRental() throws Exception {
        final Map<Movie, Boolean> mapMovies = getMapMovies();
        final MovieRentals movieRentals = new MovieRentals(mapMovies);
        final Movie movie = getMovie();

        movieRentals.rental(movie);
        assertTrue("fail rental", movieRentals.isRental(movie));

        movieRentals.refund(movie);
        assertFalse("fail refund", movieRentals.isRental(movie));

    }

    private Movie getMovie() {
        return new Movie("Back to the future", "Robert Zemeckis", 116);
    }

    private Map<Movie, Boolean> getMapMovies() {
        return new HashMap<Movie, Boolean>();
    }
}