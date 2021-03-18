/**
 * Write a description of class DatabaseJob here.
 *
 * @author Ferdian Julianto
 * @version 18.3.2021
 */
public class DatabaseJob {
    
    private String[] listJob;
    
    public DatabaseJob(){
       listJob = new String[100];
    }
    
    /**
     * @param listJob merujuk pada daftar pekerjaan
     */
    public DatabaseJob(String[] listJob){
        this.listJob = listJob;
    }
    /**
     * Menambah pekerjaan
     * @param job merujuk pada pekerjaan
     * @return false
     */
    public boolean addJob(Job job){
        return false;
    }
    /**
     * Menghapus pekerjaan
     * @param job merujuk pada pekerjaan
     * @return false
     */
    public boolean remove(Job job){
        return false;
    }
    /**
     * get pekerjaan
     * @param job merujuk pada pekerjaan
     * @return null
     */
    public Job getJob(){
        return null;
    }
    
    public String[] getListJob(){
        return listJob;
    }
}
