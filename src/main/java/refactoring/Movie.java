package refactoring;

public class Movie {

    public static final int  CHILDRENS = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int arg) {
        _priceCode = arg;
    }

    public String getTitle (){
        return _title;
    }

    public double getCharge(int daysRented){
        double charge = 0.0;
        switch (this._priceCode) {
            case Movie.REGULAR:
                charge += 2;
                if (daysRented > 2)
                    charge += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                charge += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                charge += 1.5;
                if (daysRented > 3)
                    charge += (daysRented - 3) * 1.5;
                break;
        }
        return charge;
    }

    public int getFrequentRenterPoints(int daysRented){
        // add frequent renter points
        int frequentRenterPoints = 1;
        // add bonus for a two day new release rental
        if ((this._priceCode == Movie.NEW_RELEASE) &&
                daysRented > 1) frequentRenterPoints ++;
        return frequentRenterPoints;
    }
}