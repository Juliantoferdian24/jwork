package ferdianjulianto.jwork.controller;

import ferdianjulianto.jwork.database.job.DatabaseJobPostgre;
import ferdianjulianto.jwork.database.recruiter.DatabaseRecruiterPostgre;
import ferdianjulianto.jwork.model.Job;
import ferdianjulianto.jwork.util.JobCategory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class JobController will handle Request Method related to Job
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
@RequestMapping("/job")
@RestController
public class JobController {

    /**
     * Method to shows all job in the database
     *
     * @return all job in database
     */
    @RequestMapping("")
    public ArrayList<Job> getAllJob() {
        ArrayList<Job> job;

        job = DatabaseJobPostgre.getJobDatabase();
        return job;
    }

    /**
     * Method to get job from id
     *
     * @param id variable used to identify job.
     * @return single job object
     */
    @RequestMapping("/{id}")
    public Job getJobById(@PathVariable int id) {
        Job job;
        job = DatabaseJobPostgre.getJobById(id);
        return job;
    }

    /**
     * Method to get job from recruiter
     *
     * @param recruiterId variable used to identify Job
     * @return single job object
     */
    @RequestMapping("/recruiter/{recruiterId}")
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId) {
        ArrayList<Job> job;
        job = DatabaseJobPostgre.getJobByRecruiter(recruiterId);

        return job;
    }

    /**
     * Method to get job from category
     *
     * @param category variable used to identify Job category
     * @return single job object
     */
    @RequestMapping("/category/{category}")
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category) {
        ArrayList<Job> job;
        job = DatabaseJobPostgre.getJobByCategory(category.toString());
        return job;
    }

    /**
     * Method to adds new job into database
     *
     * @param name        variable that stores name of the job
     * @param fee         variable that stores fee of the job
     * @param category    variable that stores category of the job
     * @param recruiterId variable used to identify recruiter.
     * @return Job Object
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value = "name") String name,
                      @RequestParam(value = "fee") int fee,
                      @RequestParam(value = "category") String category,
                      @RequestParam(value = "recruiterId") int recruiterId) {
        Job job = null;
        job = new Job(DatabaseJobPostgre.getLastId() + 1, name, DatabaseRecruiterPostgre.getRecruiterById(recruiterId), fee, JobCategory.valueOf(category).toString());
        boolean status = DatabaseJobPostgre.insertJob(job);
        if (status) {
            return job;
        } else {
            return null;
        }
    }

}
