package ferdianjulianto.jwork.database.job;

import ferdianjulianto.jwork.exception.JobNotFoundException;
import ferdianjulianto.jwork.model.Job;
import ferdianjulianto.jwork.util.JobCategory;

import java.util.ArrayList;

/**
 * Write a description of class DatabaseJob here.
 *
 * @author Ferdian Julianto
 * @version 18.3.2021
 */
public class DatabaseJob {

    private static final ArrayList<Job> JOB_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Method to show job list from job database
     *
     * @return BONUS_DATABASE array list that stores information of all Job
     */
    public static ArrayList<Job> getJobDatabase() {
        return JOB_DATABASE;
    }

    /**
     * Method to show last id of Job in Job database
     *
     * @return last id of Job in database
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * Method to show job by id in job database
     *
     * @param id passing parameter that stores job id
     * @return job object
     * @throws JobNotFoundException
     */
    public static Job getJobById(int id) throws JobNotFoundException {
        Job result;
        for (Job element : JOB_DATABASE) {
            if (element.getId() == id) {
                result = element;
                return result;
            }
        }
        throw new JobNotFoundException(id);
    }

    /**
     * Method to show Job by jobseeker
     *
     * @param recruiterId id of the recruiter
     * @return Job Object
     */
    public static ArrayList<Job> getJobByRecruiter(int recruiterId) {
        ArrayList<Job> result = null;

        for (Job element : JOB_DATABASE) {
            if (element.getRecruiter().getId() == recruiterId) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(element);
            }
        }
        return result;
    }

    /**
     * Method to show Job by Category
     *
     * @param category variable that stores Jobcategory
     * @return Job list
     */
    public static ArrayList<Job> getJobByCategory(JobCategory category) {
        ArrayList<Job> temp = new ArrayList<Job>();
        for (Job job : JOB_DATABASE) {
            if (category.toString().equals(job.getCategory())) {
                temp.add(job);
            }
        }
        return temp;
    }

    /**
     * Method to add a new Job
     *
     * @param job
     * @return boolean value whether the Job addition is successful or not
     */
    public static boolean addJob(Job job) {
        JOB_DATABASE.add(job);
        lastId = job.getId();
        return true;
    }

    /**
     * Method to remove job from job database
     *
     * @param id passing parameter that stores job id
     * @return boolean that show the succession of the method
     * @throws JobNotFoundException
     */
    public static boolean removeJob(int id) throws JobNotFoundException {
        for (Job job : JOB_DATABASE) {
            if (job.getId() == id) {
                JOB_DATABASE.remove(job);
                return true;
            }
        }
        throw new JobNotFoundException(id);
    }
    // Access method to fetch a specific existing Job
}