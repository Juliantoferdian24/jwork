import java.util.GregorianCalendar;

/**
 * Write a description of class Jwork here.
 *
 * @author Ferdian Julianto
 * @version 18.3.2021
 */

public class Jwork {

    public static void main(String[] args) {

        Location location1 = new Location("DKI Jakarta", "Jakarta Barat", "Angke");
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Ferdian Julianto",
                "Juliantoferdian24@gmail.com", "085945644450", location1));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Ferdian",
                "ferdian.julianto@ui.ac.id", "Ferdian123", 2021, 04, 22));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Ferdian",
                "ferdian.julianto@ui.ac.id", "Ferdian123", 2021, 04, 23));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Indira",
                "Indira@ui.ac.id", "indira123", 2021, 04, 23));

        System.out.println("Jobseeker Database");
        System.out.println(DatabaseJobseeker.getDatabaseJobseeker());
        DatabaseJob.addJob(new Job(1, "Frontend Engineer IBM", DatabaseRecruiter.getRecruiterById(1),
                10000, JobCategory.FrontEnd));
        DatabaseJob.addJob(new Job(2, "Data Analyst Shopee", DatabaseRecruiter.getRecruiterById(1), 20000,
                JobCategory.DataAnalyst));
        DatabaseJob.addJob(new Job(3, "Data Analyst Gojek", DatabaseRecruiter.getRecruiterById(1), 10000,
                JobCategory.DataAnalyst));

        System.out.println("Job Database By Category");
        System.out.println(DatabaseJob.getJobByCategory(JobCategory.DataAnalyst));

//        Location location1 = new Location("DKI Jakarta", "Jakarta Pusat", "Angke");
//        Recruiter recruiter1 = new Recruiter(1, "Ferdian Julianto", "ferdian.julianto@ui.ac.id", "0216327743", location1);
//        Job job1 = new Job(1, "ReactJS", recruiter1, 123, JobCategory.UX);
//
//
//        Bonus myBonus1 = new Bonus(34, "Grab123", 444, 555, true);
//        Bonus myBonus2 = new Bonus(33, "Gojek123", 444, 111, true);
//        Jobseeker myjobseeker1 = new Jobseeker(1, "Indira", "kjsdkjdsa", "12", new GregorianCalendar(2021, 8, 15));
//        Jobseeker myjobseeker2 = new Jobseeker(2, "Indira", "ferdian.julianto@ui.ac.id", "FerdianTekkom123", 2021, 04, 8);
//        Jobseeker myjobseeker3 = new Jobseeker(3, "Indira", "ferdian.julianto@ui.ac.id", "FerdianTekkom1");
//
//        BankPayment invoice1 = new BankPayment(1, job1,  myjobseeker2, InvoiceStatus.Finished);
//        BankPayment invoice2 = new BankPayment(2, job1,  myjobseeker2, InvoiceStatus.Finished, 13);
//
//        EwalletPayment Einvoice1 = new EwalletPayment(1, job1, myjobseeker1, InvoiceStatus.OnGoing);
//        EwalletPayment Einvoice2 = new EwalletPayment(2, job1, myjobseeker2,InvoiceStatus.OnGoing, myBonus1);
//        EwalletPayment Einvoice3 = new EwalletPayment(3, job1, myjobseeker3, InvoiceStatus.OnGoing, myBonus2);
//
//        invoice1.setTotalFee();
//        invoice2.setTotalFee();
//        Einvoice1.setTotalFee();
//        Einvoice2.setTotalFee();
//        Einvoice3.setTotalFee();
//
//        System.out.println(invoice1.toString());
//        System.out.println(invoice2.toString());
//        System.out.println(Einvoice1.toString());
//        System.out.println(Einvoice2.toString());
//        System.out.println(Einvoice3.toString());
//
//        System.out.println(myjobseeker3.toString());
//        myjobseeker1.setEmail("ferdian.julianto@ui.ac.id");
//        myjobseeker1.setPassword("Ferdian123");
//        System.out.println(myjobseeker1.toString());
    }
}
