package ferdianjulianto.jwork.model;

import ferdianjulianto.jwork.util.InvoiceStatus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class BankPayment is class that stores information for every Bank Payment Object
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public abstract class Invoice {
    // instance variables dari Invoice
    private int id;
    private ArrayList<Job> jobs;
    private Calendar date;
    protected int totalFee;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;

    /**
     * Constructor for Invoice
     *
     * @param id        variable used to identify Invoice
     * @param jobs      variable used to store jobs.
     * @param jobseeker variable used to store jobseeker.
     */
    public Invoice(
            int id,
            ArrayList<Job> jobs,
            Jobseeker jobseeker) {
        this.id = id;
        this.jobs = jobs;
        this.jobseeker = jobseeker;
        this.invoiceStatus = InvoiceStatus.OnGoing;
        this.date = Calendar.getInstance();
    }

    /**
     * Method as getter to get id of the invoice.
     *
     * @return id variable used to identify invoice.
     */
    public int getId() {
        return id;
    }

    /**
     * Method as getter to get list of jobs
     *
     * @return list of jobs
     */
    public ArrayList<Job> getJobs() {
        return jobs;
    }

    /**
     * Method as getter to get invoice Date
     *
     * @return Calendar Object
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * Method as getter to get Total Fee
     *
     * @return total fee
     */
    public int getTotalFee() {
        return totalFee;
    }

    /**
     * Method as getter to get Invoice Status
     *
     * @return Invoice Status
     */
    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    /**
     * Method as getter to get Payment Type
     *
     * @return PaymentTypa Object
     */
    public abstract PaymentType getPaymentType();

    /**
     * Method as setter to set id of the bonus.
     *
     * @param id variable used to identify Bonus.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method as setter to set jobse
     *
     * @param jobs variable used to store jobs.
     */
    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    /**
     * Method as setter to set date
     *
     * @param date variable used to store date.
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * Method as setter to set date
     *
     * @param year       variable used to store year.
     * @param month      variable used to store month.
     * @param dayOfMonth variable used to store dayOfMonth.
     */
    public void setDate(int year, int month, int dayOfMonth) {
        this.date = new GregorianCalendar(year, month, dayOfMonth);
    }

    /**
     * Method as setter to set Total Fee
     */
    public abstract void setTotalFee();

    /**
     * Method as getter to get Jobseeker
     *
     * @return Jobseeker Object
     */
    public Jobseeker getJobseeker() {
        return jobseeker;
    }

    /**
     * Method as setter to set Jobseeker
     *
     * @param jobseeker variable used to store jobseeker
     */
    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }

    /**
     * Method as setter to set Invoice Status
     *
     * @param invoiceStatus variable used to store jobseeker
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * Method for printing data
     */
    public abstract String toString();
}
