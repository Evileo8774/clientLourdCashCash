package cashcash;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Fenetre implements ActionListener {

    public	final static int HT = 1550;
    public 	final static int LG = 800;
    public	final static int X = 150;
    public 	final static int Y = 200;

    private JFrame f;

    private JButton btnXml;
    private JButton btnPdf;
    private JButton btnContrat;

    private JButton btnRetour;

    private String pageActuelle = "accueil";

    public Fenetre(){
        f = new JFrame("Cash Cash");
        accueil();
        f.setBounds(X, Y, HT, LG);
        f.setBackground(Color.darkGray);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void initNewFrame(){
        f = new JFrame("Cash Cash");
        f.setBounds(X, Y, HT, LG);
        f.setBackground(Color.darkGray);
        f.setLayout(null);
    }

    public void displayFrame(){
        f.setVisible(false);
        initNewFrame();
        switch(pageActuelle){
            case "accueil":
                accueil();
                break;
            case "xml":
                retour();
                xml();
                break;
            case "pdf":
                retour();
                pdf();
            case "contrat":
                retour();
                contrat();
                break;
        }
        f.setVisible(true);
    }

    public void accueil(){
        btnXml = new JButton("Génération de fichier xml");
        btnXml.setBounds(200, 100, 250, 50);
        btnXml.addActionListener(this);

        btnPdf = new JButton("Génération de courrier de relance");
        btnPdf.setBounds(650, 100, 250, 50);
        btnPdf.addActionListener(this);

        btnContrat = new JButton("Contrats de maintenance");
        btnContrat.setBounds(1100, 100, 250, 50);
        btnContrat.addActionListener(this);

        f.add(btnXml);
        f.add(btnPdf);
        f.add(btnContrat);
    }

    public void retour(){
        btnRetour = new JButton("Retour");
        btnRetour.setBounds(0, 0, 100, 50);
        btnRetour.addActionListener(this);


        f.add(btnRetour);
    }

    public void xml(){

    }

    public void pdf(){

    }

    public void contrat(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnXml){
            pageActuelle = "xml";
        } else if(e.getSource() == btnPdf){
            pageActuelle = "pdf";
        } else if(e.getSource() == btnContrat){
            pageActuelle = "contrat";
        } else {
            pageActuelle = "accueil";
        }
        System.out.println(pageActuelle);
        displayFrame();
    }
}
