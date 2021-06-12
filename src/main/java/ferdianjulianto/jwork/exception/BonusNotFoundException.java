package ferdianjulianto.jwork.exception;

/**
 * Class BonusNotFoundException is class that serves as bonus error handling
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public class BonusNotFoundException extends Exception {
    private final int bonus_error;

    /**
     * Constructor for bonus error handling
     *
     * @param bonus_input variable for passing the information of id bonus
     */
    public BonusNotFoundException(int bonus_input) {
        super("Bonus ID: ");
        bonus_error = bonus_input;
    }

    /**
     * Method to print the information of the error handling
     */
    public String getMessage() {
        return super.getMessage() + bonus_error + " not found";
    }
}