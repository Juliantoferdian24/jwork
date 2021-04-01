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
        Location location1 = new Location("DKI Jakarta", "Jakarta Pusat", "Angke");
        Recruiter recruiter1 = new Recruiter(1, "Ferdian Julianto", "ferdian.julianto@ui.ac.id", "0216327743", location1);
        Job job1 = new Job(1, "ReactJS", recruiter1, 123, JobCategory.FrontEnd);
        Jobseeker myjobseeker = new Jobseeker(99, "apa", "apa@gmail.com", "apa", "27/3/2020");
        
        Bonus myBonus1 = new Bonus(34, "Grab123", 444, 555, true);
        Bonus myBonus2 = new Bonus(33, "Gojek123", 333, 111, true);

        EwalletPayment invoice1 = new EwalletPayment(1, job1, "13 April 2021", myjobseeker, InvoiceStatus.OnGoing);
        EwalletPayment invoice2 = new EwalletPayment(2, job1, "14 April 2021",myjobseeker,InvoiceStatus.OnGoing, myBonus1);
        EwalletPayment invoice3 = new EwalletPayment(3, job1, "15 April 2021", myjobseeker, InvoiceStatus.OnGoing, myBonus2);
        
        invoice1.printData();
        invoice2.printData();
        invoice3.printData();
    }
}
