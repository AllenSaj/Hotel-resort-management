import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Write a description of class ResortUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

 public class ResortUI extends JFrame implements ActionListener {
    private Scanner inpInt = new Scanner(System.in);
    private Scanner inpStr = new Scanner(System.in);
    private WIRE wayward = new Resort("Wayward Islands");

    public ResortUI() {
        // Set up the JFrame
        setTitle("Wayward Islands Resort");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
         
        // Create the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));
         
        // Create the buttons and add them to the button panel
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton("Button " + i);
            button.setPreferredSize(new Dimension(50, 100));
            button.addActionListener(this);
            if (i == 1) { 
                button.setText("All resorts");
                button.setName("button"+i); 
            }
            else if (i == 2) { 
                button.setText("All cards");
                button.setName("button"+i);
            }
            else if (i == 3) { 
                button.setText("Find island");
                button.setName("button"+i);
            }
            else if (i == 4) { 
                button.setText("Find card");
                button.setName("button"+i);
            }
            else if (i == 5) { 
                button.setText("Check travel");
                button.setName("button"+i);
            }
            else if (i == 6) { 
                button.setText("Travel");
                button.setName("button"+i);
            }
            else if (i == 7) { 
                button.setText("View card");
                button.setName("button"+i);
            }
            else if (i == 8) { 
                button.setText("Update credits");
                button.setName("button"+i);
            }
            else if (i == 9) { 
                button.setText("Convert points");
                button.setName("button"+i);
            }

            buttonPanel.add(button);
        }
       
        // Create the output text area
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(360, 1280));
         
        // Add the button panel and output text area to the main panel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.EAST);
         
        // Add the main panel to the JFrame
        add(mainPanel);
         
        // Show the JFrame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){ 
        JButton btn = ((JButton)e.getSource());
        String choice = btn.getName();
        if      (choice.equals("button1")) { listAllResort(); }
        else if (choice.equals("button2")) { listAllCards(); }
        else if (choice.equals("button3")) { listOneIsland(); }
        else if (choice.equals("button4")) { findLocationOfCard(); }
        else if (choice.equals("button5")) { tryTravel(); }
        else if (choice.equals("button6")) { travelNow(); }
        else if (choice.equals("button7")) { viewCard(); }
        else if (choice.equals("button8")) { updateCredits(); }                        
        else if (choice.equals("button9")) { convertPts(); }
        else {System.out.println("Error"); }
        }
    

    private void listAllResort() { System.out.println(wayward.toString()); }
    
    private void listAllCards() { System.out.println(wayward.getAllCardsOnAllIslands()); }
   
    private void listOneIsland() {
        System.out.println("Enter Island name (case sensitive):");
        String name = inpStr.nextLine();
        System.out.println(wayward.getAllCardsOnIsland(name));
    }
       
    private void findLocationOfCard() {
        System.out.println("Enter card ID: ");
        int trav = inpInt.nextInt();
        String ww = "\n--------------------------";
        String temp = wayward.findCardLocation(trav);
        
        if(temp != null) {
            ww += "\n" + temp + "\n--------------------------";
            System.out.println(ww);
        }
        else {
            ww += "\nNo such card\n";
            System.out.println(ww);
        }
    }
    
    private void tryTravel() {
        System.out.println("Enter card id");
        int trav = inpInt.nextInt();
        System.out.println("Enter ferry code");
        String ferry = inpStr.nextLine();
        if (wayward.canTravel(trav,ferry)) { System.out.println("\nCard can travel\n"); }
        else { System.out.println("\nCard cannot travel\n"); }
    }
    
    private void travelNow() {
        System.out.println("Enter Card ID");
        int trav = inpInt.nextInt();
        System.out.println("Enter ferry code");
        String ferry = inpStr.nextLine();
        System.out.println("\n"+wayward.travel(trav,ferry) + "\n");
    }
    
    private void viewCard() {
        System.out.println("Enter card ID number");
        int cId = inpInt.nextInt();
        System.out.println(wayward.viewACard(cId));
    }
     
    private void updateCredits() {
        System.out.println("Enter Card Id: ");
        int id = inpInt.nextInt();
        System.out.println("Enter Top up amount: ");
        int topup = inpInt.nextInt();
        wayward.topUpCredits(id, topup);
    }
         
    private void convertPts() {
        System.out.println("Enter card ID number");
        int cId = inpInt.nextInt();
        wayward.convertPoints(cId);
    }   


    public static void main(String[] args) { ResortUI GUI = new ResortUI(); }
 }
