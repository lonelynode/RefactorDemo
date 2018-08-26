package rentalstore;

import java.util.Enumeration;

public class CommonStatement extends AbstractStatement{
    protected String statement(Customer customer) {
        Enumeration rentals = customer.getRentals().elements();
        String result = headerContent(customer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        return footerContent(result, getTotalCharge(customer), getTotalFrequentRenterPoints(customer));
    }

    public String headerContent(Customer customer) {
        String result = "Rental Record for " + customer.getName() + "\n";
        return result;
    }

    public String footerContent(String result, double totalAmount, int frequentRenterPoints){
        result += "Amount owed is" + String.valueOf(totalAmount) + "\n";
        result += "You earned" + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
