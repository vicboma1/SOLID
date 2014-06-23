Open Close Principle
====================

The Open Close Principle states that the design and writing of the code should be done in a way that new functionality 
should be added with minimum changes in the existing code. 
The design should be done in a way to allow the adding of new functionality as new classes, keeping as much as possible existing code unchanged.

Intent

Software entities like classes, modules and functions should be open for extension but closed for modifications.


Example - Bad design

```

public class Movie implements Playable{
    private String title;
    private String author;
    private Integer duration;
    private Boolean isSelling;

    public Movie(String title, String author, Integer duration) {
        this.title = title;
        this.author = author;
        this.duration = duration;
    }

    ...
    
    public void selling(Boolean _sell){  
          this.isSelling = sell;
    }
       
    public Boolean isSelling(){
         return this.isSelling();
    }
    
    
    
    
public class MovieSell {
 
    public MovieSell() {
    }

    public Boolean sell(Movie movie) {
        Boolean result = movie.isSelling();
        
        if (!result){
            movie.selling(true);
            return true;
        }
        else 
         return false;
    }
}

```

We apply open close principle - Good design

```
public class Movie implements Playable{
    private String title;
    private String author;
    private Integer duration;
    private Format format;

    public Movie(String title, String author, Integer duration, Format format) {
        this.title = title;
        this.author = author;
        this.duration = duration;
        this.format = format;
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
        result = 31 * result + format.hashCode();
        result = 31 * result + duration.hashCode();
        return result;
    }

    @Override
    public Format play() {
        return format;
    }
    
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

```


    
    
