/**
 * Write a description of class Jobseeker here.
 *
 * @author Ferdian Julianto
 * @version 18.3.2021
 */
public class Jobseeker
{
    // instance variables
    private int id;
    private String name;
    private String email;
    private String password;
    private String joinDate;

    /**
     * Constructor for objects of class Recruiter
     * @param id merujuk pada id
     * @param name merujuk pada nama
     * @param email merujuk pada email
     * @param password merujuk pada password
     * @param joinDate merujuk pada joinDate
     */
    public Jobseeker(int id, String name, String email, String password, String joinDate)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }
    /**
     * @return id mengembalikan integer id
     */
    public int getId()
    {
        return id;
    }
    /**
     * @return name mengembalikan String name
     */
    public String getName()
    {
        return name;
    }
    /**
     * @return email mengembalikan String email
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * @return password mengembalikan String password
     */
    public String getPassword()
    {
        return password;
    }
    /**
     * @return joinDate mengembalikan String joinDate
     */
     public String getJoinDate()
    {
        return joinDate;
    }
    /**
     * @param id merujuk pada id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * @param name merujuk pada name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * @param email merujuk pada email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    /**
     * @param password merujuk pada password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    /**
     * @param joinDate merujuk pada joinDate
     */
    public void setJoinDate(String joinDate)
    {
        this.joinDate = joinDate;
    }
    /**
     * Method untuk Print Data
     */
    public void printData() {
        System.out.println(getName());
    }
}
