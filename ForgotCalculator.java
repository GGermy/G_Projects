
import java.util.*;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class ForgotCalculator implements ActionListener
{
    JFrame f;
    Label l1,l2,l3,ll;
    Button b1,b2,b3,b4,b5,b6;
    TextField t1,t2,t3;
    String res="";
    ForgotCalculator()
    {
        f=new JFrame("Simple Calculator");
        l1=new Label (" First Number: ");
        l1.setBounds(50,50,150,50);
        Font fb1 = new Font("Times New Roman", Font.BOLD, 20);
        l1.setFont(fb1);

        t1 = new TextField();
        t1.setBounds(250,60,150,30);
        f.add(t1);
        f.add(l1);

        l2=new Label (" Second Number: ");
        l2.setBounds(50,100,200,50);
        Font fb2 = new Font("Times New Roman", Font.BOLD, 20);
        l2.setFont(fb2);

        t2 = new TextField();
        t2.setBounds(250,110,150,30);
        f.add(t2);
        f.add(l2);

        l3=new Label (" Result: ");
        l3.setBounds(50,150,80,50);
        Font fb3 = new Font("Times New Roman", Font.BOLD, 20);
        l3.setFont(fb3);
        f.add(l3);

        b1=new Button(" ADD ");
        b1.setBounds(80,250,130,30);
        f.add(b1);

        Font fb4 = new Font("Times New Roman", Font.BOLD, 15);
        b1.setFont(fb4);

        b1.addActionListener(this);

        b2=new Button(" SUBTRACT ");
        b2.setBounds(250,250,130,30);
        f.add(b2);

        Font fb5 = new Font("Times New Roman", Font.BOLD, 15);
        b2.setFont(fb5);

        b2.addActionListener(this);

        b3=new Button(" MULTIPLY ");
        b3.setBounds(80,320,130,30);
        f.add(b3);

        Font fb6 = new Font("Times New Roman", Font.BOLD, 15);
        b3.setFont(fb6);

        b3.addActionListener(this);

        b4=new Button(" DIVIDE ");
        b4.setBounds(250,320,130,30);
        f.add(b4);

        Font fb7 = new Font("Times New Roman", Font.BOLD, 15);
        b4.setFont(fb7);

        b4.addActionListener(this);

        b5=new Button(" RESET ");
        b5.setBounds(80,390,130,30);
        f.add(b5);

        Font fb8 = new Font("Times New Roman", Font.BOLD, 15);
        b5.setFont(fb8);

        b5.addActionListener(this);

        b6=new Button(" QUIT ");
        b6.setBounds(250,390,130,30);
        f.add(b6);

        Font fb9 = new Font("Times New Roman", Font.BOLD, 15);
        b6.setFont(fb9);

        b6.addActionListener(this);

        t3=new TextField ();
        t3.setBounds(130,160,300,30);
        Font fb0 = new Font("Times New Roman", Font.BOLD, 20);
        t3.setFont(fb0);
        f.add(t3);

        f.setLayout(null);
        f.setSize(500,600);
        f.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            res=Double.parseDouble(t1.getText())+Double.parseDouble(t2.getText())+"";
            t3.setText(res);
        }
        else if(e.getSource()==b2)
        {
            res=Double.parseDouble(t1.getText())-Double.parseDouble(t2.getText())+"";
            t3.setText(res);
        }
        else if(e.getSource()==b3)
        {
            res=Double.parseDouble(t1.getText())*Double.parseDouble(t2.getText())+"";
            t3.setText(res);
        }
        else if(e.getSource()==b4)
        {
            res=Double.parseDouble(t1.getText())/Double.parseDouble(t2.getText())+"";
            t3.setText(res);

        }
        else if(e.getSource()==b5)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");

        }
        else if(e.getSource()==b6)
        {
            JOptionPane.showMessageDialog(f,"This will terminate the program!.");
            f.dispose();
        }
    }
    public static void main(String args[])
    {
        new ForgotCalculator();
    }
}