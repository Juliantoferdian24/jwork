package ferdianjulianto.jwork.database.invoice;

import ferdianjulianto.jwork.util.InvoiceStatus;
import ferdianjulianto.jwork.exception.InvoiceNotFoundException;
import ferdianjulianto.jwork.exception.OngoingInvoiceAlreadyExistsException;
import ferdianjulianto.jwork.model.Invoice;

import java.util.ArrayList;

/**
 * Class DatabaseInvoice contains all object of Invoice stored in ArrayList Invoice
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public class DatabaseInvoice {
    private static final ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();
    private static int lastId;

    /**
     * Method to show invoice list from invoice database
     *
     * @return BONUS_DATABASE array list that stores information of all Invoice
     */
    public static ArrayList<Invoice> getInvoiceDatabase() {
        return INVOICE_DATABASE;
    }

    /**
     * Method to show last id of Invoice in Invoice database
     *
     * @return last id of Invoice in database
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * Method to show invoice by id in invoice database
     *
     * @param id passing parameter that stores invoice id
     * @return invoice object
     * @throws InvoiceNotFoundException
     */
    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException {
        Invoice result = null;
        for (Invoice invoice : INVOICE_DATABASE) {
            if (id == invoice.getId()) {
                result = invoice;
            } else {
                result = null;
            }
        }
        if (result == null) {
            throw new InvoiceNotFoundException(id);
        }

        return result;
    }

    /**
     * Method to show invoice by jobseeker
     *
     * @param customerId id of the jobseeker
     * @return Invoice Object
     */
    public static ArrayList<Invoice> getInvoiceByJobseeker(int customerId) {
        ArrayList<Invoice> invoiceJobseeker = new ArrayList<>();
        for (Invoice invoice : INVOICE_DATABASE) {
            if (customerId == invoice.getJobseeker().getId()) {
                invoiceJobseeker.add(invoice);
            }
        }
        return invoiceJobseeker;
    }

    /**
     * Method to add invoice into invoice database
     *
     * @param invoice passing parameter that stores object invoice
     * @return boolean that show the succession of the method
     * @throws OngoingInvoiceAlreadyExistsException
     */
    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException {
        for (Invoice invoicee : INVOICE_DATABASE) {
            if (invoicee.getInvoiceStatus() == InvoiceStatus.OnGoing) {
                throw new OngoingInvoiceAlreadyExistsException(invoice);
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    /**
     * Method to change invoice status
     *
     * @param id            passing parameter that stores invoice id
     * @param invoiceStatus passing parameter that stores invoice status
     * @return invoice status
     */
    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        boolean temp = true;
        for (Invoice invoice : INVOICE_DATABASE) {
            if (id == invoice.getId()) {
                invoice.setInvoiceStatus(InvoiceStatus.OnGoing);
                temp = true;
            } else {
                temp = false;
            }
        }
        return temp;
    }

    /**
     * Method to remove invoice from invoice database
     *
     * @param id passing parameter that stores invoice id
     * @return boolean that show the succession of the method
     * @throws InvoiceNotFoundException
     */
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException {
        for (Invoice invoice : INVOICE_DATABASE) {
            if (invoice.getId() == id) {
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }


}