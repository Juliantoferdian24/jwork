package ferdianjulianto.jwork;

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

    private String jobcategory;

    private JobCategory(String category) {
        this.jobcategory = category;
    }

    @Override
    public String toString() {
        return jobcategory;
    }

}