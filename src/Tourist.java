
/**
 * Write a description of class Tourist here.
 */
public class Tourist extends Card {
    private int idNo;
    private String name;
    private int luxRating;
    private int credits;
    private int journeyPts;
    private String country;

    public Tourist(String name, int luxRating, int creds, String cntry) {
        // initialise instance variables
        super(name, luxRating);
        this.country = cntry;
        this.credits = creds;
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
    
    public String getCountry() { return country; }
    
    public void addCredits(int c) { super.addCredits(c); }
    
    public void deductCredits(int c) { super.deductCredits(c); }
    
    public void addJourneyPts(int j) { super.addJourneyPts(j); }
    
    public void deductJourneyPts(int j) { super.deductJourneyPts(j); }
    
    public void convertPts() { super.convertPts(); }

    public void useFerry() {
       super.useFerry();
       super.deductCredits(1);
    }
    
    /**
     * 
     *
     * @param  
     * @return    
     */
    public String toString() {
        String s = super.toString();
        return s + "\nCitizenship: "+ country;
    }
}
