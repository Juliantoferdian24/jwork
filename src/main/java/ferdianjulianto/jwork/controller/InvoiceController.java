package ferdianjulianto.jwork.controller;

import ferdianjulianto.jwork.database.bonus.DatabaseBonusPostgre;
import ferdianjulianto.jwork.database.invoice.DatabaseInvoice;
import ferdianjulianto.jwork.database.job.DatabaseJobPostgre;
import ferdianjulianto.jwork.database.jobseeker.DatabaseJobseekerPostgre;
import ferdianjulianto.jwork.exception.InvoiceNotFoundException;
import ferdianjulianto.jwork.exception.OngoingInvoiceAlreadyExistsException;
import ferdianjulianto.jwork.model.BankPayment;
import ferdianjulianto.jwork.model.EwalletPayment;
import ferdianjulianto.jwork.model.Invoice;
import ferdianjulianto.jwork.model.Job;
import ferdianjulianto.jwork.util.InvoiceStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class InvoiceController will handle Request Method related to Invoice
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */

@RequestMapping("/invoice")
@RestController
public class InvoiceController {

    /**
     * Method to shows all invoice in the database
     *
     * @return all invoice in database
     */
    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    /**
     * Method to get invoice from id
     *
     * @param id variable used to identify invoice.
     * @return single invoice object
     */
    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id) {
        Invoice invoice;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return invoice;
    }

    /**
     * Method to get invoice from jobseeker
     *
     * @param jobseekerId variable used to identify jobseeker.
     * @return single invoice object
     */
    @RequestMapping("/jobseeker/{jobseekerId}")
    public ArrayList<Invoice> getInvoiceByJobseeker(@PathVariable int jobseekerId) {
        return DatabaseInvoice.getInvoiceByJobseeker(jobseekerId);
    }

    /**
     * Method to remove invoice
     *
     * @param id variable used to identify Bonus.
     * @return true if success, false if failed
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean removeInvoice(@PathVariable int id) {
        try {
            DatabaseInvoice.removeInvoice(id);
            return true;
        } catch (InvoiceNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method to change invoice status
     *
     * @param id     variable used to identify invoice.
     * @param status variable used by invoice status
     * @return invoice object
     */
    @RequestMapping(value = "invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "status") InvoiceStatus status) {
        Invoice invoice;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
            invoice.setInvoiceStatus(status);
            return invoice;
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;
        }
    }

    /**
     * Method to adds new invoice into database with Bank payment type
     *
     * @param jobIdList   variable used to identify job
     * @param jobseekerId variable used to identify jobseeker
     * @param adminFee    variable used by admin Fee
     * @return invoice object
     */
    @RequestMapping(value = "createBankPayment", method = RequestMethod.POST)
    public Invoice addBankPayment(@RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value = "jobseekerId") int jobseekerId,
                                  @RequestParam(value = "adminFee") int adminFee) {
        Invoice invoice;
        ArrayList<Job> jobs = new ArrayList<>();
        for (Integer integer : jobIdList) {
            jobs.add(DatabaseJobPostgre.getJobById(integer));
        }
        invoice = new BankPayment(DatabaseInvoice.getLastId() + 1, jobs, DatabaseJobseekerPostgre.getJobseekerById(jobseekerId), adminFee);
        invoice.setTotalFee();
        boolean status = false;
        try {
            status = DatabaseInvoice.addInvoice(invoice);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.printStackTrace();
        }
        if (status) {
            return invoice;
        } else {
            return null;
        }
    }

    /**
     * Method to adds new invoice into database with Bank payment type
     *
     * @param jobIdList    variable used to identify job
     * @param jobseekerId  variable used to identify jobseeker
     * @param referralCode variable used by referral code
     * @return invoice object
     */
    @RequestMapping(value = "createEWalletPayment", method = RequestMethod.POST)
    public Invoice addEWalletPayment(@RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
                                     @RequestParam(value = "jobseekerId") int jobseekerId,
                                     @RequestParam(value = "referralCode") String referralCode) {
        Invoice invoice;
        ArrayList<Job> jobs = new ArrayList<>();
        for (Integer integer : jobIdList) {
            jobs.add(DatabaseJobPostgre.getJobById(integer));
        }
        invoice = new EwalletPayment(DatabaseInvoice.getLastId() + 1, jobs, DatabaseJobseekerPostgre.getJobseekerById(jobseekerId), DatabaseBonusPostgre.getBonusByRefferalCode(referralCode));
        invoice.setTotalFee();
        boolean status = false;
        try {
            status = DatabaseInvoice.addInvoice(invoice);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.printStackTrace();
        }
        if (status) {
            return invoice;
        } else {
            return null;
        }
    }
}