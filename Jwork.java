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
        Recruiter recruiter1 = new Recruiter(1, "Ferdian", "ferdian.julianto@ui.ac.id", "0216327743", location1);
        Job job1 = new Job(1, "Accountant", recruiter1, 111111, "Economics");
        Jobseeker jobseeker1 = new Jobseeker(1, "Ferdian", "ferdian.julianto@ui.ac.id", "lalalala", "18 Maret 2021");
        Invoice invoice1 = new Invoice(1, 2, "18 Maret 2021", 2, jobseeker1);
        
        System.out.println(recruiter1.getName());
        recruiter1.setName("Ferdian Julianto");
        System.out.println(recruiter1.getName());
        job1.printData();
    }
}
