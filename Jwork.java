/**
 * Write a description of class Jwork here.
 *
 * @author Ferdian Julianto
 * @version 18.3.2021
 */

public class Jwork
{   
    /**
     * Fungsi Utama
     * @param args
     */
    public static void main(String[] args)
    {
        Location location1 = new Location("DKI Jakarta", "Jakarta Pusat", "Angke");
        Recruiter recruiter1 = new Recruiter(1, "Ferdian Julianto", "ferdian.julianto@ui.ac.id", "0216327743", location1);
        Job job1 = new Job(1, "ReactJS", recruiter1, 999999999, JobCategory.FrontEnd);
        Jobseeker myjobseeker = new Jobseeker(99, "apa", "apa@gmail.com", "apa", "27/3/2020");
        Invoice myInvoice = new Invoice(123, job1.getId(), "27/3/2020", job1.getFee(), myjobseeker, PaymentType.BankPayment, InvoiceStatus.OnGoing);
        
        myInvoice.printData();
    }
}
