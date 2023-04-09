import java.util.ArrayList;
/**
 * An island is part of a resort.Each island has a name,  a luxury rating
 * and a capacity which represents the maximum number of people(cards) who can be on the  
 * island at any one time. Each island must maintain a list of all people (cards)
 * currently on the island. These lists are updated whenever cards enter or leave 
 * an island,so that it is always possible to say which (cards) are on the island 
 */

public class Island {
    private int idNo;
    private String name;
    private int luxRating;
    private int cap;
    private ArrayList<Card> CardList = new ArrayList<Card>();
    public static int nextIdNo = 6;
    
    public Island(String n, int l, int c) {
        this.idNo = nextIdNo;
        this.name = n;
        this.luxRating = l;
        this.cap = c;
        nextIdNo++;
    }
    
    public Island(int id, String n, int l, int c) {
        this.idNo = id;
        this.name = n;
        this.luxRating = l;
        this.cap = c;
        nextIdNo = id + 1;
    }
    
    public int getIdNo() { return idNo; }
    
    
    public String getName() { return name; }
    
    public int getLuxRating() { return luxRating; }
    
    public int getCap() { return cap; }
    
    public ArrayList<Card> getCardList() { return CardList; }
    
    public String getAllCardsAsString() {
        String temp = "";
        if (CardList.size() == 0) {
            return "\nNo cards found";
        }
        for (Card c : CardList ) {
            temp += c.toString()+"\n";
        }
        return temp;
    }
    
    public boolean checkSpace() {
        int c = CardList.size() - cap;
        if (c < 0) {
            return true;
        } return false;
    }
    
    public void print() {
        System.out.println("Name: "+name);
        System.out.println("Luxury Rating: "+luxRating);
        System.out.println("Capacity: "+cap);
        System.out.println("-----------------------");
    }
    
    public int findCard (int id) {
        for (int i=0; i < CardList.size(); i++) {
            if (CardList.get(i).getIdNo() == id) {
                return i;
            }
        } return -1;
    }
    
    public Card getCard(int id){
        int i = findCard(id);
        if (i > -1) { return CardList.get(i); }
        else { return null; }
    }
    
    public String getCardAsString(int id) {
        int i = findCard(id);
        if (i > -1) { return CardList.get(i).toString(); }
        else { return null; }
    }
    
    public void enter (Card c) {
       if (checkSpace())  { CardList.add(c); }
       else { errorCap(); }
    }
    
    public void removeCard(int id) {
        for (int i=0; i < CardList.size(); i++) {
            if (CardList.get(i).getIdNo() == id) { CardList.remove(i); }
        }
    }

    public void leave (Card c) { removeCard(c.getIdNo()); }
    
    public void errorCap () { System.out.println("Error: Island at capacity"); }
    
    public void errorNotFound() { System.out.println("Error: Card not found"); }
    
    public String toString () {
        return "Name: "+name+"\nLuxury Rating: "+luxRating+"\nCapacity: "+cap+
        "\n---------------------------" +"\n Cards" + getAllCardsAsString(); 
    }
}

