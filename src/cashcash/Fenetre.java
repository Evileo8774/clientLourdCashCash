package cashcash;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Fenetre {
    public	final static int HT = 1500;
    public 	final static int LG = 800;
    public	final static int X = 150;
    public 	final static int Y = 200;
    public Fenetre(){
        JFrame F = new JFrame("Cash Cash");
        F.setBounds(X, Y, HT, LG);
        F.setBackground(Color.darkGray);
        F.setVisible(true);
    }
}
