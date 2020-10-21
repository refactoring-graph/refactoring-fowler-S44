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
        double charge = 0.0;
        switch (this._movie.getPriceCode()) {
            case Movie.REGULAR:
                charge += 2;
                if (this._daysRented > 2)
                    charge += (this._daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                charge += this._daysRented * 3;
                break;
            case Movie.CHILDRENS:
                charge += 1.5;
                if (this._daysRented > 3)
                    charge += (this._daysRented - 3) * 1.5;
                break;
        }
        return charge;
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
