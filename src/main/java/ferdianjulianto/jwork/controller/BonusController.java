package ferdianjulianto.jwork.controller;

import ferdianjulianto.jwork.database.bonus.DatabaseBonusPostgre;
import ferdianjulianto.jwork.model.Bonus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class BonusController will handle Request Method related to Bonus
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
@RequestMapping("/bonus")
@RestController
public class BonusController {
    /**
     * Method to shows all promo in the database
     *
     * @return all bonus in database
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Bonus> getAllBonus() {
        return (DatabaseBonusPostgre.getBonusDatabase());
    }

    /**
     * Method to get bonus from referral code
     *
     * @param referralCode variable used for the referral code.
     * @return single bonus object
     */
    @RequestMapping(value = "/{referralCode}", method = RequestMethod.GET)
    public Bonus getBonusByReferralCode(
            @PathVariable String referralCode) {
        return (DatabaseBonusPostgre.getBonusByRefferalCode(referralCode));
    }

    /**
     * Method to adds new invoice into database with E-wallet Payment type
     *
     * @param referralCode variable used for the referral code.
     * @param extraFee     variable to store information about extra fee amount
     * @param minTotalFee  variable to store the minimum fee of job needed to activate bonus
     * @param active       variable to store information of bonus status
     * @return object bonus that was added to database
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Bonus addBonus(
            @RequestParam(value = "referralCode") String referralCode,
            @RequestParam(value = "extraFee") int extraFee,
            @RequestParam(value = "minTotalFee") int minTotalFee,
            @RequestParam(value = "active") boolean active

    ) {
        Bonus bonus = new Bonus(DatabaseBonusPostgre.getLastId() + 1, referralCode, extraFee, minTotalFee, active);
        DatabaseBonusPostgre.insertBonus(bonus);
        return bonus;
    }
}
