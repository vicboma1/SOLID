Single Responsibility Principle
===============================

In this context a responsibility is considered to be one reason to change. 
This principle states that if we have 2 reasons to change for a class, we have to split the functionality in two classes. 
Each class will handle only one responsibility and on future if we need to make one change we are going to make it in the class which handle it.
When we need to make a change in a class having more responsibilities the change might affect the other functionality of the classes.

Intent

A class should have only one reason to change.


Example - Bad design

```
public class Movie {
    private String title;
    private String author;
    private Integer duration;
    private Boolean isRental;

    public Movie(String title, String author, Integer duration) {
        this.title = title;
        this.author = author;
        this.duration = duration;
    }
    
    ...
    
    public void rental(Boolean _rental){  
        this.isRental = _rental;
    }
    
    public Boolean isRental(){
        return this.isRental();
    }
    
```

We apply single responsibility principle - Good design

```
public class Movie {
    private String title;
    private String author;
    private Integer duration;

    public Movie(String title, String author, Integer duration) {
        this.title = title;
        this.author = author;
        this.duration = duration;
    }

    ...
    
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

```
