import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;
import Classes.*;
import java.io.*;
import java.nio.file.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Login extends JFrame implements ActionListener,MouseListener
{
    ImageIcon icon;
    JLabel username, password, loginMsg, frameImage,login,sms;
    JPanel leftPanel;
    JButton loginButton, resetButton,exit1;
    JTextField usernameField;
    JPasswordField userPasswordField;
    Font font;

    
    public Login()
    {

       Font font = new Font("Arial Rounded MT Bold", 0, 18);

        this.setTitle("Shop Management System");
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        leftPanel = new JPanel();
        leftPanel.setBounds(0,0,450,800);
        leftPanel.setBackground(new Color(0, 0, 51));
        leftPanel.setLayout(null);
        this.add(leftPanel);


        ImageIcon img =new ImageIcon("Image/store.png");
        frameImage = new JLabel(img);
        frameImage.setBounds(-50,-90,480,800);
        leftPanel.add(frameImage);
        this.add(leftPanel);


        username = new JLabel("Username :");
        username.setBounds(502, 300, 247, 32);
        username.setForeground(new Color(0, 0, 51));
        username.setFont(font);
        this.add(username);


        login = new JLabel("Login");
       // login.setOpaque(false);
        login.setBounds(502, 80, 247, 32);
        login.setForeground(new Color(0, 0, 51));
        login.setFont(new Font("Arial Rounded MT Bold", 0, 24));
        this.add(login);


        sms = new JLabel("Shop Management System");
        sms.setBounds(20, 50, 900, 40);
        sms.setForeground(new Color(255, 255, 255));
        sms.setFont(new Font("Arial Rounded MT Bold", 0, 32));
        leftPanel.add(sms);
        this.add(leftPanel);

        
        password = new JLabel("Password :");
        password.setBounds(502, 370, 247, 32);
        password.setForeground(new Color(0, 0, 51));
        password.setFont(font);
        this.add(password);


        loginMsg = new JLabel();
        loginMsg.setBounds(635, 600, 450, 32);
        loginMsg.setForeground(Color.BLACK);
        loginMsg.setFont(font);
        this.add(loginMsg);


        usernameField = new JTextField();
        usernameField.setBounds(645, 304, 285, 32);
        usernameField.setFont(font);
        usernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        this.add(usernameField);

        
        userPasswordField = new JPasswordField();
        userPasswordField.setBounds(645, 374, 285, 32);
        userPasswordField.setFont(font);
        userPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        this.add(userPasswordField);


        loginButton = new JButton("Login");
        loginButton.setBounds(635, 634, 95, 40);
        loginButton.setBackground(new Color(0, 0, 51));
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setFont(font);
      //  loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        loginButton.addMouseListener(this);
        this.add(loginButton);


        exit1 = new JButton("X");
        exit1.setBounds(890, 50, 50, 32);
        exit1.setBackground(new Color(240,240,240));
        exit1.setForeground(new Color(0,0,51));
        exit1.setFont(new Font("Arial Rounded MT Bold", 0, 24));
      //  exit1.setFocusable(false);
        exit1.addActionListener(this);
        this.add(exit1);


        resetButton = new JButton("Reset");
        resetButton.setBounds(765, 634, 95, 40);
        resetButton.setBackground(new Color(0, 0, 51));
        resetButton.setForeground(new Color(255, 255, 255));
        resetButton.setFont(font);
        resetButton.addActionListener(this);
        resetButton.addMouseListener(this);
        this.add(resetButton);

        
        
    }

//interface
    public void mouseClicked(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    public void mouseEntered(MouseEvent me)
    {
        if(me.getSource() == loginButton)
        {
            loginButton.setBackground(Color.WHITE);
            loginButton.setForeground(new Color(0,0,51));
        }
        else if(me.getSource() == resetButton)
        {
            resetButton.setBackground(Color.WHITE);
            resetButton.setForeground(new Color(0,0,51));
        }
        
        else
        {

        }
    }
    public void mouseExited(MouseEvent me)
    {
        if(me.getSource() == loginButton)
        {
            loginButton.setBackground(new Color(0, 0, 51));
            loginButton.setForeground(new Color(255, 255, 255));
        }

        else if(me.getSource() == resetButton)
        {

            resetButton.setBackground(new Color(0, 0, 51));
            resetButton.setForeground(new Color(255, 255, 255));

        }
        
        else
        {

        }
    }
    



    public void actionPerformed(ActionEvent e)
    {
        

        if(e.getSource() == resetButton)
        {
            usernameField.setText(null);
            userPasswordField.setText(null);
            loginMsg.setText(null);
        }

        if(e.getSource() == loginButton)
        {
            String username = usernameField.getText(); // User Name 
                String pass = new String(this.userPasswordField.getPassword()); // Password

                if (username.isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {

                    try {
                        String userNameS = "User Name : " + username;
                        String passwordS = "Password : " + pass;
                        BufferedReader reader = new BufferedReader(new FileReader(".\\Data\\user_data.txt"));

                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int i = 0; i <= totalLines; i++) {
                            String line = Files.readAllLines(Paths.get(".\\Data\\user_data.txt")).get(i);
                            if (line.equals(userNameS)) {
                                String line2 = Files.readAllLines(Paths.get(".\\Data\\user_data.txt")).get((i + 1));
                                if (line2.equals(passwordS)) {
                                    JOptionPane.showMessageDialog(null, "Login Successful.", "Shop Management!",
                                            JOptionPane.WARNING_MESSAGE);

                                    this.setVisible(false);
                                    Shop s = new Shop(this);
                                    s.setVisible(true);
                                    break;
                                }
                            }
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!",
                                JOptionPane.WARNING_MESSAGE);
                    }

                }
                

            }
            
        

        if(e.getSource()== exit1)
        {

            System.exit(0);
        }

        else
        {}
    }


}





