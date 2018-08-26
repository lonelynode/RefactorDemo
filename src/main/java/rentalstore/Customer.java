package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg){
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement(){
        CommonStatement cst = new CommonStatement();
        return cst.statement(this);
    }

    public String htmlStatement() {
       HtmlStatement hst = new HtmlStatement();
       return hst.statement(this);
    }

    public Vector getRentals() {
        return rentals;
    }
}
