
/**
 * Write a description of class Employee here.
 */
public class Employee extends Card {
    private int employeeId;
    private String jobDesc;
    public static int nextEmployeeIdNo = 5000;
    
    public Employee(String nm, String jobD) {
        super(nm,10,0);
        this.employeeId = nextEmployeeIdNo;
        this.jobDesc = jobD;
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
        String s = super.toString();
        s += "\nEmployee ID: "+employeeId + "\nJob Description: "+jobDesc;
        return s;
    }
}

