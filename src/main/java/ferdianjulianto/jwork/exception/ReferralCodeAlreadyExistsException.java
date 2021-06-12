package ferdianjulianto.jwork.exception;

import ferdianjulianto.jwork.model.Bonus;

/**
 * Class BonusNotFoundException is class that serves as referral code error handling
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public class ReferralCodeAlreadyExistsException extends Exception {

    private final Bonus referral_error;

    /**
     * Constructor for referral code error handling
     *
     * @param referral_input variable for passing the information of id referral code
     */
    public ReferralCodeAlreadyExistsException(Bonus referral_input) {
        super("Referral Code: ");
        this.referral_error = referral_input;
    }

    /**
     * Method to print the information of the error handling
     */
    public String getMessage() {
        return super.getMessage() + referral_error.getReferralCode() + " already exists.";
    }
}