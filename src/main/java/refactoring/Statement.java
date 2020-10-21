package refactoring;

import java.util.Enumeration;

public abstract class Statement {
    protected abstract String headerValue(Customer aCustomer);
    protected abstract String elementValue(Rental each);
    protected abstract String footerValue(Customer aCustomer);

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
}
