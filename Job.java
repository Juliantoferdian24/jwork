/**
 * Write a description of class Job here.
 *
 * @author Ferdian Julianto
 * @version 18.3.2021
 */
public class Job
{
    // instance variables
    private int id;
    private String name;
    private int fee;
    private JobCategory category;
    private Recruiter recruiter;
    
    /**
     * Constructor for objects of class Job
     * @param id merujuk pada id
     * @param name merujuk pada nama
     * @param recruiter merujuk pada recruiter
     * @param fee merujuk pada gaji
     * @param category merujuk pada kategori
     */
    public Job(int id, String name, Recruiter recruiter, int fee, JobCategory category)
    {
        this.id = id;
        this.recruiter = recruiter;
        this.name = name;
        this.fee = fee;
        this.category = category;
        // initialise instance variables
    }
    /**
     * @return id mengembalikan int id
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
     * @return fee mengembalikan int fee
     */
    public int getFee()
    {
        return fee;
    }
    /**
     * @return category mengembalikan String category
     */
    public JobCategory getCategory()
    {
        return category;
    }
    /**
     * @return recruiter mengembalikan Recruiter recruiter
     */
    public Recruiter getRecruiter()
    {
        return recruiter;
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
     * @param recruiter merujuk pada recruiter
     */
    public void setRecruiter(Recruiter recruiter)
    {
       this.recruiter = recruiter;
    }
    /**
     * @param fee merujuk pada fee
     */
    public void setFee(int fee)
    {
        this.fee = fee;
    }
    /**
     * @param category merujuk pada category
     */
    public void setCategory(JobCategory category)
    {
        this.category = category;
    }
    /**
     * Method untuk Print Data
     */
    @Override
    public String toString() {
        return "Id = " + getId() + "\nName = " + getName() + "\nRecruiter = " + getRecruiter() + "\nCity= "
                + getRecruiter().getLocation().getCity() + "\nFee = " + getFee() + "\nCategory = " + getCategory();

    }
    
}
