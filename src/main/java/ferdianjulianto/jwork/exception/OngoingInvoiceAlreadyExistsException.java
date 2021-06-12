package ferdianjulianto.jwork.exception;

import ferdianjulianto.jwork.model.Invoice;

/**
 * Class OngoingInvoiceAlreadyExistsException is class that serves as invoice error handling
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public class OngoingInvoiceAlreadyExistsException extends Exception{
    private final Invoice invoice_error;

    /**
     * Constructor for invoice error handling
     *
     * @param invoice_input variable for passing the information of id invoice
     */
    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input){
        super("OnGoing Invoice : ");
        this.invoice_error = invoice_input;
    }

    /**
     * Method to print the information of the error handling
     */
    public String getMessage() {
        return super.getMessage() + invoice_error.getInvoiceStatus() + " already exists.";
    }
}