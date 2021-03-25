public enum JobCategory {
    WebDeveloper("Web Developer"), FrontEnd("Front End"), BackEnd("Back End"), UI("UI"), UX("UX"), Devops("Devops"),
    DataScientist("Data Scientist"), DataAnalyst("Data Analyst");

    private String jobcategory;

    private JobCategory(String category) {
        this.jobcategory = category;

    }

    @Override
    public String toString() {
        return jobcategory;
    }

    public static void main(String[] args) {
        JobCategory category1 = JobCategory.WebDeveloper;
        System.out.println(category1);
        
        JobCategory category2 = JobCategory.FrontEnd;
        System.out.println(category2);
        
        JobCategory category3 = JobCategory.BackEnd;
        System.out.println(category3);
        
        JobCategory category4 = JobCategory.UI;
        System.out.println(category4);
        
        
        JobCategory category5 = JobCategory.UX;
        System.out.println(category5);
        
        JobCategory category6 = JobCategory.Devops;
        System.out.println(category6);
        
        JobCategory category7 = JobCategory.DataScientist;
        System.out.println(category7);
        
        JobCategory category8 = JobCategory.DataAnalyst;
        System.out.println(category8);

    }
}