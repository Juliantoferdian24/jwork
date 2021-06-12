package ferdianjulianto.jwork.controller;

import ferdianjulianto.jwork.database.location.DatabaseLocationPostgre;
import ferdianjulianto.jwork.database.recruiter.DatabaseRecruiter;
import ferdianjulianto.jwork.database.recruiter.DatabaseRecruiterPostgre;
import ferdianjulianto.jwork.model.Location;
import ferdianjulianto.jwork.model.Recruiter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class RecruiterController will handle Request Method related to Recruiter
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
@RequestMapping("/recruiter")
@RestController
public class RecruiterController {

    /**
     * Method to shows all recruiter in the database
     *
     * @return all recruiter in database
     */
    @RequestMapping("")
    public ArrayList<Recruiter> getAllRecruiter() {
        return DatabaseRecruiterPostgre.getRecruiterDatabase();
    }

    /**
     * Method to get recruiter from id
     *
     * @param id variable used to identify recruiter.
     * @return single job recruiter
     */
    @RequestMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable int id) {
        Recruiter recruiter = null;
        recruiter = DatabaseRecruiterPostgre.getRecruiterById(id);

        return recruiter;
    }

    /**
     * Method to adds new Recruiter into database
     *
     * @param name        variable that stores name of the recruiter
     * @param email       variable that stores jobseeker email
     * @param phoneNumber variable that stores jobseeker phoneNumber
     * @param province    variable that stores jobseeker Location province
     * @param description variable that stores jobseeker's Location description
     * @param city        variable that stores jobseeker Location city
     * @return Recruiter Object
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Recruiter addRecruiter(@RequestParam(value = "name") String name,
                                  @RequestParam(value = "email") String email,
                                  @RequestParam(value = "phoneNumber") String phoneNumber,
                                  @RequestParam(value = "province") String province,
                                  @RequestParam(value = "description") String description,
                                  @RequestParam(value = "city") String city) {
        Recruiter recruiter = new Recruiter(DatabaseRecruiterPostgre.getLastId() + 1, name, email, phoneNumber, new Location(DatabaseLocationPostgre.getLastId() + 1, province, city, description));

        try {
            DatabaseRecruiterPostgre.insertRecruiter(recruiter);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return recruiter;
    }

}
