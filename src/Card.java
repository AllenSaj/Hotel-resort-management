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
        this.idNo = nextIdNo;
        this.name= name;
        this.luxRating = luxRating;
        this.credits = creds;
        this.journeyPts = 0;
        nextIdNo++;
    }
    

    /** Accessor for Id number field
     * @return returns current value of ID number stored by object
     */
    public int getIdNo() { return idNo; }
    
    /** Accessor for name field
     * @return returns current value of name stored by object
     */
    public String getName() { return name; }
    
    /** Access for luxury rating field
     * @return returns current value of luxury rating stored by object
     */
    public int getLuxRating() { return luxRating; }
    
    /** Accessor for the credits field
     * @return returns current value of credits stored by object
     */
    public int getCredits() { return credits; }
    
    /** Accessor for the journey points field
     * @return returns current value of journey points stored by object
     */
    public int getJourneyPts() { return journeyPts; }
    
    /** Increases credits by the value of the parameter
     * @param c amount to increase credits
     */
    public void addCredits(int c) { credits += c; }
    
    /** Deducts credits by the value of the parameter
     * @param c amount to deduct credits
     */
    public void deductCredits(int c) { credits -= c; }
    
    /** Increases journey points by the value of the parameter 
     * @param j amount to increase journey point
     */
    public void addJourneyPts(int j) { journeyPts += j; }

    /** Deducts journey points by the value of the parameter
     * @param j amount to reduce journey point
     */
    public void deductJourneyPts(int j) { journeyPts -= j; }

    /** Deducts credits and adds a journey point when ferry journey is made
     */
    public void useFerry() {
        deductCredits(3);
        addJourneyPts(1);
    }
    
    /** Converts each 5 journey points into credits, the leftover remains in journey points
     */
    public void convertPts() {
        credits += journeyPts/5;
        journeyPts = journeyPts%5;
    }
    
    /** Converts card object into a String which lists all its values in a neat list
     * @return returns card as String
     */
    public String toString() {
        // put your code here
        return ("\nName: "+name + "\nID: "+idNo + "\nLuxury level: "+luxRating 
        + "\nCredits: " + credits + "\nJourney points: " + journeyPts);
    }
}
