/**
 * Write a description of class location here.
 *
 * @author Ferdian Julianto
 * @version 18.3.2021
 */
public class Location
{
    // Pembuatan Class Location
    private String province;
    private String city;
    private String description;
    /**
     * Constructor for objects of class Location
     * @param province merujuk pada provinsi
     * @param city merujuk pada kota
     * @param description merujuk pada deskripsi kota
     */
    public Location(String province, String city, String description)
    {
        this.province = province;
        this.city = city;
        this.description = description;
    }

    /**
     * @return province mengembalikan String Provinsi
     */
    public String getProvince()
    {
        return province;
    }
    /**
     * @return city mengembalikan String kota
     */
    public String getCity()
    {
        return city;
    }
    /**
     * @return description mengembalikan String deskripsi
     */
    public String getDescription()
    {
        return description;
    }
    /**
     * @param province merujuk pada provinsi
     */
    public void setProvince(String province)
    {
        this.province = province;
    }
    /**
     * @param province merujuk pada kota
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    /**
     * @param description merujuk pada deskripsi
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    /**
     * Method untuk Print Data
     */
    public void printData()
    {
        System.out.println(getProvince());
    }
}
