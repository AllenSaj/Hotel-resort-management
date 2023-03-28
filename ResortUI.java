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
    private static JTextArea textArea = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(textArea);
    private static JPanel mainPanel = new JPanel();

    public ResortUI() {
        // Set up the JFrame
        setTitle("Wayward Islands Resort");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the main panel
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
        Font font = new Font("Verdana", Font.BOLD, 16);
        textArea.setFont(font);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(360, 1280));
         
        // Create the input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(scrollPane, BorderLayout.CENTER);
         
        
         // Add the button panel and input panel to the main panel
         mainPanel.add(buttonPanel, BorderLayout.CENTER);
         mainPanel.add(inputPanel, BorderLayout.EAST);
         
         // Add the main panel to the JFrame
         add(mainPanel);
         
         // Show the JFrame
         setVisible(true);
     }

    public void actionPerformed(ActionEvent e) { 
        String choice  = ((JButton)e.getSource()).getName();
        String output = "";
        if      (choice.equals("button1")) { output = listAllResort(); }
        else if (choice.equals("button2")) { output = listAllCards(); }
        else if (choice.equals("button3")) {  output = listOneIsland(); }
        else if (choice.equals("button4")) { output = findLocationOfCard(); }
        else if (choice.equals("button5")) { output = tryTravel(); }
        else if (choice.equals("button6")) { output = travelNow(); }
        else if (choice.equals("button7")) { output = viewCard(); }
        else if (choice.equals("button8")) { updateCredits(); }                        
        else if (choice.equals("button9")) { convertPts(); }
        else {System.out.println("Error"); }

        textArea.setText(output);
        }
        

    private String listAllResort() { return (wayward.toString()); }
    
    private String listAllCards() { return (wayward.getAllCardsOnAllIslands()); }
   
    private String listOneIsland() {
        Object[] fields = {"Enter Island name (case sensitive):", new JTextField()};
        int optionResult = JOptionPane.showConfirmDialog(mainPanel, fields, "Enter island information", JOptionPane.OK_CANCEL_OPTION);
        String name = ((JTextField) fields[1]).getText();
        return (wayward.getAllCardsOnIsland(name));
    }
       
    private String findLocationOfCard() {
        Object[] fields = {"Enter card ID:", new JTextField()};
        int optionResult = JOptionPane.showConfirmDialog(mainPanel, fields, "Enter card information", JOptionPane.OK_CANCEL_OPTION);
        int cardID = Integer.parseInt(((JTextField) fields[1]).getText());
        String ww = "\n--------------------------";
        String temp = wayward.findCardLocation(cardID);
        
        if(temp != null) { ww += temp + "\n--------------------------"; }
        else { ww += "No such card";}
        return (ww);
    }
    
    private String tryTravel() {
        Object[] fields = {"Enter card ID:", new JTextField(),"Enter ferry code", new JTextField()};
        int optionResult = JOptionPane.showConfirmDialog(mainPanel, fields, "Enter card and ferry information", JOptionPane.OK_CANCEL_OPTION);
        int trav = Integer.parseInt(((JTextField) fields[1]).getText());
        String ferry = ((JTextField) fields[3]).getText();
        if (wayward.canTravel(trav,ferry)) { return ("\nCard can travel\n"); }
        else { return ("\nCard cannot travel\n"); }
    }
    
    private String travelNow() {
        Object[] fields = {"Enter card ID:", new JTextField(),"Enter ferry code", new JTextField()};
        int optionResult = JOptionPane.showConfirmDialog(mainPanel, fields, "Enter card and ferry information", JOptionPane.OK_CANCEL_OPTION);
        int trav = Integer.parseInt(((JTextField) fields[1]).getText());
        String ferry = ((JTextField) fields[3]).getText();
        return (wayward.travel(trav,ferry));
    }
    
    private String viewCard() {
        Object[] fields = {"Enter card ID:", new JTextField()};
        int optionResult = JOptionPane.showConfirmDialog(mainPanel, fields, "Enter card information", JOptionPane.OK_CANCEL_OPTION);
        int cId = Integer.parseInt(((JTextField) fields[1]).getText());
        return (wayward.viewACard(cId));
    }
     
    private void updateCredits() {
        Object[] fields = {"Enter card ID:", new JTextField(),"Enter top-up amount:", new JTextField()};
        int optionResult = JOptionPane.showConfirmDialog(mainPanel, fields, "Enter card and top-up information", JOptionPane.OK_CANCEL_OPTION);
        int cId = Integer.parseInt(((JTextField) fields[1]).getText());
        int topup = Integer.parseInt(((JTextField) fields[3]).getText());
        wayward.topUpCredits(cId, topup);
    }
         
    private void convertPts() {
        Object[] fields = {"Enter card ID:", new JTextField()};
        int optionResult = JOptionPane.showConfirmDialog(mainPanel, fields, "Enter card information", JOptionPane.OK_CANCEL_OPTION);
        int cId = Integer.parseInt(((JTextField) fields[1]).getText());
        wayward.convertPoints(cId);
    }   

    public static void main(String[] args) { ResortUI GUI = new ResortUI(); }
 }
