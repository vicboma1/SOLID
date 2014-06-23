package dip.src;

import dip.api.Movie;

/**
 * Created by vicboma on 23/06/14.
 */
public class MovieImpl implements Movie {
    private String title;
    private String author;
    private Integer duration;

    public MovieImpl(String title, String author, Integer duration) {
        this.title = title;
        this.author = author;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object _movie) {
        if (this == _movie) return true;
        if (!(_movie instanceof MovieImpl)) return false;

        Boolean result = true;
        MovieImpl movieImpl = (MovieImpl) _movie;

        if (!author.equals(movieImpl.author) &&
                !duration.equals(movieImpl.duration) &&
                !title.equals(movieImpl.title))
            result = false;

        return result;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + duration.hashCode();
        return result;
    }
}
