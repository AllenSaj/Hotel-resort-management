import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Auth implements ActionListener {
    private JFrame frameLogin = new JFrame();
    private JFrame frameReg = new JFrame();
    private JLabel labelPass = new JLabel("Password");
    private JLabel labelPassConfirm = new JLabel("Confirm password");
    private JLabel labelUser = new JLabel("Username");
	private JTextField username = new JTextField(); 
    private JPasswordField password = new JPasswordField();
    private JPasswordField passwordConfirm = new JPasswordField();
	private JButton buttonLog  = new JButton("Login");
    private JButton buttonReg  = new JButton("Register");
    private JButton buttonCreate  = new JButton("Create account");
    private JPanel panelLog = new JPanel();
    private JPanel panelReg = new JPanel();
    private boolean loggedIn = false;
    private HashMap<String, String> credentials = new HashMap<String, String>();

    public Auth() {
        String pass = encryptPassword("admin");
        credentials.put("allen", pass);
    }

    public void login() {
        panelLog.setLayout(null);
        frameLogin.setTitle("LOGIN PAGE");
        frameLogin.setLocation(new Point(700, 400));
        frameLogin.add(panelLog);
        frameLogin.setSize(new Dimension(300, 230));

        labelUser.setBounds(50, 8, 70, 20);
        panelLog.add(labelUser);
        username.setBounds(50, 27, 200, 28);
        panelLog.add(username);
        labelPass.setBounds(50, 55, 70, 20);
        panelLog.add(labelPass);
        password.setBounds(50, 75, 200, 28);
        panelLog.add(password);

        buttonLog.setBounds(100, 110, 100, 25);
        buttonLog.setBackground(new Color(240,128,128));
        buttonLog.addActionListener(this);
        buttonReg.setBounds(100, 140, 100, 25);
        buttonReg.setBackground(new Color(240,128,128));
        buttonReg.addActionListener(this);

        panelLog.add(buttonLog);
        panelLog.add(buttonReg);
    }


    public boolean getLoggedStatus() { return this.loggedIn;}

    public void logIn() { 
        login();
        if (!loggedIn) { frameLogin.setVisible(true); }
        else { JOptionPane.showMessageDialog(ResortUI.frameMain, "Already logged in"); }
    }

    public void logOut() { loggedIn = false; }
   
    public void register() {
        panelReg.setLayout(null);
        frameReg.setTitle("REGISTRATION PAGE");
        frameReg.setLocation(new Point(700, 400));
        frameReg.add(panelReg);
        frameReg.setSize(new Dimension(300, 230));

        labelUser.setBounds(50, 8, 70, 20);
        panelReg.add(labelUser);
        username.setBounds(50, 27, 200, 28);
        panelReg.add(username);
        labelPass.setBounds(50, 55, 70, 20);
        panelReg.add(labelPass);
        password.setBounds(50, 75, 200, 28);
        panelReg.add(password);
        labelPassConfirm.setBounds(50, 103, 200, 20);
        panelReg.add(labelPassConfirm);
        passwordConfirm.setBounds(50, 123, 70, 28);
        panelReg.add(passwordConfirm);

        buttonCreate.setBounds(50, 110, 200, 25);
        buttonCreate.setBackground(new Color(240,128,128));
        buttonCreate.addActionListener(this);
        panelReg.add(buttonCreate);
        frameReg.setVisible(true);
    }

    public String encryptPassword(String password) {
        try {
           MessageDigest md = MessageDigest.getInstance("SHA-256");
           byte[] hash = md.digest(password.getBytes());
           StringBuilder sb = new StringBuilder();
           for (byte b : hash) {
              sb.append(String.format("%02x", b));
           }
           System.out.println(sb.toString());
           return sb.toString();
        } catch (NoSuchAlgorithmException e) {
           System.err.println("Error encrypting password: " + e.getMessage());
           return null;
        }
     }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        String user = username.getText();
        String pass =  new String(password.getPassword());
        String encryptedPass = encryptPassword(pass);
        String passConfirm = new String(password.getPassword());
        if (button == buttonLog) {
            if (credentials.get(user).equals(encryptedPass)) {
                frameLogin.setVisible(false);
                JOptionPane.showMessageDialog(ResortUI.frameMain, "Login Successfull");
                this.loggedIn = true;
                username.setText("");
                login();
            }
            else {  JOptionPane.showMessageDialog(ResortUI.frameMain, " Username or Password mismatch ", "Login error", JOptionPane.WARNING_MESSAGE);  }
            password.setText("");
        }

        else if (button == buttonReg) {
            frameLogin.setVisible(false);
            register();
        }

        else if (button == buttonCreate) {
            if (user.length() == 0 || pass.length() == 0) { JOptionPane.showMessageDialog(ResortUI.frameMain, "Username and password field cannot be empty", "Registration error", JOptionPane.WARNING_MESSAGE); }
            else if (!pass.equals(passConfirm)) { JOptionPane.showMessageDialog(ResortUI.frameMain, "Passwords must match", "Registration error", JOptionPane.WARNING_MESSAGE); }
            else if (credentials.containsKey(user) ) { JOptionPane.showMessageDialog(ResortUI.frameMain, "Username already in use: Please choose another", "Registration error", JOptionPane.WARNING_MESSAGE);  }
            else { 
                credentials.put(user, encryptedPass);
                frameReg.setVisible(false);
                JOptionPane.showMessageDialog(ResortUI.frameMain, "Account created");
            }
            username.setText("");
            password.setText("");
        }
    }
}
