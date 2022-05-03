package cashcash;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fenetre implements ActionListener {

    //variables permettant la gestion de la taille de la fenêtre
    public	final static int HT = 1550;
    public 	final static int LG = 800;
    public	final static int X = 150;
    public 	final static int Y = 200;

    //fenêtre
    private JFrame f;

    //boutons
    private JButton btnXml;
    private JButton btnPdf;
    private JButton btnContrat;
    private JButton btnRetour;

    private Connection cnx;

    //variable permettant de savoir sur quelle page on se situe, par défaut, la page d'accueil
    private String pageActuelle = "accueil";

    //constructeur, permet la génération de la page d'accueil
    public Fenetre(Connection connexion){
        f = new JFrame("Cash Cash");
        accueil();
        f.setBounds(X, Y, HT, LG);
        f.setBackground(Color.darkGray);
        f.setLayout(null);
        f.setVisible(true);

        cnx = connexion;
    }

    //permet la génération d'une nouvelle fenêtre
    public void initNewFrame(){
        f = new JFrame("Cash Cash "+pageActuelle);
        f.setBounds(X, Y, HT, LG);
        f.setBackground(Color.darkGray);
        f.setLayout(null);
    }

    //permet d'afficher un certain contenu dans la fenêtre en fonction de la variable pageActuelle
    public void displayFrame(){
        f.setVisible(false); //on détruit la fenêtre actuelle
        initNewFrame(); //on en génère une nouvelle
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

    //génère la page d'accueil
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

    //création du bouton permettant de retourner à la page d'accueil
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
        Contrat c = new Contrat(cnx);

    }

    //gestion des clics sur les différents boutons
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
        displayFrame();
    }
}
