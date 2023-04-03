
/**
 * Write a description of class Employee here.
 */
public class Employee extends Card {
    // instance variables - replace the example below with your own
    private int idNo;
    private String name;
    private int luxRating;
    private int credits;
    private int journeyPts;
    private int employeeId;
    private String jobDesc;
    public static int nextEmployeeIdNo = 2000;
    
    /**
     * Constructor for objects of class Employee
     */
    public Employee(String nm, String jobD) {
        // initialise instance variables
        super(nm,10);
        this.employeeId = nextEmployeeIdNo;
        this.jobDesc = jobD;
        this.credits = 0;
        this.journeyPts = 0;
        nextEmployeeIdNo ++;
    }

    public int getIdNo() { return super.getIdNo(); }
    
    /**
     * 
     *
     * @param  
     * @return    
     */
    public String getName() { return super.getName(); }
    
    /**
     * 
     *
     * @param  
     * @return    
     */
    public int getLuxRating() { return super.getLuxRating(); }
    
    /**
     * 
     *
     * @param  
     * @return    
     */
    public int getCredits() { return super.getCredits(); }
    
    /**
     * 
     *
     * @param  
     * @return    
     */
    public int getJourneyPts() { return super.getJourneyPts(); }
    
    public String getJobDesc() { return jobDesc; }
    
    public int getEmployeeId() { return employeeId; }
    
    public void addCredits(int c) { super.addCredits(c); }
    
    public void deductCredits(int c) { super.deductCredits(c); }
    
    public void addJourneyPts(int j) { super.addJourneyPts(j); }
    
    public void deductJourneyPts(int j) { super.deductJourneyPts(j); }
    
    public void useFerry() { 
        super.useFerry();
        super.addJourneyPts(1); 
    }
    
    public void convertPts() { super.convertPts(); }
    
    /**
     * 
     *
     * @param  
     * @return    
     */
    public String toString() {
        // put your code here
        String s = super.toString();
        s += "\nEmployee ID: "+employeeId + "\nJob Description: "+jobDesc;
        return s;
    }
}

