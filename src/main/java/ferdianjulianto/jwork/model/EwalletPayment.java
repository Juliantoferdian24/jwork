package ferdianjulianto.jwork.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Class EwalletPayment is class that stores information for every Ewallet Payment Object
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public class EwalletPayment extends Invoice {

    private Bonus bonus;
    private static final PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;

    /**
     * Constructor for Ewallet Payment
     *
     * @param id        variable used to identify Ewallet Payment.
     * @param jobs      variable used to store jobs.
     * @param jobseeker variable used to store jobseeker.
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker) {
        super(id, jobs, jobseeker);
    }

    /**
     * Constructor for Ewallet Payment
     *
     * @param id        variable used to identify Ewallet Payment.
     * @param jobs      variable used to store jobs.
     * @param jobseeker variable used to store jobseeker.
     * @param bonus     variable used to store bonus
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, Bonus bonus) {
        super(id, jobs, jobseeker);
        this.setBonus(bonus);
    }

    /**
     * Method as getter to get payment type used
     */
    @Override
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }

    /**
     * Method as getter to get Bonus
     */
    public Bonus getBonus() {
        return bonus;
    }

    /**
     * Method as setter to set Bonus
     */
    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    /**
     * Method as setter to set total fee of job
     */
    @Override
    public void setTotalFee() {
        ArrayList<Job> jobs = getJobs();
        for (Job job : jobs) {
            int fee = job.getFee();
            if (bonus != null && (bonus.getActive()) && fee > bonus.getMinTotalFee()) {
                super.totalFee = fee + bonus.getExtraFee();
            } else {
                super.totalFee = fee;
            }
        }
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
            if ((bonus != null) && (bonus.getActive()) && (job.getFee() > bonus.getMinTotalFee())) {
                res.concat("\nId = " + getId() + "\nJob = " + job.getName() + "\nDate = " + date + "\nJob Seeker = "
                        + getJobseeker().getName() + "\nReferral Code = " + bonus.getReferralCode() + "\nTotal Fee = "
                        + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
            } else {
                res.concat("\nId = " + getId() + "\nJob = " + job.getName() + "\nDate = " + date + "\nJob Seeker = "
                        + getJobseeker().getName() + bonus.getReferralCode() + "\nTotal Fee = "
                        + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
            }

        }
        return res;
    }
}