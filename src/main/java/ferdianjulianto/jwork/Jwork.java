package ferdianjulianto.jwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jwork {

    public static void main(String[] args) {

        Location location1 = new Location("DKI Jakarta", "Jakarta Barat", "Ibu kota jakarta");
        Location location2 = new Location("Jawa Barat", "Bandung", "Ibu kota Jawa Barat");
        Location location3 = new Location("D.I Yogyakarta", "Yogyakarta", "Ibu kota Yogyakarta");

        DatabaseRecruiter.addRecruiter(new Recruiter(1, "Ferdian Julianto",
                "ferdian.julianto@ui.ac.id", "12345678", location1));
        DatabaseRecruiter.addRecruiter(new Recruiter(2, "Steven Novianto",
                "steven.novianto@ui.ac.id", "87654321", location2));
        DatabaseRecruiter.addRecruiter(new Recruiter(3, "vinsmoke sanji",
                "vinsmoke.sanji@ui.ac.id", "45674567", location3));

        try {
            DatabaseJob.addJob(new Job(14, "Backend Engineer Tokopedia", DatabaseRecruiter.getRecruiterById(1), 10000, JobCategory.BackEnd));
            DatabaseJob.addJob(new Job(15, "Frontend Engineer Gojek", DatabaseRecruiter.getRecruiterById(1), 10000, JobCategory.FrontEnd));
            DatabaseJob.addJob(new Job(16, "UI Engineer GOTO", DatabaseRecruiter.getRecruiterById(2), 10000, JobCategory.UI));
            DatabaseJob.addJob(new Job(17, "UI Engineer TOKEK", DatabaseRecruiter.getRecruiterById(3), 10000, JobCategory.UI));
        }
        catch(RecruiterNotFoundException e){
            e.printStackTrace();
        }

        SpringApplication.run(Jwork.class, args);
    }

}