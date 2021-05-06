import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Invoice
{
    // instance variables dari Invoice
    private int id;
    private ArrayList<Job> jobs;
    private Calendar date;
    protected int totalFee;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;

    /**
     * Constructor dari invoice
     */
    public Invoice(
            int id,
            ArrayList<Job> jobs,
            Jobseeker jobseeker){
        this.id = id;
        this.jobs = jobs;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
        this.invoiceStatus = InvoiceStatus.OnGoing;
        this.date = Calendar.getInstance();
    }


    public int getId(){
        return id;
    }

    public ArrayList<Job> getJobs(){
        return jobs;
    }

    public Calendar getDate(){
        return date;
    }

    public int getTotalFee(){
        return totalFee;
    }

    public InvoiceStatus getInvoiceStatus(){
        return invoiceStatus;
    }

    public abstract PaymentType getPaymentType();

    public void setId(int id){
        this.id = id;
    }

    public void setJobs(ArrayList<Job> jobs){
        this.jobs = jobs;
    }

    public void setDate(Calendar date){
        this.date = date;
    }

    public void setDate(int year, int month, int dayOfMonth){
        this.date = new GregorianCalendar(year, month, dayOfMonth);
    }

    public abstract void setTotalFee();


    public Jobseeker getJobseeker() {
        return jobseeker;
    }

    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }

    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public abstract String toString();
}
