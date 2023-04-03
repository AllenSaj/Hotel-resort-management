
/**
 * Write a description of class Tourist here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Business extends Card {
    private int idNo;
    private String name;
    private int luxRating;
    private int credits;
    private int journeyPts;
    private int loyaltyPts;
    
    /**
     * Constructor for objects of class Tourist
     */
    public Business( String name, int luxRating) {
        // initialise instance variables
        super(name, luxRating);
        this.journeyPts = 0;
        this.credits = 30;
        this.loyaltyPts = 20;
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
        super.convertPts();
        credits += loyaltyPts/3;
        loyaltyPts = journeyPts%3;
    }
    
    /**
     * 
     *
     * @param  
     * @return    
     */
    public String toString() { return super.toString() +"\nLoyalty Points: " + loyaltyPts ; }
}
