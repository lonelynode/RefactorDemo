package rentalstore;

import form_template_method.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private form_template_method.Customer customer = new Customer("Jerry");

    @Test
    public void should_return_correct_statement_given_customer_has_no_rental() {
        String statement = customer.statement();
        assertEquals("Rental Record for Jerry\nAmount owed is 0.0\nYou earned 0 frequent renter points", statement);
    }
}
