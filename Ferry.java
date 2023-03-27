
/**
 * A ferry provides a one-way journey between two islands. It
 * has a ferry code and information about both the source and
 * the destination island
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ferry {
    private String code;
    private Island whereFrom;
    private Island whereTo;
    
    public Ferry(String c, Island from, Island to) {
        code = c;
        whereFrom = from;
        whereTo = to;
    }
    
    public Island getSource() { return whereFrom; }
    
    public Island getDest() { return whereTo; }
    
    public String getCode() { return code; }
    
    public boolean canTravel(Card c) {
        if (c.getLuxRating() >= whereTo.getLuxRating() && c.getCredits() >= 3 
        && whereTo.checkSpace() && whereFrom.findCard(c.getIdNo()) > -1) {
            return true;
        } return false;
    }
    
    public String travel (Card c) {
        if (canTravel(c)) {
            c.useFerry();
            whereFrom.leave(c);
            whereTo.enter(c);
            return "Journey successfully made";
        }
        else if (c.getLuxRating() < whereTo.getLuxRating()) { return "Cannot travel: Card luxury rating too low"; }
        else if (c.getCredits() < 3) { return "Cannot travel: Insufficient credits"; }
        else if (whereTo.checkSpace() == false) { return "Cannot travel: No space at destination"; }
        else if (whereFrom.findCard(c.getIdNo()) == -1) { return "Cannot travel: Card not at ferry source"; }
        return "Unknown error";
    }
}

