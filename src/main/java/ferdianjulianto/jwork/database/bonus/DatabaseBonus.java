package ferdianjulianto.jwork.database.bonus;

import ferdianjulianto.jwork.model.Bonus;
import ferdianjulianto.jwork.exception.BonusNotFoundException;
import ferdianjulianto.jwork.exception.ReferralCodeAlreadyExistsException;

import java.util.ArrayList;

/**
 * Class DatabaseBonus contains all object of Bonus stored in ArrayList Bonus
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public class DatabaseBonus {
    private static ArrayList<Bonus> BONUS_DATABASE = new ArrayList<Bonus>();
    private static int lastId = 0;

    /**
     * Method to show bonus list from bonus database
     *
     * @return BONUS_DATABASE array list that stores information of all Bonus
     */
    public static ArrayList<Bonus> getBonusDatabase() {
        return BONUS_DATABASE;
    }

    /**
     * Method to show last id of Bonus in Bonus database
     *
     * @return last id of Bonus in database
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * Method to show bonus by id in bonus database
     *
     * @param id passing parameter that stores bonus id
     * @return bonus object
     * @throws BonusNotFoundException
     */
    public static Bonus getBonusById(int id) throws BonusNotFoundException {
        Bonus x;
        for (Bonus bonus : BONUS_DATABASE) {
            if (id == bonus.getId()) {
                x = bonus;
                return x;
            }
        }
        throw new BonusNotFoundException(id);
    }

    /**
     * Method to show bonus by code in bonus database
     *
     * @param refferalCode passing parameter that stores bonus code
     * @return bonus object
     */
    public static Bonus getBonusByRefferalCode(String refferalCode) {
        Bonus x = null;
        for (Bonus bonus : BONUS_DATABASE) {
            if (refferalCode.equals(bonus.getReferralCode())) {
                x = bonus;
            }
        }
        return x;
    }

    /**
     * Method to add bonus into bonus database
     *
     * @param bonus passing parameter that stores object bonus
     * @return boolean that show the succession of the method
     */
    public static boolean addBonus(Bonus bonus) throws ReferralCodeAlreadyExistsException {
        for (Bonus element : BONUS_DATABASE) {
            if (element.getReferralCode().equals(bonus.getReferralCode())) {
                throw new ReferralCodeAlreadyExistsException(bonus);
            }
        }
        BONUS_DATABASE.add(bonus);
        lastId = bonus.getId();
        return true;
    }

    /**
     * Method to activate bonus in bonus database
     *
     * @param id passing parameter that stores bonus id
     * @return boolean that show the succession of the method
     */
    public static boolean activateBonus(int id) {
        boolean x = false;
        for (Bonus bonus : BONUS_DATABASE) {
            if (id == bonus.getId()) {
                bonus.setActive(true);
                x = true;
            }
        }
        return x;
    }

    /**
     * Method to deactivate bonus from bonus database
     *
     * @param id passing parameter that stores bonus id
     * @return boolean that show the succession of the method
     */
    public static boolean deactivateBonus(int id) {
        boolean x = false;
        for (Bonus bonus : BONUS_DATABASE) {
            if (id == bonus.getId()) {
                bonus.setActive(false);
                x = true;
            }
        }
        return x;
    }

    /**
     * Method to remove bonus from bonus database
     *
     * @param id passing parameter that stores bonus id
     * @return boolean that show the succession of the method
     */
    public static boolean removeBonus(int id) throws BonusNotFoundException {
        for (Bonus bonus : BONUS_DATABASE) {
            if (bonus.getId() == id) {
                BONUS_DATABASE.remove(bonus);
                return true;
            }
        }
        throw new BonusNotFoundException(id);
    }
}
