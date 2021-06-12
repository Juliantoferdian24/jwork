package ferdianjulianto.jwork.exception;

/**
 * Class JobNotFoundException is class that serves as job error handling
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public class JobNotFoundException extends Exception{

    private final int job_error;

    /**
     * Constructor for job error handling
     *
     * @param job_input variable for passing the information of id job
     */
    public JobNotFoundException(int job_input){
        super("Job ID: ");
        job_error = job_input;
    }
    
    /**
     * Method to print the information of the error handling
     */
    public String getMessage(){
        return super.getMessage() + job_error + " not found";
    }
}