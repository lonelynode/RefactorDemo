package rentalstore;

import java.util.Enumeration;

public class HtmlStatement extends AbstractStatement{
    /*
    <H1>Rentals for <EM>Jerry</EM></H1><P>
    Roman Holiday: 3.0<BR>
    Titanic: 3.0<BR>
    <P>You owe<EM>3.0</EM><P>
    On this rental you earned <EM>2</EM> frequent renter points<P>
     */
    protected String statement(Customer customer) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = customer.getRentals().elements();
        String result = "<p><H1>Rental Record for <EM>" + customer.getName() + "</EM></H1</P>\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDayRented() > 2) {
                        thisAmount += (each.getDayRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDayRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDayRented() > 3) {
                        thisAmount += (each.getDayRented() - 3) * 1.5;
                    }
                    break;
            }
            //add frequent renter points
            frequentRenterPoints++;
            //add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1) {
                frequentRenterPoints++;
            }
            //show figures for this rental
            result += each.getMovie().getTitle() + ": " + String.valueOf(thisAmount) + "<BR>\n";
            totalAmount += thisAmount;
        }

        //add footer lines
        result += "<P>You owed <EM>" + String.valueOf(totalAmount) + "</EM></P>\n";
        result += "<P>On this rental You earned<EM>" + String.valueOf(frequentRenterPoints)
                + "</EM> frequent renter points</P>";
        return result;
    }
}
