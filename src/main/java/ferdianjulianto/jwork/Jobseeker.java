package ferdianjulianto.jwork;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Jobseeker here.
 *
 * @author Ferdian Julianto
 * @version 18.3.2021
 */
public class Jobseeker {
    // instance variables
    private int id;
    private String name;
    private String email;
    private String password;
    public Calendar joinDate;

    /**
     * Constructor for objects of class Recruiter
     *
     * @param id       merujuk pada id
     * @param name     merujuk pada nama
     * @param email    merujuk pada email
     * @param password merujuk pada password
     * @param joinDate merujuk pada joinDate
     */
    public Jobseeker(int id, String name, String email, String password, Calendar joinDate) {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = joinDate;
    }

    public Jobseeker(int id, String name, String email, String password, int year, int month, int dayOfMonth) {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = new GregorianCalendar(year, month - 1, dayOfMonth);
    }

    public Jobseeker(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
    }

    /**
     * @return id mengembalikan integer id
     */
    public int getId() {
        return id;
    }

    /**
     * @return name mengembalikan String name
     */
    public String getName() {
        return name;
    }

    /**
     * @return email mengembalikan String email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return password mengembalikan String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return joinDate mengembalikan String joinDate
     */
    public Calendar getJoinDate() {
        return joinDate;
    }

    /**
     * @param id merujuk pada id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name merujuk pada name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param email merujuk pada email
     */
    public void setEmail(String email) {
        String regex = "^[a-zA-Z0-9&*_~]+([\\.{1}]?[a-z]+)+@[a-z0-9]+([\\.]{1}[a-z]+)\\S+(?!.*?\\.\\.)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            this.email = email;
        } else {
            this.email = "Invalid Email";
        }
    }

    /**
     * @param password merujuk pada password
     */
    public void setPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
        ;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            this.password = password;
        } else {
            this.password = "Invalid Password";
        }
    }

    /**
     * @param joinDate merujuk pada joinDate
     */
    public void setJoinDate(Calendar joinDate) {
        this.joinDate = joinDate;
    }

    public void setJoinDate(int year, int month, int dayOfMonth) {
        this.joinDate = new GregorianCalendar(year, month - 1, dayOfMonth);
    }

    @Override
    public String toString() {
        if (this.joinDate == null) {
            return "Id = " + getId() + "\nNama = " + getName() + "\nEmail = " + getEmail() + "\nPassword = "
                    + getPassword() + "\n";
        } else {
            SimpleDateFormat formattedDate = new SimpleDateFormat("dd-MMMM-yyyy");
            String date = formattedDate.format(getJoinDate().getTime());
            return "Id = " + getId() + "\nNama = " + getName() + "\nEmail = " + getEmail() + "\nPassword = "
                    + getPassword() + "\nJoin Date = " + date + "\n";
        }
    }
}
