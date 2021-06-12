package ferdianjulianto.jwork.exception;

/**
 * Class JobSeekerNotFoundException is class that serves as jobseeker error handling
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public class JobSeekerNotFoundException extends Exception {
    private final int jobseeker_error;

    /**
     * Constructor for jobseeker error handling
     *
     * @param jobseeker_input variable for passing the information of id jobseeker
     */
    public JobSeekerNotFoundException(int jobseeker_input) {
        super("Jobseeker ID: ");
        this.jobseeker_error = jobseeker_input;
    }

    /**
     * Method to print the information of the error handling
     */
    public String getMessage() {
        return super.getMessage() + jobseeker_error + " not found";
    }
}