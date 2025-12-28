import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Owner extends JFrame implements ActionListener,MouseListener
{
    ImageIcon icon;
    JLabel ownername, ownernum,address, frameImage,ownerinfo,sms;
    JPanel leftPanel;
    JButton nextButton, backButton;
    JTextField ownernameField,addressTF,ownernumTF;
    Font font;
    Login l;
    Shop s;
    Homepage h;
    Employee em;

    
    
    public Owner(Shop s, Login l)
    {
 
       this.s=s;
       this.l=l;

        font = new Font("Arial Rounded MT Bold", 0, 18);


        this.setTitle("Owner information");
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        leftPanel = new JPanel();
        leftPanel.setBounds(0,-30,480,800);
        leftPanel.setLayout(null);
        leftPanel.setBackground(new Color(0, 0,51 ));
        this.add(leftPanel);



        ImageIcon img =new ImageIcon("Image/Owner.png");
        frameImage = new JLabel(img);
        frameImage.setBounds(0,100,480,800);
        leftPanel.add(frameImage);
        this.add(leftPanel);



        sms = new JLabel("Shop Management System");
        sms.setBounds(20, 50, 500, 40);
        sms.setForeground(new Color(255, 255, 255));
        sms.setFont(new Font("Arial Rounded MT Bold", 0, 32));
        leftPanel.add(sms);
        this.add(leftPanel);


        
        ownername = new JLabel("Enter owner Name :");
        ownername.setBounds(502, 250, 300, 32);
        ownername.setForeground(new Color(0, 0, 51));
        ownername.setFont(font);
        this.add(ownername);



        address = new JLabel("Enter Address :");
        address.setBounds(502, 320, 300, 32);
        address.setForeground(new Color(0, 0, 51));
        address.setFont(font);
        this.add(address);



        ownernum = new JLabel("Enter Phone Num :");
        ownernum.setBounds(502, 390, 247, 32);
        ownernum.setForeground(new Color(0, 0, 51));
        ownernum.setFont(font);
        this.add(ownernum);



        ownerinfo = new JLabel("Owner Information :");
        ownerinfo.setBounds(502, 50, 300, 35);
        ownerinfo.setForeground(new Color(0, 0, 51));
        ownerinfo.setFont(new Font("Arial Rounded MT Bold", 0, 24));
        this.add(ownerinfo);



        ownernameField = new JTextField();
        ownernameField.setBounds(675, 254, 285, 32);
        ownernameField.setFont(font);
        ownernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        ownernameField.addActionListener(this);
        this.add(ownernameField);



        addressTF = new JTextField();
        addressTF.setBounds(675, 320, 285, 32);
        addressTF.setFont(font);
        addressTF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        this.add(addressTF);

        
        ownernumTF = new JTextField();
        ownernumTF.setBounds(675, 394, 285, 32);
        ownernumTF.setFont(font);
        ownernumTF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        this.add(ownernumTF);



        nextButton = new JButton("Next");
        nextButton.setBounds(502, 610, 95, 35);
        nextButton.setBackground(new Color(0, 0, 51));
        nextButton.setForeground(new Color(255, 255, 255));
        nextButton.setFont(font);
        nextButton.setFocusable(false);
        nextButton.addMouseListener(this);
        nextButton.addActionListener(this);
        this.add(nextButton);



        backButton = new JButton("Back");
        backButton.setBounds(870, 45, 85, 35);
        backButton.setBackground(new Color(0, 0, 51));
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setFont(font);
        backButton.setFocusable(false);
        backButton.addMouseListener(this);
        backButton.addActionListener(this);
        this.add(backButton);
       

    }

    public void mouseClicked(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    public void mouseEntered(MouseEvent me)
    {
        if(me.getSource() == nextButton)
        {
            nextButton.setBackground(Color.WHITE);
            nextButton.setForeground(new Color(0,0,51));
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
        if(me.getSource() == nextButton)
        {
            nextButton.setBackground(new Color(0, 0, 51));
            nextButton.setForeground(new Color(255, 255, 255));
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
        
       String command = e.getActionCommand();


       if(nextButton.getText().equals(command))
       {

        String adminUsername = s.usernameField.getText();
         

        Homepage h =new Homepage(adminUsername,s,this,em);
        Employee em =new Employee(adminUsername,s,this,h);
        

            
        Management m = new Management(s,h,em,this);
        m.setVisible(true);
        this.setVisible(false);

       }
       else 
       {}

     if(backButton.getText().equals(command))
     {

       s.setVisible(true);
      this.setVisible(false);

     }
     else 
     {}
                
        
    }

    
}
