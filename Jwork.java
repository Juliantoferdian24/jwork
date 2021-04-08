import java.util.GregorianCalendar;

/**
 * Write a description of class Jwork here.
 *
 * @author Ferdian Julianto
 * @version 18.3.2021
 */

public class Jwork
{   
    /**
     * Fungsi Utama yang dijalankan
     * @param args
     */
    
    public static void main(String[] args)
    {
        // Location location1 = new Location("DKI Jakarta", "Jakarta Pusat", "Angke");
        // Recruiter recruiter1 = new Recruiter(1, "Ferdian Julianto", "ferdian.julianto@ui.ac.id", "0216327743", location1);
        // Job job1 = new Job(1, "ReactJS", recruiter1, 123, JobCategory.UX);
        
        
        // Bonus myBonus1 = new Bonus(34, "Grab123", 444, 555, true);
        // Bonus myBonus2 = new Bonus(33, "Gojek123", 444, 111, true);

        // EwalletPayment invoice1 = new EwalletPayment(1, job1, "13 April 2021", myjobseeker, InvoiceStatus.OnGoing);
        // EwalletPayment invoice2 = new EwalletPayment(2, job1, "14 April 2021",myjobseeker,InvoiceStatus.OnGoing, myBonus1);
        // EwalletPayment invoice3 = new EwalletPayment(3, job1, "15 April 2021", myjobseeker, InvoiceStatus.OnGoing, myBonus2);
        
        // BankPayment invoice1 = new BankPayment(1, job1, "3/4/2020", myjobseeker, InvoiceStatus.Finished);
        // BankPayment invoice2 = new BankPayment(2, job1, "3/4/2020", myjobseeker, InvoiceStatus.Finished, 13);

        Jobseeker myjobseeker1 = new Jobseeker(1, "Indira", "kjsdkjdsa", "12", new GregorianCalendar(2021, 8, 15));
        Jobseeker myjobseeker2 = new Jobseeker(2, "Indira", "ferdian.julianto@ui.ac.id", "FerdianTekkom123", 2021, 04, 8);
        Jobseeker myjobseeker3 = new Jobseeker(3, "Indira", "ferdian.julianto@ui.ac.id", "FerdianTekkom1");
        System.out.println(myjobseeker1.toString());
        System.out.println(myjobseeker2.toString());
        System.out.println(myjobseeker3.toString());
        myjobseeker1.setEmail("ferdian.julianto@ui.ac.id");
        myjobseeker1.setPassword("Ferdian123");
        System.out.println(myjobseeker1.toString());
    }
}
