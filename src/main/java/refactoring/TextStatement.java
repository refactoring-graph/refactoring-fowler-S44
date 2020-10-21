package refactoring;

public class TextStatement extends Statement {

    protected String headerValue(Customer aCustomer){
        return "Rental Record for " + aCustomer.getName() + "\n";
    }

    protected String elementValue(Rental each){
        return "\t" + each.getMovie().getTitle()+ "\t" +
                String.valueOf(each.getCharge()) + "\n";
    }

    protected String footerValue(Customer aCustomer){
        String result = "Amount owed is " +
                String.valueOf(aCustomer.getTotalCharge()) + "\n";
        result += "You earned " +
                String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }
}
