package ferdianjulianto.jwork.database.recruiter;

import ferdianjulianto.jwork.database.location.DatabaseLocationPostgre;
import ferdianjulianto.jwork.model.Jobseeker;
import ferdianjulianto.jwork.model.Recruiter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static ferdianjulianto.jwork.database.DatabaseConnection.connection;

public class DatabaseRecruiterPostgre {

    /**
     * Method to get all Recruiter in database
     *
     * @return array list of Recruiter object if success
     */
    public static ArrayList<Recruiter> getRecruiterDatabase() {
        Connection c = connection();
        PreparedStatement stmt;
        Recruiter recruiter;
        ArrayList<Recruiter> recruiters = new ArrayList<>();
        int id = 0;
        String name;
        String email;
        String phoneNumber;
        int locationId;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM recruiter;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                phoneNumber = rs.getString("phoneNumber");
                locationId = rs.getInt("locationId");
                recruiter = new Recruiter(id, name, email, phoneNumber, DatabaseLocationPostgre.getLocationById(locationId));
                recruiters.add(recruiter);
            }
            rs.close();
            stmt.close();
            c.close();
            if (id == 0) {
                return null;
            } else {
                return recruiters;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method for inserting recruiter to database
     *
     * @param recruiter object recruiter to be input
     * @return object recruiter if success
     */
    public static Recruiter insertRecruiter(Recruiter recruiter) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String name = recruiter.getName();
            String email = recruiter.getEmail();
            String phoneNumber = recruiter.getPhoneNumber();
            int locationId = recruiter.getLocation().getId();
            String sql = "INSERT INTO recruiter (name, email, phoneNumber, locationId) VALUES ('" + name + "','" + email + "','" + phoneNumber + "','" + locationId + "');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return recruiter;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method for get Last recruiter Id (not used)
     *
     * @return last id of recruiter in database
     */
    public static int getLastId() {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        try {
            String sql = "SELECT id from recruiter;";
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
     * Method for get recruiter from PostgreSQL using recruiter id
     *
     * @param id_recruiter int var for recruiter id
     * @return object recruiter if success
     */
    public static Recruiter getRecruiterById(int id_recruiter) {
        Connection c = connection();
        PreparedStatement stmt;
        Recruiter recruiter = null;
        int id = 0;
        String name = null;
        String email = null;
        String phoneNumber = null;
        int locationId = 0;
        try {
            String sql = "SELECT * FROM recruiter WHERE id = '" + id_recruiter + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                phoneNumber = rs.getString("phoneNumber");
                locationId = rs.getInt("locationId");
            }
            rs.close();
            stmt.close();
            c.close();
            recruiter = new Recruiter(id, name, email, phoneNumber, DatabaseLocationPostgre.getLocationById(locationId));
            return recruiter;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Method for remove recruiter using recruiter id
     *
     * @param id id of recruiter
     */
    public void removeCustomer(int id) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM recruiter WHERE id = " + id + ";";
            stmt = c.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
