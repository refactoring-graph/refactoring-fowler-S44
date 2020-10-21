package refactoring;

import java.util.Enumeration;

public class TextStatement extends Statement {

    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = this.headerValue(aCustomer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += this.elementValue(each);
        }
        //add footer lines
        result += this.footerValue(aCustomer);
        return result;
    }

    private String headerValue(Customer aCustomer){
        return "Rental Record for " + aCustomer.getName() + "\n";
    }

    private String elementValue(Rental each){
        return "\t" + each.getMovie().getTitle()+ "\t" +
                String.valueOf(each.getCharge()) + "\n";
    }

    private String footerValue(Customer aCustomer){
        String result = "Amount owed is " +
                String.valueOf(aCustomer.getTotalCharge()) + "\n";
        result += "You earned " +
                String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }
}
