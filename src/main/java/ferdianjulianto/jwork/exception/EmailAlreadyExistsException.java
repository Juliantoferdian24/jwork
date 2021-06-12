package ferdianjulianto.jwork.exception;

import ferdianjulianto.jwork.model.Jobseeker;

/**
 * Class EmailAlreadyExistsException is class that serves as Email error handling
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public class EmailAlreadyExistsException extends Exception {

    private final Jobseeker jobseeker_error;

    /**
     * Constructor for email jobseeker error handling, to check if email already existed or not
     *
     * @param jobseeker_input parameter for passing object jobseeker
     */
    public EmailAlreadyExistsException(Jobseeker jobseeker_input) {
        super("Jobseeker Email: ");
        this.jobseeker_error = jobseeker_input;
    }

    /**
     * Method to print the information of the error handling
     */
    @Override
    public String getMessage() {
        return super.getMessage() + jobseeker_error.getEmail() + " already exists.";
    }
}