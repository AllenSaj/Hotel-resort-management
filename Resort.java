import java.util.Collections;
import java.util.ArrayList;

/**This class implements the WIRE interface
 **/
public class Resort implements WIRE {  // do not change this header
    private String location;
    private ArrayList<Card> allCards = new ArrayList<Card>();
    private ArrayList<Island> allIslands = new ArrayList<Island>();
    private ArrayList<Ferry> allFerries = new ArrayList<Ferry>();
    
    /** constructor
     * 
     */
    public Resort(String loc) {
        location = loc;
        Island ba = loadIslandsAndFerries();
        loadCards(ba);
    }
    
    /**
     * Returns information about the resort including its location/name and all
     * cards currently on each island, or "No cards" (if no card on that island
     * @return all of the details of all islands including location 
     * and all cards currently on each island, or "No cards" if island has no cards
     */
    public String toString() {
        String s = "Resort info\n--------------------------\nLocation: "+location+"\nIslands: ";
        for (Island is : allIslands) { s += is.getName()+", "; }
        s = s.substring(0, (s.length()-2));
        s += " ("+allIslands.size()+")\n--------------------------"; 
        s +=getAllCardsOnAllIslands();
        return s;
    }

    /**Returns a String representation of all the cards on all islands
     * with "No cards" if there are no cards on an island
     * @return a String representation of all cards on all islands
     **/
    public String getAllCardsOnAllIslands() {
        String s = "\nLocation of Cards\n--------------------------";
        for (int i = 0; i<allIslands.size(); i++) {
            if ( i != 0) { s += "\n--------------------------"; }
            s += "\nIsland "+i+" ("+allIslands.get(i).getName()+")";
            s += allIslands.get(i).getAllCardsAsString();
        }
        s+="\n--------------------------";
        return s;
    } 

    public String getAllCards() {
        String s = "\nAll Cards\n--------------------------";
        for (int i = 0; i<allCards.size(); i++) {
            s += "\n" + allCards.get(i).toString();
        }
        return s;
    } 
 
    /**Returns the name of the island which contains the specified card or "Not found"
     * @param cd -the id of the card
     * @return the name of the Island which contains the card, or "Not found"
     **/
    public String findCardLocation(int cd) {
        for (Island isl: allIslands) {       
            if (isl.findCard(cd) > -1 ) { return "Card is on island: " +isl.getName(); }
        } return null;
    }
    
    /**Returns details of the card with the specified id or "Not found"
     * @param cd - the id of the card
     * @return the details of the card, or "Not found"
     **/
    public String viewACard(int cd) {
        for (Island isl : allIslands) {       
            Card c = isl.getCard(cd);
            if (c != null) { return "--------------------------"+c.toString();            }
        } return "Not found";
    }
    
    /** Given the name of a island, returns the island id number
     * or -1 if island does not exist
     * @param isl is the name of island
     * @return id number of island
     */
    public int getIslandNumber(String isl) {
        for (Island i: allIslands) {
            if (i.getName().equals(isl)) { return i.getIdNo(); }
        } return -1;
    }

    public ArrayList<Island> getIslandList() { return allIslands; }

    public ArrayList<Card> getCardList() {return allCards;}
                
    /**Returns a String representation of all cards on a specified island
     * @param isl - the name of the island
     * @return a String representation of all cards on specified island
     **/
    public String getAllCardsOnIsland(String isl) {
        String s = "\nCards on "+isl+"\n--------------------------";
        boolean flag = false;
        for (Island i: allIslands) {
            if (i.getName().equals(isl)) {
                s += i.getAllCardsAsString();
                flag = true;
            }
        }
        if (flag == false) {  s += "\nIsland not found"; }
        s += "\n--------------------------";
        return s;
    } 

    public String getAllCardsAsString() {
        String s = "\nAll Cards\n--------------------------";
        for (int i = 0; i<allCards.size(); i++) {
            s += "\n" + allCards.get(i).toString();
        }
        return s;
    }

     /**Returns true if a Card is allowed to journey using a ferry, false otherwise
     * A journey can be made if:  
     * the rating of the card  >= the rating of the destination island
     * AND the destination island is not full
     * AND the card has sufficient credits (a journey costs 3 credits)
     * AND the card is currently in the source island 
     * AND the card id and ferry code represent objects in the system
     * @param cdId is the id of the card requesting the move
     * @param ferCode is the code of the ferry journey by which the card wants to move
     * @return true if the card is allowed on the ferry journey, false otherwise 
     **/
    public boolean canTravel(int cdId, String ferCode) {   
        Card cd = null;
        for (Card c : allCards) {
            if (c.getIdNo() == cdId) { cd = c; }
        }
        
        for (Ferry f : allFerries) {
            if (f.getCode().equals(ferCode)) { return f.canTravel(cd); }
        } return false;
    }     

