import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Welcome extends JFrame implements ActionListener,MouseListener
{
    ImageIcon Icon; 
    JLabel ProjectTitle, frameimg;
     JButton login, registration, exit1; 
     Font font;

  public Welcome()
  {
       Font font = new Font("Arial Rounded MT Bold", 0, 25);

        this.setTitle("Shop Management System");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(0, 0, 51));


        Icon = new ImageIcon("Image" + System.getProperty("file.separator") + "shopping-cart (4).png");
        frameimg = new JLabel(Icon);
        frameimg.setBounds(140, -30, 500, 500);
        this.add(frameimg);

        ProjectTitle = new JLabel("SHOP MANAGEMENT SYSTEM");
        ProjectTitle.setBounds(150, 400, 600, 40);
        ProjectTitle.setForeground(new Color(0, 0, 51));
        ProjectTitle.setFont(new Font("Arial Rounded MT Bold", 0, 36));;
        this.add(ProjectTitle);

        login = new JButton("Login");
        login.setBounds(230, 500, 190, 40);
        login.setBackground(new Color(0, 0, 51));
        login.setForeground(new Color(255, 255, 255));
        login.setFont(font);
        login.setFocusable(false);
        login.addActionListener(this);
        login.addMouseListener(this);
        this.add(login);

        registration = new JButton("Registration");
        registration.setBounds(430, 500, 190, 40);
        registration.setBackground(new Color(0, 0, 51));
        registration.setForeground(new Color(255, 255, 255));
        registration.setFont(font);
        registration.setFocusable(false);
        registration.addActionListener(this);
        registration.addMouseListener(this);
        this.add(registration);

        exit1 = new JButton("X");
        exit1.setBounds(700, 50, 50, 32);
        exit1.setBackground(new Color(240,240,240));
        exit1.setForeground(new Color(0,0,51));
        exit1.setFont(new Font("Arial Rounded MT Bold", 0, 24));
        exit1.setFocusable(false);
        exit1.addActionListener(this);
        this.add(exit1);
    }

        public void mouseClicked(MouseEvent me){}
        public void mousePressed(MouseEvent me){}
        public void mouseReleased(MouseEvent me){}
        public void mouseEntered(MouseEvent me)
        {
            if(me.getSource() == login)
            {
                login.setBackground(Color.WHITE);
                login.setForeground(new Color(0,0,51));
            }
             if(me.getSource() == registration)
            {
                registration.setBackground(Color.WHITE);
                registration.setForeground(new Color(0,0,51));
            }
    
            else
            {
    
            }
        }
    public void mouseExited(MouseEvent me)
    {
        if(me.getSource() == login)
        {
            login.setBackground(new Color(0, 0, 51));
            login.setForeground(new Color(255, 255, 255));
        }
        if(me.getSource() == registration)
        {
            registration.setBackground(new Color(0, 0, 51));
            registration.setForeground(new Color(255, 255, 255));
        }

        else
        {

        }
    }

    public void actionPerformed(ActionEvent e)
    {

       
        if(e.getSource() == login)
        {
            Login l = new Login();
            l.setVisible(true);
            this.setVisible(false);
        }

        if(e.getSource() == registration)
        {
            Registration r = new Registration();
            r.setVisible(true);
            this.setVisible(false);
        }

        if(e.getSource()== exit1)
        {

            System.exit(0);
        }

    }
}