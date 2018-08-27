package rentalstore;

import rentalstore.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private rentalstore.Customer customer = new Customer("Jerry");

    //Amount owed is3.0
    //You earned1 frequent renter points
    @Test
    public void should_return_correct_statement_given_customer_has_no_rental() {
        String statement = customer.statement();
        assertEquals("Rental Record for Jerry\nAmount owed is0.0\nYou earned0 frequent renter points", statement);
    }
    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_1_day() {
        Movie regularMovie = new RegularMovie("Titanic");
        Rental oneDayRental = new Rental(regularMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Jerry\n" +
                "\t" + regularMovie.getTitle() + "\t2.0\n" +
                "Amount owed is2.0\n" +
                "You earned1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_3_day() {
        Movie regularMovie = new RegularMovie("Titanic");
        Rental threeDayRental = new Rental(regularMovie, 3);
        customer.addRental(threeDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Jerry\n" +
                "\t" + regularMovie.getTitle() + "\t3.5\n" +
                "Amount owed is3.5\n" +
                "You earned1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_1_day() {
        Movie newReleaseMovie = new NewReleaseMovie("Titanic");
        Rental oneDayRental = new Rental(newReleaseMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Jerry\n" +
                "\t" + newReleaseMovie.getTitle() + "\t3.0\n" +
                "Amount owed is3.0\n" +
                "You earned1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_2_day() {
        Movie newReleaseMovie = new NewReleaseMovie("Titanic");
        Rental twoDayRental = new Rental(newReleaseMovie, 2);
        customer.addRental(twoDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Jerry\n" +
                "\t" + newReleaseMovie.getTitle() + "\t6.0\n" +
                "Amount owed is6.0\n" +
                "You earned2 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_1_day() {
        Movie childrenMovie = new ChildrenMoive("Titanic");
        Rental oneDayRental = new Rental(childrenMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Jerry\n" +
                "\t" + childrenMovie.getTitle() + "\t1.5\n" +
                "Amount owed is1.5\n" +
                "You earned1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        Movie childrenMovie = new ChildrenMoive("Titanic");
        Rental fourDayRental = new Rental(childrenMovie, 4);
        customer.addRental(fourDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Jerry\n" +
                "\t" + childrenMovie.getTitle() + "\t3.0\n" +
                "Amount owed is3.0\n" +
                "You earned1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_two_child_movie_for_4_day() {
        Movie childrenMovie = new ChildrenMoive("Roman Holiday");
        Movie childrenMovie2 = new ChildrenMoive("Titanic");
        Rental fourDayRental = new Rental(childrenMovie, 4);
        Rental fourDayRenta2 = new Rental(childrenMovie2, 4);
        customer.addRental(fourDayRental);
        customer.addRental(fourDayRenta2);

        String statement = customer.htmlStatement();

        System.out.println(statement);

        assertEquals("<p><H1>Rental Record for <EM>Jerry</EM></H1</P>\n"
                + "Roman Holiday: 3.0<BR>\n"
                + "Titanic: 3.0<BR>\n"
                + "<P>You owed <EM>6.0</EM></P>\n"
                + "<P>On this rental You earned<EM>2</EM> frequent renter points</P>", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_Literature_movie_for_1_day() {
        Movie LiteratureMovie = new LiteratureMovie("Macbeth");
        Rental fourDayRental = new Rental(LiteratureMovie, 1);
        customer.addRental(fourDayRental);

        String statement = customer.htmlStatement();

        System.out.println(statement);

        assertEquals("<p><H1>Rental Record for <EM>Jerry</EM></H1</P>\n"
                + "Macbeth: 6.0<BR>\n"
                + "<P>You owed <EM>6.0</EM></P>\n"
                + "<P>On this rental You earned<EM>1</EM> frequent renter points</P>", statement);
    }
}
