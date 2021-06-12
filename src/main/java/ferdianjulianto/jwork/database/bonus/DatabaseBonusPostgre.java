package ferdianjulianto.jwork.database.bonus;

import ferdianjulianto.jwork.model.Bonus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static ferdianjulianto.jwork.database.DatabaseConnection.connection;

/**
 * Class DatabaseBonusPostgre contains all object of Bonus stored in PostgreSQL
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public class DatabaseBonusPostgre {
    /**
     * Method for inserting bonus to database
     *
     * @param bonus object customer to be input
     * @return object customer if success
     */
    public static Bonus insertBonus(Bonus bonus) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String referralCode = bonus.getReferralCode();
            int extraFee = bonus.getExtraFee();
            int minTotalFee = bonus.getMinTotalFee();
            boolean active = bonus.getActive();
            String sql = "INSERT INTO bonus (referralCode, extraFee, minTotalFee, active) VALUES ('" + referralCode + "','" + extraFee + "','" + minTotalFee + "','" + active + "');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return bonus;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method for get Last bonus Id
     *
     * @return last id of bonus in database
     */
    public static int getLastId() {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        try {
            String sql = "SELECT id from bonus;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            stmt.close();
            c.close();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * Method for fetching all database bonus
     *
     * @return Arraylist of object bonus if success
     */
    public static ArrayList<Bonus> getBonusDatabase() {
        ArrayList<Bonus> listBonus = new ArrayList<>();
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        String referralCode;
        int extraFee;
        int minTotalFee;
        boolean active;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM bonus;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                referralCode = rs.getString("referralCode");
                extraFee = rs.getInt("extraFee");
                minTotalFee = rs.getInt("minTotalFee");
                active = rs.getBoolean("active");
                listBonus.add(new Bonus(id, referralCode, extraFee, minTotalFee, active));
            }
            rs.close();
            stmt.close();
            c.close();
            if (id == 0) {
                return null;
            } else {
                return listBonus;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method for get bonus by referral code
     *
     * @param bonusCode String code bonus
     * @return object bonus if success
     */
    public static Bonus getBonusByRefferalCode(String bonusCode) {
        Connection c = connection();
        PreparedStatement stmt;
        Bonus bonus;
        int id = 0;
        String referralCode = null;
        int extraFee = 0;
        int minTotalFee = 0;
        boolean active = false;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM bonus WHERE referralCode = '" + bonusCode + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                referralCode = rs.getString("referralCode");
                extraFee = rs.getInt("extraFee");
                minTotalFee = rs.getInt("minTotalFee");
                active = rs.getBoolean("active");
            }
            rs.close();
            stmt.close();
            c.close();
            if (id == 0) {
                return null;
            } else {
                bonus = new Bonus(id, referralCode, extraFee, minTotalFee, active);
                return bonus;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}