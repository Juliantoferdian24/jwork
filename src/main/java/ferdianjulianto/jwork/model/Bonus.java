package ferdianjulianto.jwork.model;

/**
 * Class Bonus is class that stores information for every Bonus object
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public class Bonus {
    private int id;
    private String referralCode;
    private int extraFee;
    private int minTotalFee;
    private boolean active;

    /**
     * Constructor for objects of class Bonus
     *
     * @param id           variable used to identify Bonus.
     * @param referralCode variable used for the referral code.
     * @param extraFee     variable to store information about extra fee amount
     * @param minTotalFee  variable to store the minimum fee of job needed to activate bonus
     * @param active       variable to store information of bonus status
     */
    public Bonus(int id, String referralCode, int extraFee, int minTotalFee, boolean active) {
        this.id = id;
        this.referralCode = referralCode;
        this.extraFee = extraFee;
        this.minTotalFee = minTotalFee;
        this.active = active;
    }

    /**
     * Method as getter to get id of the bonus.
     *
     * @return id variable used to identify Bonus.
     */
    public int getId() {
        return id;
    }

    /**
     * Method as getter to get referral code of the bonus.
     *
     * @return referralCode variable used for the referral code.
     */
    public String getReferralCode() {
        return referralCode;
    }

    /**
     * Method as getter to get information about extra fee amount
     *
     * @return extraFee variable to store information about extra fee amount
     */
    public int getExtraFee() {
        return extraFee;
    }

    /**
     * Method as getter to get information about minimum fee of the job
     *
     * @return minTotalFee variable to store the minimum fee of job needed to activate bonus
     */
    public int getMinTotalFee() {
        return minTotalFee;
    }

    /**
     * Method as getter to get information about bonus status
     *
     * @return active variable to store information of bonus status
     */
    public boolean getActive() {
        return active;
    }

    /**
     * Method as setter to set id of the bonus.
     *
     * @param id variable used to identify Bonus.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method as setter to set referral code of the bonus.
     *
     * @param referralCode variable used for the referral code.
     */
    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    /**
     * Method as setter to set extra fee of the bonus.
     *
     * @param extraFee variable to store information about extra fee amount
     */
    public void setExtraFee(int extraFee) {
        this.extraFee = extraFee;
    }

    /**
     * Method as setter to set minimum fee of job needed to activate bonus
     *
     * @param minTotalFee variable to store the minimum fee of job needed to activate bonus
     */
    public void setMinTotalFee(int minTotalFee) {
        this.minTotalFee = minTotalFee;
    }

    /**
     * Method as setter to set bonus status
     *
     * @param active variable to store information of bonus status
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Method for printing data
     */
    @Override
    public String toString() {
        return "Id = " + getId() + "\nReferral Code = " + getReferralCode() + "\nExtra Fee = " + getExtraFee()
                + "\nMin Total Fee= " + getMinTotalFee() + "\nActive Status =  " + getActive();
    }

}
