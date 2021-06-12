
package ferdianjulianto.jwork.controller;

import ferdianjulianto.jwork.database.jobseeker.DatabaseJobseeker;
import ferdianjulianto.jwork.database.jobseeker.DatabaseJobseekerPostgre;
import ferdianjulianto.jwork.model.Jobseeker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class JobseekerController will handle Request Method related to Jobseeker
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
@RequestMapping("/jobseeker")
@CrossOrigin(origins = "*", allowedHeaders = "")
@RestController
public class JobseekerController {

    /**
     * Method to shows all jobseeker in the database
     *
     * @return all jobseeker in database
     */
    @RequestMapping("")
    public ArrayList<Jobseeker> getAllJobseeker() {
        return DatabaseJobseekerPostgre.getJobseekerDatabase();
    }

    /**
     * Method to get job from id
     *
     * @param id variable used to identify jobseeker.
     * @return single jobseeker object
     */
    @RequestMapping("/{id}")
    public Jobseeker getJobseekerById(@PathVariable int id) {
        return DatabaseJobseekerPostgre.getJobseekerById(id);
    }

    /**
     * Method to register new Jobseeker into database
     *
     * @param name     variable that stores name of the jobseeker
     * @param email    variable that stores jobseeker email
     * @param password variable that stores jobseeker password
     * @return Jobseeker Object
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Jobseeker registerJobseeker(@RequestParam(value = "name") String name,
                                       @RequestParam(value = "email") String email,
                                       @RequestParam(value = "password") String password) {
        String regexEmail = "^[a-zA-Z0-9&*_~]+([\\.{1}]?[a-z]+)+@[a-z0-9]+([\\.]{1}[a-z]+)\\S+(?!.*?\\.\\.)";
        Pattern patternEmail = Pattern.compile(regexEmail);
        Matcher matcherEmail = patternEmail.matcher(email);

        String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
        Pattern patternPassword = Pattern.compile(regexPassword);
        Matcher matcherPassword = patternPassword.matcher(password);

        if (matcherEmail.matches() && matcherPassword.matches()) {
            Jobseeker jobseeker = new Jobseeker(DatabaseJobseekerPostgre.getLastId() + 1, name, email, password);
            return DatabaseJobseekerPostgre.insertJobseeker(jobseeker);
        }
        return null;
    }

    /**
     * Method to login Jobseeker
     *
     * @param email    variable that stores jobseeker email
     * @param password variable that stores jobseeker password
     * @return Jobseeker Object
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Jobseeker loginJobseeker(@RequestParam(value = "email") String email,
                                    @RequestParam(value = "password") String password) {
        return (DatabaseJobseekerPostgre.getJobseekerLogin(email, password));
    }
}