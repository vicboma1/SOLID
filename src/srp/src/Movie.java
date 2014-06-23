package srp.src;

/**
 * Created by vicboma on 23/06/14.
 */
public class Movie {
    private String title;
    private String author;
    private Integer duration;

    public Movie(String title, String author, Integer duration) {
        this.title = title;
        this.author = author;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object _movie) {
        if (this == _movie) return true;
        if (!(_movie instanceof Movie)) return false;

        Boolean result = true;
        Movie movie = (Movie) _movie;

        if (!author.equals(movie.author) &&
                !duration.equals(movie.duration) &&
                !title.equals(movie.title))
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
