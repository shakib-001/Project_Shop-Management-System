import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;

public class Registration extends JFrame implements ActionListener,MouseListener
{
    ImageIcon icon;
    JLabel username, password, email, frameImage,fTitle,pTitle;
    JPanel leftPanel;
    JButton registerButton, backButton;
    JTextField usernameField, emailField;
    JPasswordField userPasswordField;
    Font font;

    public Registration()
    {

       Font font = new Font("Arial Rounded MT Bold", 0, 18);

        this.setTitle("Shop Management System");
        this.setSize(900, 700);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        leftPanel = new JPanel();
        leftPanel.setBounds(0,0,450,800);
        leftPanel.setBackground(new Color(0, 0, 51));
        leftPanel.setLayout(null);
        this.add(leftPanel);


        ImageIcon icon =new ImageIcon("Image/store.png");
        frameImage = new JLabel(icon);
        frameImage.setBounds(-50,-90,480,800);
        leftPanel.add(frameImage);
        this.add(leftPanel);


        username = new JLabel("Username :");
        username.setBounds(502, 300, 247, 32);
        username.setForeground(new Color(0, 0, 51));
        username.setFont(font);
        this.add(username);


        pTitle = new JLabel("Registration");
        pTitle.setBounds(502, 80, 247, 32);
        pTitle.setForeground(new Color(0, 0, 51));
        pTitle.setFont(new Font("Arial Rounded MT Bold", 0, 24));
        this.add(pTitle);


        fTitle = new JLabel("Shop Management System");
        fTitle.setBounds(20, 50, 900, 40);
        fTitle.setForeground(new Color(255, 255, 255));
        fTitle.setFont(new Font("Arial Rounded MT Bold", 0, 32));
        leftPanel.add(fTitle);
        this.add(leftPanel);

        
        password = new JLabel("Password :");
        password.setBounds(502, 370, 247, 32);
        password.setForeground(new Color(0, 0, 51));
        password.setFont(font);
        this.add(password);

        email = new JLabel("Email :");
        email.setBounds(502, 440, 247, 32);
        email.setForeground(new Color(0, 0, 51));
        email.setFont(font);
        this.add(email);


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

        emailField = new JTextField();
        emailField.setBounds(645, 444, 285, 32);
        emailField.setFont(font);
        emailField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        this.add(emailField);


        registerButton = new JButton("Register");
        registerButton.setBounds(635, 634, 115, 40);
        registerButton.setBackground(new Color(0, 0, 51));
        registerButton.setForeground(new Color(255, 255, 255));
        registerButton.setFont(font);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);
        registerButton.addMouseListener(this);
        this.add(registerButton);


        backButton = new JButton("Back");
        backButton.setBounds(765, 634, 95, 40);
        backButton.setBackground(new Color(0, 0, 51));
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setFont(font);
        backButton.addActionListener(this);
        backButton.addMouseListener(this);
        this.add(backButton);

        
        
    }

    public void mouseClicked(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    public void mouseEntered(MouseEvent me)
    {
        if(me.getSource() == registerButton)
        {
            registerButton.setBackground(Color.WHITE);
            registerButton.setForeground(new Color(0,0,51));
        }
        else if(me.getSource() == backButton)
        {
            backButton.setBackground(Color.WHITE);
            backButton.setForeground(new Color(0,0,51));
        }
        
        else
        {

        }
    }
    public void mouseExited(MouseEvent me)
    {
        if(me.getSource() == registerButton)
        {
            registerButton.setBackground(new Color(0, 0, 51));
            registerButton.setForeground(new Color(255, 255, 255));
        }

        else if(me.getSource() == backButton)
        {

            backButton.setBackground(new Color(0, 0, 51));
            backButton.setForeground(new Color(255, 255, 255));

        }
        
        else
        {

        }
    }

    public void actionPerformed(ActionEvent e)
    {
        

        if(e.getSource() == backButton)
        {
            Welcome w = new Welcome();
            w.setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource() == registerButton)
        {
            String username = usernameField.getText(); // User Name
                String email = emailField.getText(); // Email
                String pass = new String(this.userPasswordField.getPassword()); // Password
                

                    if (username.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                                JOptionPane.WARNING_MESSAGE);
                    } else {

                        try {
                            File file = new File(".\\Data\\user_data.txt");
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            FileWriter fw = new FileWriter(file, true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter pw = new PrintWriter(bw);

                            pw.println("User Name : " + username);
                            pw.println("Password : " + pass);
                            pw.println("Email : " + email);
                            pw.println("===============================================");
                            pw.close();

                        } catch (Exception ex) {
                            System.out.print(ex);
                        }

                        JOptionPane.showMessageDialog(null, "Registration Successfully Completed.",
                                "Registration Complete", JOptionPane.WARNING_MESSAGE);
                        
                        
                    }
        }

}
}