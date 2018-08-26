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
        int frequentRenterPoints = 0;
        Enumeration rentals = customer.getRentals().elements();
        String result = headerContent(customer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for this rental
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
        }
        //add footer lines
        return footerContent(result, getTotalCharge(customer), getTotalFrequentRenterPoints(customer));
    }

    public String headerContent(Customer customer) {
        String result = "<p><H1>Rental Record for <EM>" + customer.getName() + "</EM></H1</P>\n";
        return result;
    }

    public String footerContent(String result, double totalAmount, int frequentRenterPoints){
        result += "<P>You owed <EM>" + String.valueOf(totalAmount) + "</EM></P>\n";
        result += "<P>On this rental You earned<EM>" + String.valueOf(frequentRenterPoints)
                + "</EM> frequent renter points</P>";
        return result;
    }
}
