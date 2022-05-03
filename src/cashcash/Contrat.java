package cashcash;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Contrat {

    //stockage de la connexion à la bdd
    private Connection cnx;

    public Contrat(Connection cnx){
        this.cnx = cnx;
    }

    public String[][] getMateriel(){ //fonction retournant le materiel
        try {
            String query = "SELECT numSerie, dateVente, dateInstall, ref, numClient FROM materiel"; //requête sql

            Statement st = cnx.createStatement(); //équivalent en pdo : $req = $cnx->prepare($query);

            ResultSet rs = st.executeQuery(query); //équivalent en pdo : $req->execute();

            //on stocke dans arrayY l'index de la dernière ligne du résultat, on se replace ensuite à la 1ère ligne.
            int arrayY = 0;
            if(rs.last()) arrayY = rs.getRow();
            rs.beforeFirst();

            //on crée un tableau à 2 dimensions ayant pour hauteur, le nombre de lignes retournées par la requête et pour largeur, le nombre d'occurences retournées (voir la requête sql)
            String[][] data = new String[arrayY][5];

            //on attribue aux cases du tableau les valeurs de la requête
            int i = 0;
            while(rs.next()){
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getString(4);
                data[i][4] = rs.getString(5);
                i++;
            }

            st.close(); //on ferme la connexion à la bdd
            return data; //on retourne le tableau de données
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
