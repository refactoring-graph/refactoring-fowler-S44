package refactoring;

public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public double getCharge(){
        return _movie.getCharge(this._daysRented);
    }

    public int getFrequentRenterPoints() {
        // add frequent renter points
        int frequentRenterPoints = 1;
        // add bonus for a two day new release rental
        if ((this._movie.getPriceCode() == Movie.NEW_RELEASE) &&
                this._daysRented > 1) frequentRenterPoints ++;
        return frequentRenterPoints;
    }
}
