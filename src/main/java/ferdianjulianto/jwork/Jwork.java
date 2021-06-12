package ferdianjulianto.jwork;

import ferdianjulianto.jwork.database.bonus.DatabaseBonusPostgre;
import ferdianjulianto.jwork.database.job.DatabaseJobPostgre;
import ferdianjulianto.jwork.database.location.DatabaseLocationPostgre;
import ferdianjulianto.jwork.database.recruiter.DatabaseRecruiterPostgre;
import ferdianjulianto.jwork.model.Bonus;
import ferdianjulianto.jwork.model.Job;
import ferdianjulianto.jwork.model.Location;
import ferdianjulianto.jwork.model.Recruiter;
import ferdianjulianto.jwork.util.JobCategory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jwork {
    public static void main(String[] args) {
//        DatabaseLocationPostgre.insertLocation(new Location(DatabaseLocationPostgre.getLastId() + 1, "DKI Jakarta", "Jakarta Barat", "Tempat Tinggalku"));
//        DatabaseLocationPostgre.insertLocation(new Location(DatabaseLocationPostgre.getLastId() + 1, "Jawa Barat", "Bandung", "Tempat Tinggalku"));
//        DatabaseLocationPostgre.insertLocation(new Location(DatabaseLocationPostgre.getLastId() + 1, "Sumatra Utara", "Medan", "Tempat Tinggalku"));
//
//        DatabaseRecruiterPostgre.insertRecruiter(new Recruiter(DatabaseRecruiterPostgre.getLastId() + 1, "Steven", "steven.novianto@ui.ac.id", "123456789", DatabaseLocationPostgre.getLocationById(1)));
//        DatabaseRecruiterPostgre.insertRecruiter(new Recruiter(DatabaseRecruiterPostgre.getLastId() + 1, "Mama", "mama.mama@ui.ac.id", "987654321", DatabaseLocationPostgre.getLocationById(2)));
//        DatabaseRecruiterPostgre.insertRecruiter(new Recruiter(DatabaseRecruiterPostgre.getLastId() + 1, "Papa", "papa.papa@ui.ac.id", "5647382910", DatabaseLocationPostgre.getLocationById(3)));
//
//        DatabaseBonusPostgre.insertBonus(new Bonus(DatabaseBonusPostgre.getLastId() + 1, "Steven", 50, 50, true));
//        DatabaseBonusPostgre.insertBonus(new Bonus(DatabaseBonusPostgre.getLastId() + 1, "Steven123", 50, 500000000, true));
//        DatabaseBonusPostgre.insertBonus(new Bonus(DatabaseBonusPostgre.getLastId() + 1, "Mama", 50, 50, true));
//        DatabaseBonusPostgre.insertBonus(new Bonus(DatabaseBonusPostgre.getLastId() + 1, "Mama123", 50, 500000000, true));
//        DatabaseBonusPostgre.insertBonus(new Bonus(DatabaseBonusPostgre.getLastId() + 1, "Papa", 50, 50, true));
//        DatabaseBonusPostgre.insertBonus(new Bonus(DatabaseBonusPostgre.getLastId() + 1, "Papa123", 50, 500000000, true));
//
//
//        DatabaseJobPostgre.insertJob(new Job(DatabaseJobPostgre.getLastId() + 1, "Backend GOTO", DatabaseRecruiterPostgre.getRecruiterById(1), 10000, JobCategory.BackEnd.toString()));
//        DatabaseJobPostgre.insertJob(new Job(DatabaseJobPostgre.getLastId() + 1, "Frontend Tokopedia", DatabaseRecruiterPostgre.getRecruiterById(1), 20000, JobCategory.FrontEnd.toString()));
//        DatabaseJobPostgre.insertJob(new Job(DatabaseJobPostgre.getLastId() + 1, "UX Researcher Gojek", DatabaseRecruiterPostgre.getRecruiterById(2), 10000, JobCategory.UX.toString()));
//        DatabaseJobPostgre.insertJob(new Job(DatabaseJobPostgre.getLastId() + 1, "UI Designer Gojek", DatabaseRecruiterPostgre.getRecruiterById(3), 20000, JobCategory.UI.toString()));
//        DatabaseJobPostgre.insertJob(new Job(DatabaseJobPostgre.getLastId() + 1, "Frontend Shopee", DatabaseRecruiterPostgre.getRecruiterById(3), 10000, JobCategory.FrontEnd.toString()));
//        DatabaseJobPostgre.insertJob(new Job(DatabaseJobPostgre.getLastId() + 1, "Backend Shopee", DatabaseRecruiterPostgre.getRecruiterById(3), 20000, JobCategory.BackEnd.toString()));
        SpringApplication.run(Jwork.class, args);
    }
}