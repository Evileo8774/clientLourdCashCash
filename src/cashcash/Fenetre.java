package cashcash;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Fenetre {
    public	final static int HT = 1550;
    public 	final static int LG = 800;
    public	final static int X = 150;
    public 	final static int Y = 200;
    public Fenetre(){


        PageAffichee p = new PageAffichee();
        JFrame f = p.pageAAfficher();



        f.setBounds(X, Y, HT, LG);
        f.setBackground(Color.darkGray);

        f.setLayout(null);
        f.setVisible(true);
    }
}
