package ferdianjulianto.jwork.database.jobseeker;

import ferdianjulianto.jwork.exception.EmailAlreadyExistsException;
import ferdianjulianto.jwork.exception.JobSeekerNotFoundException;
import ferdianjulianto.jwork.model.Jobseeker;

import java.util.ArrayList;

/**
 * Class DatabaseJobseeker contains all object of Jobseeker stored in ArrayList Jobseeker
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public class DatabaseJobseeker {

    private static final ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<Jobseeker>();

    private static int lastId = 0;

    public DatabaseJobseeker() {
    }

    /**
     * Method to show jobseeker list from Jobseeker database
     *
     * @return JOBSEEKER_DATABASE array list that stores information of all Jobseeker
     */
    public static ArrayList<Jobseeker> getDatabaseJobseeker() {
        return JOBSEEKER_DATABASE;
    }

    /**
     * Method to show last id of Jobseeker in Jobseeker database
     *
     * @return last id of Jobseeker in database
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * Method to show jobseeker by id in jobseeker database
     *
     * @param id passing parameter that stores jobseeker id
     * @return jobseeker object
     */
    public static Jobseeker getJobseekerById(int id) throws JobSeekerNotFoundException {
        for (Jobseeker jobseeker : JOBSEEKER_DATABASE) {
            if (id == jobseeker.getId()) {
                return jobseeker;
            }
        }
        throw new JobSeekerNotFoundException(id);
    }

    /**
     * Method to add jobseeker into jobseeker database
     *
     * @param jobseeker passing parameter that stores object jobseeker
     * @return boolean that show the succession of the method
     */
    public static boolean addJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException {
        for (Jobseeker jobseekere : JOBSEEKER_DATABASE) {
            if (jobseekere.getEmail() == jobseeker.getEmail()) {
                throw new EmailAlreadyExistsException(jobseeker);
            }
        }
        JOBSEEKER_DATABASE.add(jobseeker);
        lastId = jobseeker.getId();
        return true;
    }

    /**
     * Method to remove jobseeker from jobseeker database
     *
     * @param id passing parameter that stores jobseeker id
     * @return boolean that show the succession of the method
     */
    public static boolean removeJobseeker(int id) throws JobSeekerNotFoundException {
        for (Jobseeker jobseeker : JOBSEEKER_DATABASE) {
            if (jobseeker.getId() == id) {
                JOBSEEKER_DATABASE.remove(jobseeker.getId());
                return true;
            }
        }
        throw new JobSeekerNotFoundException(id);
    }

    /**
     * Method to get Jobseeker Login
     *
     * @param email    variable that stores jobseeker email
     * @param password variable that stores jobseeker password
     * @return Jobseeker Object
     */
    public static Jobseeker getJobseekerLogin(String email, String password) {
        for (Jobseeker jobseeker : JOBSEEKER_DATABASE) {
            if (jobseeker.getEmail().equals(email) && jobseeker.getPassword().equals(password)) {
                return jobseeker;
            }
        }
        return null;
    }
}