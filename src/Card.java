/**
 * Write a description of class Card here.
 */
public class Card {
    private int idNo;
    private String name;
    private int luxRating;
    private int credits;
    private int journeyPts;
    public static int nextIdNo = 1000;
    
    /**
     * Constructors for objects of class Card
     */
    public Card(String name, int luxRating, int creds) {
    //Default test card cconstructor
        this.idNo = nextIdNo;
        this.name= name;
        this.luxRating = luxRating;
        this.credits = creds;
        this.journeyPts = 0;
        nextIdNo++;
    }
    
    public Card(int id, String name, int luxRating) {
    //Car constructor for default member
        this.idNo = id;
        this.name = name;
        this.luxRating = luxRating;
        this.credits = 0;
        this.journeyPts = 0;
    }
    
    public Card (String name, int luxRating) {
        this.idNo = nextIdNo;
        this.name = name;
        this.luxRating = luxRating;
        this.credits = 0;
        this.journeyPts = 0;
        nextIdNo ++ ;
    }
    

    /**
     * 
     *
     * @param  
     * @return    
     */
    public int getIdNo() { return idNo; }
    
    /**
     * 
     *
     * @param  
     * @return    
     */
    public String getName() { return name; }
    
    /**
     * 
     *
     * @param  
     * @return    
     */
    public int getLuxRating() { return luxRating; }
    
    /**
     * 
     *
     * @param  
     * @return    
     */
    public int getCredits() { return credits; }
    
    /**
     * 
     *
     * @param  
     * @return    
     */
    public int getJourneyPts() { return journeyPts; }
    
    public void addCredits(int c) { credits += c; }
    
    public void deductCredits(int c) { credits -= c; }
    
    public void addJourneyPts(int j) { journeyPts += j; }
    
    public void deductJourneyPts(int j) { journeyPts -= j; }

    
    public void useFerry() {
        deductCredits(3);
        addJourneyPts(1);
    }
    
    public void convertPts() {
        credits += journeyPts/5;
        journeyPts = journeyPts%5;
    }
    
    /**
     * 
     *
     * @param  
     * @return    
     */
    public String toString() {
        // put your code here
        return ("\nName: "+name + "\nID: "+idNo + "\nLuxury level: "+luxRating 
        + "\nCredits: " + credits + "\nJourney points: " + journeyPts);
    }
}
