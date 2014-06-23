package ocp.test;

import ocp.api.Playable;
import ocp.src.Format;
import ocp.src.Movie;
import ocp.src.MovieSell;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;

import static org.junit.Assert.assertTrue;

public class MovieImplSellTest {

    private HashSet<Playable> setMovieSell;

    @Before
    public void setUp() throws Exception {
        addMovies();
    }

    @Test
    public void testSell() throws Exception {

        final MovieSell movieSell = new MovieSell(setMovieSell);
        final Boolean sell1 = movieSell.sell(getMovie1());
        assertTrue("fail sell",sell1 );
        final Boolean sell2 = movieSell.sell(getMovie2());
        assertTrue("fail sell",sell2 );
        final Boolean sell3 = movieSell.sell(getMovie3());
        assertTrue("fail sell",sell3 );
    }

    private void addMovies() {
        setMovieSell = new LinkedHashSet<Playable>()
        {
            {
                add(getMovie1());
                add(getMovie2());
                add(getMovie3());
            }
        };
    }

    private Playable getMovie1() {
        return new Movie("Back to the future I", "Robert Zemeckis", 116, Format.CD);
    }

    private Playable getMovie2() {
        return new Movie("Back to the future II", "Robert Zemeckis", 169, Format.LASER_DISC);
    }

    private Playable getMovie3() {
        return new Movie("Back to the future III", "Robert Zemeckis", 118, Format.DVD);
    }

}