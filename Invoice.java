/**
 * Write a description of class Invoice here.
 *
 * @author Ferdian Julianto
 * @version 18.3.2021
 */
public class Invoice
{
    // instance variables
    private int id;
    private int idJob;
    private String date;
    private int totalFee;
    private Jobseeker jobseeker;

    /**
     * Constructor for objects of class Recruiter
     * @param id merujuk pada id
     * @param idJob merujuk pada idJob
     * @param date merujuk pada tanggal
     * @param totalFee merujuk pada total gaji
     * @param jobseeker merujuk pada jobseeker
     */
    public Invoice(int id, int idJob, String date, int totalFee, Jobseeker jobseeker){
        this.id = id;
        this.idJob = idJob;
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
    }
    /**
     * @return id mengembalikan integer id
     */
    public int getId(){
        return id;
    }
    /**
     * @return idJob mengembalikan integer idJob
     */
    public int getIdJob(){
        return idJob;
    }
    /**
     * @return date mengembalikan String date
     */
    public String getDate(){
        return date;
    }
    /**
     * @return totalFee mengembalikan int totalFee
     */
    public int getTotalFee(){
        return totalFee;
    }
    /**
     * @return jobseeker mengembalikan Jobseeker jobseeker
     */
    public Jobseeker getJobseeker() {
        return jobseeker;
    }
    /**
     * @param id merujuk pada id
     */
    public void setId(int id){
        this.id = id;
    }
    /**
     * @param idJobs merujuk pada idJobs
     */
    public void setIdJobs(int idJobs){
        this.idJob = idJobs;
    }
    /**
     * @param date merujuk pada date
     */
    public void setDate(String date){
        this.date = date;
    }
    /**
     * @param totalFee merujuk pada totalFee
     */
    public void setTotalFee(int totalFee){
        this.totalFee = totalFee;
    }
    /**
     * @param totalFee merujuk pada jobseeker
     */
    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }
    /**
     * Method untuk Print Data
     */
    public void printData(){
        System.out.println(getTotalFee());
    }
}
