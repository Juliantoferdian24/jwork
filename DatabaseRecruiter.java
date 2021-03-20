/**
 * Write a description of class DatabaseJob here.
 *
 * @author Ferdian Julianto
 * @version 18.3.2021
 */
public class DatabaseRecruiter {

    
    private String[] listRecruiter;

    public DatabaseRecruiter() {
        listRecruiter = new String[100];
    }
    /**
     * @param listRecruiter merujuk pada daftar perekrut
     */
    public DatabaseRecruiter(String[] listRecruiter) {
        this.listRecruiter = listRecruiter;
    }
    /**
     * Menambah perekrut
     * @param recruiter merujuk pada perekrut
     * @return false
     */
    public boolean addRecruiter(Recruiter recruiter) {
        return false;
    }
    /**
     * Menghapus perekrut
     * @param recruiter merujuk pada perekrut
     * @return false
     */
    public boolean removeRecruiter(Recruiter recruiter) {
        return false;
    }
    /**
     * Get perekrut
     * @return false
     */
    public Recruiter getRecruiter(){
        return null;
    }
    
    public String[] getListRecruiter(){
        return listRecruiter;
    }
}