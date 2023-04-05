
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Write a description of class ResortUI here.
 */

public class ResortUI extends JFrame implements ActionListener {
    private WIRE wayward = new Resort("Wayward Islands");
    private JScrollPane scrollPane = new JScrollPane(textArea);
    private static JPanel mainPanel = new JPanel();
    private static JTextArea textArea = new JTextArea();

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
        for (int i = 1; i <= 12; i++) {
            JButton button = new JButton("Button " + i);
            button.setPreferredSize(new Dimension(50, 100));
            button.addActionListener(this);
            if (i == 1) { button.setText("Resort Info"); }
            else if (i == 2) { button.setText("All cards"); }
            else if (i == 3) { button.setText("All Islands"); }
            else if (i == 4) { button.setText("Find island"); }
            else if (i == 5) { button.setText("Find card"); }
            else if (i == 6) { button.setText("Check travel"); }
            else if (i == 7) { button.setText("Travel"); }
            else if (i == 8) { button.setText("View card"); }
            else if (i == 9) { button.setText("Update credits"); }
            else if (i == 10) { button.setText("Convert points"); }
            else if (i == 11) { button.setText("Add Card"); }
            else if (i == 12) { button.setText("Add Island");}
            
            button.setName("button"+i);
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
        if      (choice.equals("button1")) { output = resortInfo(); }
        else if (choice.equals("button2")) { output = listAllCards(); }
        else if (choice.equals("button3")) { output = listAllIslands(); }
        else if (choice.equals("button4")) { output = listOneIsland(); }
        else if (choice.equals("button5")) { output = findLocationOfCard(); }
        else if (choice.equals("button6")) { output = tryTravel(); }
        else if (choice.equals("button7")) { output = travelNow(); }
        else if (choice.equals("button8")) { output = viewCard(); }
        else if (choice.equals("button9")) { updateCredits(); }                        
        else if (choice.equals("button10")) { convertPts(); }
        else if (choice.equals("button11")) { addCard(); }
        else if (choice.equals("button12")) { addIsland(); }
        else {System.out.println("Error"); }

        textArea.setText(output);
        }
        

    private String resortInfo() { return (wayward.toString()); }
    
    private String listAllCards() { return (wayward.getAllCardsAsString()); }
   
    private String listAllIslands() { return (wayward.getAllCardsOnAllIslands()); }

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
        String temp = wayward.findCardLocation(cardID);
        
        if(temp != null) { return temp; }
        else { return  "No such card";}
    }
    
    private String tryTravel() {
        Object[] fields = {"Enter card ID:", new JTextField(),"Enter ferry code", new JTextField()};
        int optionResult = JOptionPane.showConfirmDialog(mainPanel, fields, "Enter card and ferry information", JOptionPane.OK_CANCEL_OPTION);
        int trav = Integer.parseInt(((JTextField) fields[1]).getText());
        String ferry = ((JTextField) fields[3]).getText();
        if (wayward.canTravel(trav,ferry)) { return ("\nCard can travel\n"); }
        else { return (wayward.travel(trav,ferry)); }
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

    private void addCard() {
        String[] typeList = {"Employee", "Business", "Tourist", "Generic"};
        Object type = JOptionPane.showInputDialog(mainPanel, "Choose card type", "Card type", JOptionPane.QUESTION_MESSAGE, null, typeList, typeList[0]);
        String option = type.toString();

        if (option.equals("Employee")) { 
            Object[] fields = {"Enter card name", new JTextField(), "Enter job description:", new JTextField()}; 
            int optionResult = JOptionPane.showConfirmDialog(mainPanel, fields, "Enter card information", JOptionPane.OK_CANCEL_OPTION);
            wayward.makeEmployeeCard(((JTextField) fields[1]).getText(), ((JTextField) fields[3]).getText());
        }

        else if (option.equals("Business")) { 
            Object[] fields = {"Enter card name", new JTextField(), "Enter luxury rating:", new JTextField()}; 
            int optionResult = JOptionPane.showConfirmDialog(mainPanel, fields, "Enter card information", JOptionPane.OK_CANCEL_OPTION);
            wayward.makeBusinessCard(((JTextField) fields[1]).getText(), Integer.parseInt(((JTextField) fields[3]).getText()));
        }

        else if (option.equals("Tourist")) { 
            Object[] fields = {"Enter card name", new JTextField(), "Enter luxury rating:", new JTextField(), "Enter country of origin:", new JTextField(), "Enter starting balance:", new JTextField()}; 
            int optionResult = JOptionPane.showConfirmDialog(mainPanel, fields, "Enter card information", JOptionPane.OK_CANCEL_OPTION);
            wayward.makeTouristCard(((JTextField) fields[1]).getText(), Integer.parseInt(((JTextField) fields[3]).getText()),   Integer.parseInt(((JTextField) fields[7]).getText()), ((JTextField) fields[5]).getText());
        }

        else if (option.equals("Generic")) {
            Object[] fields = {"Enter card name", new JTextField(), "Enter luxury rating:", new JTextField()};
            int optionResult = JOptionPane.showConfirmDialog(mainPanel, fields, "Enter card information", JOptionPane.OK_CANCEL_OPTION);
            wayward.makeCard(((JTextField) fields[1]).getText(), Integer.parseInt(((JTextField) fields[3]).getText()));
        }
    }

    private void addIsland() {
        Object[] fields = {"Enter Island name", new JTextField(), "Enter luxury rating:", new JTextField(), "Enter capacity", new JTextField()};
        int optionResult = JOptionPane.showConfirmDialog(mainPanel, fields, "Enter island information", JOptionPane.OK_CANCEL_OPTION);
        String name = ((JTextField) fields[1]).getText(); 
        wayward.makeIsland(((JTextField) fields[1]).getText(), Integer.parseInt(((JTextField) fields[3]).getText()), Integer.parseInt(((JTextField) fields[5]).getText()));
       
        String[] options = {"Yes, Ferry to and from", "Yes, Ferry to", "Yes, Ferry from", "No"};
        int input = JOptionPane.showOptionDialog(mainPanel, "Island Created, Do you want to create Ferry to travel to Island", "Ferry creation",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        if (input != 3) {
            Object[] fields2 = {"Enter connecting Island name (case sensitive)", new JTextField()};
            int optionResult2 = JOptionPane.showConfirmDialog(mainPanel, fields, "Enter ferry information", JOptionPane.OK_CANCEL_OPTION);
            if (input == 0) {
                wayward.makeFerry(wayward.getIsland(((JTextField) fields[1]).getText()), wayward.getIsland(name));
                wayward.makeFerry(wayward.getIsland(name), wayward.getIsland(((JTextField) fields[1]).getText()));
            }
            else if (input == 1) { wayward.makeFerry(wayward.getIsland(((JTextField) fields[1]).getText()), wayward.getIsland(name)); }
            else if (input == 2) { wayward.makeFerry(wayward.getIsland(name), wayward.getIsland(((JTextField) fields[1]).getText())); }
        }
    }

    public static void main(String[] args) { ResortUI GUI = new ResortUI(); }
 }
