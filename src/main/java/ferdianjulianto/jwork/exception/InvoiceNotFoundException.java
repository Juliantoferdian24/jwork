package ferdianjulianto.jwork.exception;

/**
 * Class InvoiceNotFoundException is class that serves as invoice error handling
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public class InvoiceNotFoundException extends Exception {

    private final int invoice_error;

    /**
     * Constructor for invoice error handling
     *
     * @param invoice_input variable for passing the information of id invoice
     */
    public InvoiceNotFoundException(int invoice_input) {
        super("Invoice ID: ");
        invoice_error = invoice_input;
    }

    /**
     * Method to print the information of the error handling
     */
    public String getMessage() {
        return super.getMessage() + invoice_error + " not found";
    }
}