package ferdianjulianto.jwork.database.job;

import ferdianjulianto.jwork.database.recruiter.DatabaseRecruiterPostgre;
import ferdianjulianto.jwork.model.Job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static ferdianjulianto.jwork.database.DatabaseConnection.connection;

public class DatabaseJobPostgre {

    /**
     * Method for inserting job to database
     *
     * @param job object job to be input
     * @return object job if success
     */
    public static Boolean insertJob(Job job) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String name = job.getName();
            int fee = job.getFee();
            int recruiterId = job.getRecruiter().getId();
            String category = job.getCategory();
            String sql = "INSERT INTO job (name, recruiterId, fee, category) VALUES ('" + name + "','" + recruiterId + "','" + fee + "','" + category + "');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method for get Last job Id (not used)
     *
     * @return last id of job in database
     */
    public static int getLastId() {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        try {
            String sql = "SELECT id from job;";
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
     * Method to get all jobs in database
     *
     * @return array list of jobs object if success
     */
    public static ArrayList<Job> getJobDatabase() {
        Connection c = connection();
        PreparedStatement stmt;
        Job job;
        ArrayList<Job> jobs = new ArrayList<>();
        int id = 0;
        String name;
        int fee;
        int recruiterId;
        String category;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM job;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                fee = rs.getInt("fee");
                recruiterId = rs.getInt("recruiterId");
                category = rs.getString("category");
                job = new Job(id, name, DatabaseRecruiterPostgre.getRecruiterById(recruiterId), fee, category);
                jobs.add(job);
            }
            rs.close();
            stmt.close();
            c.close();
            if (id == 0) {
                return null;
            } else {
                return jobs;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method to get job object by id
     *
     * @param jobId string variable for job object
     * @return array list of job object if success
     */
    public static Job getJobById(int jobId) {
        Connection c = connection();
        PreparedStatement stmt;
        Job job;
        int id = 0;
        String name = null;
        int fee = 0;
        int recruiterId = 0;
        String category = null;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM job WHERE id = '" + jobId + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                fee = rs.getInt("fee");
                recruiterId = rs.getInt("recruiterId");
                category = rs.getString("category");
            }
            rs.close();
            stmt.close();
            c.close();
            if (id == 0) {
                return null;
            } else {
                job = new Job(id, name, DatabaseRecruiterPostgre.getRecruiterById(recruiterId), fee, category);
                return job;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method to get job object by id
     *
     * @param recruiterIdJob string variable for job object
     * @return string of job object if success
     */
    public static ArrayList<Job> getJobByRecruiter(int recruiterIdJob) {
        Connection c = connection();
        PreparedStatement stmt;
        Job job;
        ArrayList<Job> jobs = new ArrayList<>();
        int id = 0;
        String name;
        int fee;
        int recruiterId;
        String category;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM job WHERE recruiterId = '" + recruiterIdJob + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                fee = rs.getInt("fee");
                recruiterId = rs.getInt("recruiterId");
                category = rs.getString("category");
                job = new Job(id, name, DatabaseRecruiterPostgre.getRecruiterById(recruiterId), fee, category);
                jobs.add(job);
            }
            rs.close();
            stmt.close();
            c.close();
            if (id == 0) {
                return null;
            } else {
                return jobs;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method to get job object by category
     *
     * @param categoryJob string variable for job category
     * @return string of job object if success
     */
    public static ArrayList<Job> getJobByCategory(String categoryJob) {
        Connection c = connection();
        PreparedStatement stmt;
        Job job;
        ArrayList<Job> jobs = new ArrayList<>();
        int id = 0;
        String name;
        int fee;
        int recruiterId;
        String category;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM job WHERE id = '" + categoryJob + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                fee = rs.getInt("fee");
                recruiterId = rs.getInt("recruiterId");
                category = rs.getString("category");
                job = new Job(id, name, DatabaseRecruiterPostgre.getRecruiterById(recruiterId), fee, category);
                jobs.add(job);
            }
            rs.close();
            stmt.close();
            c.close();
            if (id == 0) {
                return null;
            } else {
                return jobs;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
