package rentalstore;

import java.util.Enumeration;

public abstract class AbstractStatement {
    protected abstract String statement(Customer customer);
    protected double getTotalCharge(Customer customer) {
        double result = 0;
        Enumeration rentals = customer.getRentals().elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    protected int getTotalFrequentRenterPoints(Customer customer) {
        int result = 0;
        Enumeration rentals = customer.getRentals().elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRentalPoints();
        }
        return result;

    }
}
