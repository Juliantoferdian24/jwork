package ferdianjulianto.jwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class Jwork {

    public static void main(String[] args) {

//        ArrayList<Job> myJob = new ArrayList<Job>();
//
//        Location location1 = new Location("DKI Jakarta", "Jakarta Barat", "Ibu kota jakarta");
//        Location location2 = new Location("Jawa Barat", "Bandung", "Ibu kota Jawa Barat");
//        Location location3 = new Location("D.I Yogyakarta", "Yogyakarta", "Ibu kota Yogyakarta");
//
//        Jobseeker myjobseeker1 = new Jobseeker(1, "Ferdian", "ferdian.julianto@ui.ac.id", "FerdianTekkom123");
//        Jobseeker myjobseeker2 = new Jobseeker(2, "Steven", "Steven.julianto@ui.ac.id", "FerdianTekkom123");
//
//        try {
//            DatabaseJobseeker.addJobseeker(myjobseeker1);
//            DatabaseJobseeker.addJobseeker(myjobseeker2);
//        } catch (EmailAlreadyExistsException e) {
//            e.printStackTrace();
//        }
//
//        Recruiter recruiter1 = new Recruiter(1, "Ferdian Julianto",
//                "ferdian.julianto@ui.ac.id", "12345678", location1);
//
////        try {
////            DatabaseJob.addJob(new Job(1, "Backend Engineer Tokopedia", DatabaseRecruiter.getRecruiterById(1), 10000, JobCategory.BackEnd));
////            DatabaseJob.addJob(new Job(2, "Frontend Engineer Gojek", DatabaseRecruiter.getRecruiterById(1), 10000, JobCategory.FrontEnd));
////            DatabaseJob.addJob(new Job(3, "UI Engineer GOTO", DatabaseRecruiter.getRecruiterById(2), 10000, JobCategory.UI));
////            DatabaseJob.addJob(new Job(4, "UI Engineer TOKEK", DatabaseRecruiter.getRecruiterById(3), 10000, JobCategory.UI));
////        } catch (RecruiterNotFoundException e) {
////            e.printStackTrace();
////        }
//
//        myJob.add(new Job(10, "Backend Engineer BukaLapak", recruiter1, 10000, JobCategory.BackEnd));
//        myJob.add(new Job(11, "Backend Engineer Shopee", recruiter1, 10000, JobCategory.BackEnd));
//        myJob.add(new Job(12, "Backend Engineer Tokopedia", recruiter1, 10000, JobCategory.BackEnd));
//
//        try {
//            EwalletPayment ewalletPayment1 = new EwalletPayment(12, myJob, DatabaseJobseeker.getJobseekerById(1));
//            EwalletPayment ewalletPayment2 = new EwalletPayment(13, myJob, DatabaseJobseeker.getJobseekerById(1));
//        } catch (JobSeekerNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        DatabaseRecruiter.addRecruiter(new Recruiter(1, "Ferdian Julianto",
//                "ferdian.julianto@ui.ac.id", "12345678", location1));
//        DatabaseRecruiter.addRecruiter(new Recruiter(2, "Steven Novianto",
//                "steven.novianto@ui.ac.id", "87654321", location2));
//        DatabaseRecruiter.addRecruiter(new Recruiter(3, "vinsmoke sanji",
//                "vinsmoke.sanji@ui.ac.id", "45674567", location3));


        SpringApplication.run(Jwork.class, args);
    }

}