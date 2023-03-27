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
        JButton button1 = new JButton("All resorts");
        button1.setPreferredSize(new Dimension(100, 50));
        button1.addActionListener(this);
        buttonPanel.add(button1);

        JButton button2 = new JButton();
        button2.setText("All cards");
        button2.setPreferredSize(new Dimension(100, 50));
        button2.addActionListener(this);
        buttonPanel.add(button2);

        JButton button3 = new JButton();
        button3.setText("Find island");
        button3.setPreferredSize(new Dimension(100, 50));
        button3.addActionListener(this);
        buttonPanel.add(button3);

        JButton button4 = new JButton();
        button4.setText("Find card");
        button4.setPreferredSize(new Dimension(100, 50));
        button4.addActionListener(this);
        buttonPanel.add(button4);

        JButton button5 = new JButton();
        button5.setText("Check travel");
        button5.setPreferredSize(new Dimension(100, 50));
        button5.addActionListener(this);
        buttonPanel.add(button5);

        JButton button6 = new JButton();
        button6.setText("Travel");
        button6.setPreferredSize(new Dimension(100, 50));
        button6.addActionListener(this);
        buttonPanel.add(button6);

        JButton button7 = new JButton();
        button7.setText("View card");
        button7.setPreferredSize(new Dimension(100, 50));
        button7.addActionListener(this);
        buttonPanel.add(button7);

        JButton button8 = new JButton();
        button8.setText("Convert points");
        button8.setPreferredSize(new Dimension(100, 50));
        button8.addActionListener(this);
        buttonPanel.add(button8);

        JButton button9 = new JButton();
        button9.setText("Convert points")
        button9.setPreferredSize(new Dimension(100, 50));
        button9.addActionListener(this);
        buttonPanel.add(button9);

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
        String name = ((JButton)e.getSource()).get();
        int choice = (name.charAt(0));
        if      (choice == 1) { listAllResort(); }
        else if (choice == 2) { listAllCards(); }
        else if (choice == 3) { listOneIsland(); }
        else if (choice == 4) { findLocationOfCard(); }
        else if (choice == 5) { tryTravel(); }
        else if (choice == 6) { travelNow(); }
        else if (choice == 7) { viewCard(); }
        else if (choice == 8) { updateCredits(); }                        
        else if (choice == 9) { convertPts(); }
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
