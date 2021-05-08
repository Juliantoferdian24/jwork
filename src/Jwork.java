import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Write a description of class Jwork here.
 *
 * @author Ferdian Julianto
 * @version 18.3.2021
 */

public class Jwork extends Thread{

    public static void main(String[] args) {

        ArrayList<Job> myJob = new ArrayList<Job>();
        ArrayList<Job> myJob1 = new ArrayList<Job>();





        Jobseeker myjobseeker1 = new Jobseeker(1, "Ferdian", "ferdian.julianto@ui.ac.id", "FerdianTekkom123");
        Jobseeker myjobseeker2 = new Jobseeker(2, "Julianto", "ferdian.julianto@ui.ac.id", "FerdianTekkom1");
        Jobseeker myjobseeker3 = new Jobseeker(3, "lala", "lalalalala@gmail.com", "Ferdian123");
        Jobseeker myjobseeker4 = new Jobseeker(4, "steven", "steven@gmail.com", "FerdianTekkom1");

        Bonus myBonus1 = new Bonus(11, "Grab123", 444, 111, true);
        Bonus myBonus2 = new Bonus(12, "Grab123", 444, 111, true);

        Location location1 = new Location("DKI Jakarta", "Jakarta Pusat", "Angke");
        Recruiter recruiter1 = new Recruiter(1, "Ferdian Julianto", "ferdian.julianto@ui.ac.id", "0216327743", location1);
        Job job1 = new Job(1, "ReactJS", recruiter1, 123, JobCategory.UX);

        try {
            DatabaseJobseeker.addJobseeker(myjobseeker1);
        }
        catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
        try {
            DatabaseJobseeker.addJobseeker(myjobseeker2);
        }
        catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
        try {
            DatabaseJobseeker.addJobseeker(myjobseeker3);
        }
        catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        try {
            DatabaseJobseeker.addJobseeker(myjobseeker4);
        }
        catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        try {
            DatabaseBonus.addBonus(myBonus1);
        } catch (ReferralCodeAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        try {
            DatabaseBonus.addBonus(myBonus2);
        } catch (ReferralCodeAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Ferdian Julianto",
                "Juliantoferdian24@gmail.com", "12345678", location1));
        try {
            DatabaseJob.addJob(new Job(1, "Frontend Engineer IBM", DatabaseRecruiter.getRecruiterById(1), 10000, JobCategory.FrontEnd));
        } catch (RecruiterNotFoundException e) {
            e.printStackTrace();
        }


        try {
            DatabaseJobseeker.removeJobseeker(1);
        } catch (JobSeekerNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            DatabaseRecruiter.removeRecruiter(2);
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            DatabaseJob.getJobById(1);
        } catch (JobNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            DatabaseBonus.getBonusById(12);
        } catch (BonusNotFoundException bonusNotFound) {
            System.out.println(bonusNotFound.getMessage());
        }

        System.out.println("\n=====================Jobseeker Database====================\n");
        System.out.println(DatabaseJobseeker.getDatabaseJobseeker());
        try {
            myJob.add(new Job(10, "Backend Engineer BukaLapak", DatabaseRecruiter.getRecruiterById(1), 10000, JobCategory.BackEnd));
        } catch (RecruiterNotFoundException e) {
            e.printStackTrace();
        }
        try {
            myJob1.add(new Job(11, "Backend Engineer BukaLapak", DatabaseRecruiter.getRecruiterById(1), 10000, JobCategory.BackEnd));
        } catch (RecruiterNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseInvoice.addInvoice(new EwalletPayment(12, myJob, DatabaseJobseeker.getJobseekerById(1)));
        } catch (JobSeekerNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.printStackTrace();
        }

        try {
            DatabaseInvoice.addInvoice(new EwalletPayment(13, myJob1, DatabaseJobseeker.getJobseekerById(2)));
        } catch (JobSeekerNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.printStackTrace();
        }

        try {
            DatabaseInvoice.addInvoice(new EwalletPayment(14, myJob1, DatabaseJobseeker.getJobseekerById(3)));
        } catch (JobSeekerNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.printStackTrace();
        }

        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase()){
            new Thread(new FeeCalculator(invoice)).start();
        }


        try {
            DatabaseInvoice.getInvoiceById(1);
        } catch (InvoiceNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseInvoice.removeInvoice(1);
        } catch (InvoiceNotFoundException e) {
            e.printStackTrace();
        }

//        Location location1 = new Location("DKI Jakarta", "Jakarta Barat", "Angke");
//        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Ferdian Julianto",
//                "Juliantoferdian24@gmail.com", "12345678", location1));
//        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Ferdian",
//                "ferdian.julianto@ui.ac.id", "Ferdian123", 2021, 04, 22));
//        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Ferdian",
//                "ferdian.julianto@ui.ac.id", "Ferdian123", 2021, 04, 23));
//        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Indira",
//                "Indira@ui.ac.id", "indira123", 2021, 04, 23));
//
//        System.out.println("Jobseeker Database");
//        System.out.println(DatabaseJobseeker.getDatabaseJobseeker());
//        DatabaseJob.addJob(new Job(1, "Frontend Engineer IBM", DatabaseRecruiter.getRecruiterById(1),
//                10000, JobCategory.FrontEnd));
//        DatabaseJob.addJob(new Job(2, "Data Analyst Shopee", DatabaseRecruiter.getRecruiterById(1), 20000,
//                JobCategory.DataAnalyst));
//        DatabaseJob.addJob(new Job(3, "Data Analyst Gojek", DatabaseRecruiter.getRecruiterById(1), 10000,
//                JobCategory.DataAnalyst));
//
//        System.out.println("Job Database By Category");
//        System.out.println(DatabaseJob.getJobByCategory(JobCategory.DataAnalyst));
//
//        DatabaseBonus.addBonus(new Bonus(34, "Grab123", 444, 555, false));
//        DatabaseBonus.addBonus(new Bonus(35, "Grab123", 444, 555, true));
//
//        System.out.println(DatabaseBonus.getBonusDatabase());
//
//        ArrayList<Job> job1 = new ArrayList<Job>();
//        ArrayList<Job> job2 = new ArrayList<Job>();
//        job1.add(new Job(1, "UX", new Recruiter(DatabaseRecruiter.getLastId() + 1, "Ferdian Julianto",
//                "Juliantoferdian24@gmail.com", "12345678", location1), 666, JobCategory.UX));
//        job2.add(new Job(1, "Frontend", new Recruiter(DatabaseRecruiter.getLastId() + 1, "Ferdian Julianto",
//                "Juliantoferdian24@gmail.com", "12345678", location1), 10, JobCategory.FrontEnd));



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
