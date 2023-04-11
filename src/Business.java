
/**
 * Write a description of class Tourist here.
 */
public class Business extends Card {
    private int loyaltyPts;
    
    /**
     * Constructor for objects of class Tourist
     */
    public Business( String name, int luxRating, int creds) {
        super(name, luxRating, creds);
        this.loyaltyPts = 0;
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
    
    public int getLoyaltyPts() { return loyaltyPts; }
    
    public void addCredits(int c) { super.addCredits(c); }
    
    public void deductCredits(int c) { super.deductCredits(c); }

    public void addJourneyPts(int j) { super.addJourneyPts(j); }
    
    public void deductJourneyPts(int j) { super.deductJourneyPts(j); }
    
    public void addLoyaltyPts(int j) { loyaltyPts += j; }
    
    public void deductLoyaltyPts(int j) { loyaltyPts -= j; }
    
    public void useFerry() {
        super.useFerry();
        addLoyaltyPts(2);
    }
    
    public void convertPts() {
        int journey = super.getJourneyPts();
        super.addCredits(loyaltyPts/3);
        loyaltyPts = loyaltyPts%3;
        loyaltyPts += journey/3;
        super.deductJourneyPts(journey/3);
    }
    
    /**
     * 
     *
     * @param  
     * @return    
     */
    public String toString() { return super.toString() +"\nLoyalty Points: " + loyaltyPts ; }
}