    /**Returns the result of a card requesting to journey by Ferry.
     * A journey will be successful if:  
     * the luxury rating of the card  >= the luxury rating of the destination island
     * AND the destination island is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source island
     * AND both the card id and the ferry code is on the system
     * If the ferry journey can be made, the card is removed from the source island,
     * added to the destination island and a suitable message returned. Card 
     * information should be updated (A journey costs 3 credits and journey points incremented by 1)
     * If the ferry journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param pCardId is the id of the card requesting the move
     * @param ferCode is the code of the ferry by which the card wants to travel
     * @return a String giving the result of the request 
     **/
    public String travel(int pCardId, String ferCode ) {   //other checks optional
        Card cd = null;
        Ferry fer = null;
        for (Card c : allCards) {
            if (c.getIdNo() == pCardId) { cd = c; }
        }

        for (Ferry f : allFerries) {
            if (f.getCode().equals(ferCode)) { fer = f; }
        }
        
        if (fer == null) { return "Ferry does not exist"; }
        if (cd == null) { return "Card does not exist"; }
        return fer.travel(cd);
    } 
         
    /** Allows credits to be added to a card.
     *  @param id the id of the card toping up their credits
     *  @param creds the number of credits to be added to card 
     */
    public void topUpCredits(int id, int creds) {
        if (creds < 0) {
            for (Card c : allCards) {
                if (c.getIdNo() == id) { c.addCredits(creds); }
            }
        }
        else {
            for (Card c : allCards) {
                if (c.getIdNo() == id) { c.deductCredits(creds); }
            }
        }
    }

    /** Converts a card's journey points into credits
     * @param id the id of the card whose points are to be converted
     */
    public void convertPoints(int id)   {
        for (Card c : allCards) {
            if (c.getIdNo() == id) { c.convertPts(); }
        }   
    } 

    public void loadCards(Island i) {
        Card c1 = new Card(1000, "Lynn", 5, 10);
        Card c2 = new Card(1001, "May", 3, 30);
        Card c3 = new Card(1002, "Nils", 10, 0);
        Card c4 = new Card(1003, "Olek", 1, 12);
        Card c5 = new Card(1004, "Pan", 3, 3);
        Card c6 = new Card(1005, "Quin", 1, 30);
        Card c7 = new Card(1006, "Raj", 4, 5);
        Card c8 = new Card(1007, "Sol", 7, 20);
        Card c9 = new Card(1008, "Tel", 6, 30);
        Card c10 = new Card(1009, "Ana", 10, 69);
        Card c11 = new Card(1010, "Allen", 10, 69);
        Collections.addAll(allCards, c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11);
        
        i.enter(c1);
        i.enter(c2);
        i.enter(c3);
        i.enter(c4);
        i.enter(c5);
        i.enter(c6);
        i.enter(c7);
        i.enter(c8);
        i.enter(c9);
        i.enter(c10);
        i.enter(c11);
    }
    
    public Island loadIslandsAndFerries() {
        Island ba = new Island(0, "Base", 0, 100);
        Island yo = new Island(1, "Yorkie", 0, 100);
        Island bo = new Island(2, "Bounty", 0, 100);
        Island tw = new Island(3, "Twirl", 0, 100);
        Island ae = new Island(4, "Aero", 0, 100);
        Island lo = new Island(5, "Love", 10, 2);
        Collections.addAll(allIslands,ba,yo,bo,tw,ae,lo);
        
        Ferry f1 = new Ferry("ABC1", ba, yo);
        Ferry f2 = new Ferry("BCD2", yo, ba);
        Ferry f3 = new Ferry("CDE3", yo, bo);
        Ferry f4 = new Ferry("DEF4", bo, yo);
        Ferry f5 = new Ferry("EFG5", tw, yo);
        Ferry f6 = new Ferry("GHJ6", yo, ae);
        Ferry f7 = new Ferry("HJK7", ae, yo);
        Ferry f8 = new Ferry("JKL8", bo, tw);
        Ferry f9 = new Ferry("KLM9", ba, lo);

        Collections.addAll(allFerries,f1,f2,f3,f4,f5,f6,f7,f8,f9);
        
        return ba;
    }
}