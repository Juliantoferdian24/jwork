package ferdianjulianto.jwork.util;

/**
 * InvoiceStatus yang bisa digunakan
 */

public enum InvoiceStatus {
    OnGoing("OnGoing"),
    Finished("Finished"),
    Cancelled("Cancelled");

    private final String invoice;

    /**
     * Constructor for Invoice Status
     *
     * @param invoice variable used to store Invoice
     */
    InvoiceStatus(String invoice) {
        this.invoice = invoice;
    }

    /**
     * Method for printing data
     */
    @Override
    public String toString() {
        return invoice;
    }
}
