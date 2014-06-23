Dependency Inversion Principle
============

We can introduce an abstraction layer between high level classes and low level classes. Since the high level modules
contain the complex logic they should not depend on the low level modules so the new abstraction layer should not be 
created based on low level modules. Low level modules are to be created based on the abstraction layer.

According to this principle the way of designing a class structure is to start from high level modules to the low level modules:
1.High Level Classes
2.Abstraction Layer
3.Low Level Classes


Intent

High-level modules should not depend on low-level modules. Both should depend on abstractions.
Abstractions should not depend on details. Details should depend on abstractions.

Example - Bad design

```
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
 
 public class MovieRentals {
 
     private Map<Movie, Boolean> mapMovies;
 
     public MovieRentalsImpl(Map<Movie, Boolean> mapMovies) {
         this.mapMovies = mapMovies;
     }
 
     public Boolean refund(String title, String author, Integer duration) {
         Movie movie = getMovie(title,author, duration);
         return this.mapMovies.put(movie, false);
     }
 
     public Boolean rental(String title, String author, Integer duration) {
         Movie movie = getMovie(title,author, duration);
         return this.mapMovies.put(movieImpl, true);
     }
 
     public Boolean isRental(String title, String author, Integer duration) {
         Movie movie = getMovie(title,author, duration);
         Boolean result = false;
 
         if (this.mapMovies.containsKey(movieImplID))
             result = this.mapMovies.get(movieImplID);
 
         return result;
     }
     
     private Movie getMovie(String title, String author, Integer duration){
        return new Movie(title,author, duration);
    }
     
 }
    
```

We apply dependency inversion principle - Good design

```
public interface Movie {
    boolean equals(Object _movie);
    int hashCode();
}

public interface MovieRentals {
    Boolean refund(Movie movieImpl);
    Boolean rental(Movie movieImpl);
    Boolean isRental(Movie movieImplID);
}


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
 
 public class MovieRentalsImpl implements MovieRentals {
 
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

```
