package rentalstore;

import java.util.Enumeration;

public class CommonStatement extends AbstractStatement{
    protected String statement(Customer customer) {
        Enumeration rentals = customer.getRentals().elements();
        StringBuilder result = new StringBuilder(headerContent(customer));
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(String.valueOf(each.getCharge())).append("\n");
        }
        //add footer lines
        return footerContent(result.toString(), getTotalCharge(customer), getTotalFrequentRenterPoints(customer));
    }

    private String headerContent(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }

    private String footerContent(String result, double totalAmount, int frequentRenterPoints){
        result += "Amount owed is" + String.valueOf(totalAmount) + "\n";
        result += "You earned" + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
