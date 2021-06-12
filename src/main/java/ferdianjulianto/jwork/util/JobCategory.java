package ferdianjulianto.jwork.util;

/**
 * JobCategory yang bisa digunakan
 */
public enum JobCategory {
    WebDeveloper("Web Developer"),
    FrontEnd("Front End"),
    BackEnd("Back End"),
    UI("UI"),
    UX("UX"),
    Devops("Devops"),
    DataScientist("Data Scientist"),
    DataAnalyst("Data Analyst");

    private final String jobcategory;

    /**
     * Constructor for JobCategory
     *
     * @param category variable used to store Job Category
     */
    JobCategory(String category) {
        this.jobcategory = category;
    }

    /**
     * Method for printing data
     */
    @Override
    public String toString() {
        return jobcategory;
    }

}