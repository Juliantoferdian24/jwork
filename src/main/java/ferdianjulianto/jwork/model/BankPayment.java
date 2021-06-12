package ferdianjulianto.jwork.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Class BankPayment is class that stores information for every Bank Payment Object
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public class BankPayment extends Invoice {
    private static final PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee;

    /**
     * Constructor for Bank Payment
     *
     * @param id        variable used to identify Bank Payment.
     * @param jobs      variable used to store jobs.
     * @param jobseeker variable used to store jobseeker.
     */
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker) {
        super(id, jobs, jobseeker);
    }

    /**
     * Constructor for Bank Payment
     *
     * @param id        variable used to identify Bank Payment.
     * @param jobs      variable used to store jobs.
     * @param jobseeker variable used to store jobseeker.
     * @param adminFee  variable used for Administration Fee.
     */
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker,
                       int adminFee) {
        super(id, jobs, jobseeker);
        this.adminFee = adminFee;
    }

    /**
     * Method as setter to set total fee of job
     */
    @Override
    public void setTotalFee() {
        for (Job job : getJobs()) {
            if (adminFee != 0) {
                totalFee = job.getFee() - getAdminFee();
            } else {
                totalFee = job.getFee();
            }
        }
    }

    /**
     * Method as getter to get payment type used
     */
    @Override
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }

    /**
     * Method as getter to get Admin Fee
     */
    public int getAdminFee() {
        return adminFee;
    }

    /**
     * Method as setter to set Administration Fee
     */
    public void setAdminFee(int adminFee) {
        this.adminFee = adminFee;
    }

    /**
     * Method to print the information of the error handling
     */
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        String date = dateFormat.format(getDate().getTime());
        String res = "";
        for (Job job : getJobs()) {
            if (adminFee != 0) {
                res.concat("\nId = " + getId() + "\nJob = " + job.getName() + "\nDate = " + date + "\nJob Seeker = "
                        + getJobseeker().getName() + "\nAdmin Fee = " + adminFee + "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
            } else {
                res.concat("\nId = " + getId() + "\nJob = " + job.getName() + "\nDate = " + date + "\nJob Seeker = "
                        + getJobseeker().getName() + "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
            }
        }
        return res;
    }
}