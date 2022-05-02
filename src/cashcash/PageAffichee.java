package cashcash;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageAffichee implements ActionListener {

    private JButton btnXml;
    private JButton btnPdf;
    private JButton btnContrat;

    private JButton btnRetour;

    private String pageActuelle = "accueil";

    public JFrame pageAAfficher(){
        JFrame f = new JFrame("Cash Cash");
        switch(pageActuelle){
            case "accueil":
                accueil(f);
                break;
            case "xml":
                retour(f);
                xml(f);
                break;
            case "pdf":
                retour(f);
                pdf(f);
            case "contrat":
                retour(f);
                contrat(f);
                break;
        }
        return f;
    }

    public void accueil(JFrame f){
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

    public void retour(JFrame f){
        btnRetour = new JButton("Retour");
        btnRetour.setBounds(0, 0, 100, 50);
        btnRetour.addActionListener(this);


        f.add(btnRetour);
    }

    public void xml(JFrame f){

    }

    public void pdf(JFrame f){

    }

    public void contrat(JFrame f){

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
        pageAAfficher();
    }

    public String getPageActuelle(){
        return pageActuelle;
    }
}
