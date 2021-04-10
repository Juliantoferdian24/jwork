import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Write a description of class Invoice here.
 *
 * @author Ferdian Julianto
 * @version 18.3.2021
 */
public abstract class Invoice
{
    // instance variables
    private int id;
    private Job job;
    private Calendar date;
    protected int totalFee;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;

    /**
     * Constructor for objects of class Recruiter
     * @param id merujuk pada id
     * @param idJob merujuk pada idJob
     * @param date merujuk pada tanggal
     * @param totalFee merujuk pada total gaji
     * @param jobseeker merujuk pada jobseeker
     */
    public Invoice(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus){
        this.id = id;
        this.job = job;
        this.date = Calendar.getInstance();
        this.jobseeker = jobseeker;
        this.invoiceStatus = invoiceStatus;
    }
    
    
    
    /** 
     * @return int
     */
    public int getId() {
        return id;
    }
    
    public Job getJob(){
        return job;
    }
    /**
     * @return date mengembalikan String date
     */
    public Calendar getDate(){
        return date;
    }
    /**
     * @return totalFee mengembalikan int totalFee
     */
    public int getTotalFee(){
        return totalFee;
    }
    /**
     * @return jobseeker mengembalikan Jobseeker jobseeker
     */
    public Jobseeker getJobseeker() {
        return jobseeker;
    }

    /**
     * @return paymentType mengembalikan PaymentType paymentType
     */
    public abstract PaymentType getPaymentType();

    /**
     * @return invoiceStatus mengembalikan InvoiceStatus invoiceStatus
     */
    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    /**
     * @param id merujuk pada id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @param idJobs merujuk pada idJobs
     */
    public void setJob(Job job) {
        this.job = job;
    }
    
    /**
     * @param date merujuk pada date
     */
    public void setJoinDate(Calendar joinDate)
    {
        this.date = date;
    }

    public void setJoinDate(int year, int month, int dayOfMonth)
    {
        this.date = new GregorianCalendar(year, month - 1, dayOfMonth);
    }
    
    
    /**
     * @param totalFee merujuk pada totalFee
     */
    public abstract void setTotalFee();
    
    /**
     * @param jobseeker merujuk pada jobseeker
     */
    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }

    /**
     * @param invoiceStatus merujuk pada invoiceStatus
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * Method untuk Print Data
     */
    public abstract String toString();
}
