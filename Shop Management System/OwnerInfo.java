import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OwnerInfo extends  JFrame implements ActionListener,MouseListener
{

    ImageIcon icon;
    JLabel ownerinfo,oName,oAdderess,oNum,cShop,frameImage;
    JPanel leftPanel;
    JButton backButton;
    Font font;
    Shop s;
    Homepage h;
    Employee em;
    Owner o;
   
 
    
    public OwnerInfo(String Ownername,String OwnerLocation, String OwnerNum, Shop s,Homepage h,Employee em, Owner o)
    {

    	
        this.s =s;
        this.h=h;
        this.em=em;
        this.o = o;
       

        font = new Font("Arial Rounded MT Bold", 0, 18);


        this.setTitle("Shop Management System");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        leftPanel = new JPanel();
        leftPanel.setBounds(0,0,400,600);
        leftPanel.setBackground(new Color(0, 0, 51));
        leftPanel.setLayout(null);
        this.add(leftPanel);


        ImageIcon icon =new ImageIcon("Image/iconmonstr-info-7-240.png");
        frameImage = new JLabel(icon);
        frameImage.setBounds(0,100,400,400);
        leftPanel.add(frameImage);
        this.add(leftPanel);


        ownerinfo = new JLabel("Owner Information");
        ownerinfo.setBounds(30, 50, 400, 45);
        ownerinfo.setForeground(new Color(255, 255, 255));
        ownerinfo.setFont(new Font("Arial Rounded MT Bold",0,32));
        leftPanel.add(ownerinfo);
        this.add(leftPanel);


        oName = new JLabel("Owner name : "+Ownername );
        oName.setBounds(450, 200, 400, 45);
        oName.setForeground(new Color(0, 0, 51));
        oName.setFont(font);
        this.add(oName);


        oAdderess = new JLabel("Owner Address : "+OwnerLocation );
        oAdderess.setBounds(450, 250, 400, 45);
        oAdderess.setForeground(new Color(0, 0, 51));
        oAdderess.setFont(font);
        this.add(oAdderess);


        oNum = new JLabel("Owner Number : "+OwnerNum );
        oNum.setBounds(450, 300, 400, 45);
        oNum.setForeground(new Color(0, 0, 51));
        oNum.setFont(font);
        this.add(oNum);



        cShop = new JLabel("Profile");
        cShop.setBounds(450, 50, 300, 35);
        cShop.setForeground(new Color(0, 0, 51));
        cShop.setFont(new Font("Arial Rounded MT Bold", 0, 24));
        this.add(cShop);


        backButton = new JButton("Back");
        backButton.setBounds(450, 500, 85, 35);
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
        if(me.getSource() == backButton)
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
        if(me.getSource() == backButton)
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
         if (e.getSource() == backButton)


         {
            

                     Management m = new Management(s,h,em,o);
                    m.setVisible(true);
                    this.setVisible(false);




         }
         else 
         {}
     }

        
}