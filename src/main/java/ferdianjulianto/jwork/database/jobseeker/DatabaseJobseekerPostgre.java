package ferdianjulianto.jwork.database.jobseeker;

import ferdianjulianto.jwork.database.recruiter.DatabaseRecruiterPostgre;
import ferdianjulianto.jwork.model.Job;
import ferdianjulianto.jwork.model.Jobseeker;

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

/**
 * Class DatabaseJobseekerPostgre contains all object of Jobseeker stored in PostgreSQL
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public class DatabaseJobseekerPostgre {

    /**
     * Method to get all Jobseeker in database
     *
     * @return array list of Jobseeker object if success
     */
    public static ArrayList<Jobseeker> getJobseekerDatabase() {
        Connection c = connection();
        PreparedStatement stmt;
        Jobseeker jobseeker;
        ArrayList<Jobseeker> jobsekeers = new ArrayList<>();
        int id = 0;
        String name;
        String email;
        String password;
        Date joindate;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM jobseeker;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
                jobseeker = new Jobseeker(id, name, email, password);
                jobsekeers.add(jobseeker);
            }
            rs.close();
            stmt.close();
            c.close();
            if (id == 0) {
                return null;
            } else {
                return jobsekeers;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method for inserting jobseeker to database
     *
     * @param jobseeker object customer to be input
     * @return object customer if success
     */
    public static Jobseeker insertJobseeker(Jobseeker jobseeker) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String name = jobseeker.getName();
            String email = jobseeker.getEmail();
            String password = jobseeker.getPassword();

            Date date = new Date();

            String sql = "INSERT INTO jobseeker (name, email, password, joindate) VALUES ('" + name + "','" + email + "','" + password + "','" + date + "');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return jobseeker;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method for get Last jobseeker Id
     *
     * @return last id of jobseeker in database
     */
    public static int getLastId() {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        try {
            String sql = "SELECT id from jobseeker;";
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
     * Method for get jobseeker by jobseekerId
     *
     * @param jobseekerId String id jobseeker
     * @return object jobseeker if success
     */
    public static Jobseeker getJobseekerById(int jobseekerId) {
        Connection c = connection();
        PreparedStatement stmt;
        Jobseeker jobseeker;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        String date;
        Calendar cal = null;
        try {
            String sql = "SELECT * FROM jobseeker WHERE id = '" + jobseekerId + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
                date = rs.getString("joindate");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                cal = Calendar.getInstance();
                cal.setTime(df.parse(date));
            }
            rs.close();
            stmt.close();
            c.close();
            jobseeker = new Jobseeker(id, name, email, password, cal);
            return jobseeker;
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method to remove jobseeker from database
     *
     * @param id variable that stores id of customer
     * @return boolean that show the succession of the method
     */
    public void removeJobseeker(int id) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM jobseeker WHERE id = " + id + ";";
            stmt = c.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to remove jobseeker from database
     *
     * @param emailParam    variable that stores email of jobseeker
     * @param passwordParam variable that stores password of jobseeker
     * @return boolean that show the succession of the method
     */
    public static Jobseeker getJobseekerLogin(String emailParam, String passwordParam) {
        Connection c = connection();
        PreparedStatement stmt;
        Jobseeker jobseeker;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        String date;
        Calendar cal = null;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM jobseeker WHERE email = '" + emailParam + "' AND password = '" + passwordParam + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
                date = rs.getString("joindate");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                cal = Calendar.getInstance();
                cal.setTime(df.parse(date));
            }
            rs.close();
            stmt.close();
            c.close();
            //Check if response is null
            if (id == 0) {
                return null;
            } else {
                jobseeker = new Jobseeker(id, name, email, password, cal);
                return jobseeker;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}