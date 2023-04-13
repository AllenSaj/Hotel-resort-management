
/**
 * Tourist class is a child of the Card class, describes a specific type of card held by a tourist
 */
public class Tourist extends Card {
    private String country;

    public Tourist(String name, int luxRating, int creds, String cntry) {
        // initialise instance variables
        super(name, luxRating, creds);
        this.country = cntry;
    }

    public int getIdNo() { return super.getIdNo(); }
    
    /**
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
    
    /**
     * @return
     */
    public String getCountry() { return country; }
    
    /**
     * @param
     * @return
     */
    public void addCredits(int c) { super.addCredits(c); }
    

    /**
     * @param
     * @return
     */
    public void deductCredits(int c) { super.deductCredits(c); }
    
    /**
     * @param
     * @return
     */
    public void addJourneyPts(int j) { super.addJourneyPts(j); }
    
    /**
     * @param
     * @return
     */
    public void deductJourneyPts(int j) { super.deductJourneyPts(j); }
     
    /**
     * @return
     */
    public void convertPts() { super.convertPts(); }

    /**
     */
    public void useFerry() {
       super.useFerry();
       super.deductCredits(1);
    }
    
    /** 
     * @return    
     */
    public String toString() {
        String s = super.toString();
        return s + "\nCitizenship: "+ country;
    }
}
