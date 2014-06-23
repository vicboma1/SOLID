package dip.api;

/**
 * Created by vicboma on 23/06/14.
 */
public interface MovieRentals {
    Boolean refund(Movie movieImpl);
    Boolean rental(Movie movieImpl);
    Boolean isRental(Movie movieImplID);
}
