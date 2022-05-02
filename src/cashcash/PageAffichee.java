package cashcash;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageAffichee implements ActionListener {
    public void accueil(JFrame f){
        JButton btnXml = new JButton("Génération de fichier xml");
        btnXml.setBounds(200, 100, 250, 50);
        btnXml.addActionListener(this);

        JButton btnPdf = new JButton("Génération de courrier de relance");
        btnPdf.setBounds(650, 100, 250, 50);

        JButton btnContrat = new JButton("Contrats de maintenance");
        btnContrat.setBounds(1100, 100, 250, 50);

        f.add(btnXml);
        f.add(btnPdf);
        f.add(btnContrat);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You have clicked the button");
    }
}
