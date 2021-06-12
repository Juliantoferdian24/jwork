package ferdianjulianto.jwork.exception;

/**
 * Class RecruiterNotFoundException is class that serves as recruiter error handling
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public class RecruiterNotFoundException extends Exception{
    private final int recruiter_error;

    /**
     * Constructor for recruiter error handling
     *
     * @param recruiter_input variable for passing the information of id recruiter
     */
    public RecruiterNotFoundException(int recruiter_input)
    {
        super("Recruiter Id: ");
        recruiter_error = recruiter_input;
    }

    /**
     * Method to print the information of the error handling
     */
    public String getMessage()
    {
        return super.getMessage() + recruiter_error + " Not Found";
    }
}