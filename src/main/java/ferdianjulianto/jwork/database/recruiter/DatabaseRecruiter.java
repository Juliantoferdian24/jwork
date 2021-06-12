package ferdianjulianto.jwork.database.recruiter;

import ferdianjulianto.jwork.exception.RecruiterNotFoundException;
import ferdianjulianto.jwork.model.Recruiter;

import java.util.ArrayList;

/**
 * Write a description of class DatabaseRecruiter here.
 *
 * @author Ferdian Julianto
 * @version 18.3.2021
 */
public class DatabaseRecruiter {
    private static final ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Method to show recruiter list from recruiter database
     *
     * @return RECRUITER_DATABASE array list that stores information of all Recruiter
     */
    public static ArrayList<Recruiter> getRecruiterDatabase() {
        return RECRUITER_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    /**
     * Method to show last id of Recruiter in Recruiter database
     *
     * @return last id of Recruiter in database
     */
    public static Recruiter getRecruiterById(int id) throws RecruiterNotFoundException {
        Recruiter temp;
        for (Recruiter recruiter : RECRUITER_DATABASE) {
            if (id == recruiter.getId()) {
                temp = recruiter;
                return temp;
            }
        }
        throw new RecruiterNotFoundException(id);
    }

    /**
     * Method to add recruiter into recruiter database
     *
     * @param recruiter passing parameter that stores object recruiter
     * @return boolean that show the succession of the method
     */
    public static boolean addRecruiter(Recruiter recruiter) {
        RECRUITER_DATABASE.add(recruiter);
        lastId = recruiter.getId();
        return true;
    }

    /**
     * Method to remove recruiter from recruiter database
     *
     * @param id passing parameter that stores recruiter id
     * @return boolean that show the succession of the method
     * @throws RecruiterNotFoundException
     */
    public static boolean removeRecruiter(int id) throws RecruiterNotFoundException {
        for (Recruiter recruiter : RECRUITER_DATABASE) {
            if (id == recruiter.getId()) {
                RECRUITER_DATABASE.remove(id);
                return true;
            }
        }
        throw new RecruiterNotFoundException(id);
    }
}