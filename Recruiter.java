/**
 * Write a description of class Recruiter here.
 *
 * @author Ferdian Julianto
 * @version 18.3.2021
 */
public class Recruiter
{
    // instance variables
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;

    /**
     * Constructor for objects of class Recruiter
     * @param id merujuk pada id
     * @param name merujuk pada nama
     * @param email merujuk pada email
     * @param phoneNumber merujuk pada nomorTelepon
     * @param location merujuk pada location
     */
    public Recruiter(int id, String name, String email, String phoneNumber, Location location )
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
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
     * @return phoneNumber mengembalikan String phoneNumber
     */
     public String getPhoneNumber()
    {
        return phoneNumber;
    }
    /**
     * @return location mengembalikan String location
     */
    public Location getLocation()
    {
        return location;
    }
    /**
     * @param id merujuk pada id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * @param email merujuk pada email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    /**
     * @param name merujuk pada name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * @param phoneNumber merujuk pada phoneNumber
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    /**
     * @param location merujuk pada location
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }
    /**
     * Method untuk Print Data
     */
    public void printData() {
        System.out.println(getName());
    }
}

