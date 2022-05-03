package cashcash;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreerXML {
	
	public static void main(String args[]) {
		 
	      try {
	 
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
	 
	        // élément de racine
	        Document doc = docBuilder.newDocument();
	        Element racine = doc.createElement("repertoire");
	        doc.appendChild(racine);
	 
	        // matériel
	        Element nserie = doc.createElement("nserie");
	        racine.appendChild(nserie);
	 
	        // numéro de série
	        Attr attr = doc.createAttribute("Numero");
	        attr.setValue("1648321484");
	        nserie.setAttributeNode(attr);
	 
	        // date de vente
	        Element dateVente = doc.createElement("dateVente");
	        dateVente.appendChild(doc.createTextNode("01/01/2000"));
	        nserie.appendChild(dateVente);
	 
	        // date d'installation
	        Element dateInstallation = doc.createElement("dateInstallation");
	        dateInstallation.appendChild(doc.createTextNode("01/01/2000"));
	        nserie.appendChild(dateInstallation);
	 
	        // nom du matériel
	        Element nomMateriel = doc.createElement("nom");
	        nomMateriel.appendChild(doc.createTextNode("terminal-40"));
	        nserie.appendChild(nomMateriel);
	  
	        // numéro de contrat
	        Element numeroContrat = doc.createElement("numeroContrat");
	        numeroContrat.appendChild(doc.createTextNode("45"));
	        nserie.appendChild(numeroContrat);
	        
	        // date de signature du contrat
	        Element dateSignature = doc.createElement("dateSignatureContrat");
	        dateSignature.appendChild(doc.createTextNode("01/01/2000"));
	        nserie.appendChild(dateSignature);
	        
	        // date de signature du contrat
	        Element dateEcheance = doc.createElement("dateEcheanceContrat");
	        dateEcheance.appendChild(doc.createTextNode("01/01/2001"));
	        nserie.appendChild(dateEcheance);
	        
	        // date de signature du contrat
	        Element refContrat = doc.createElement("refContrat");
	        refContrat.appendChild(doc.createTextNode("198154"));
	        nserie.appendChild(refContrat);
	 
	        // écrire le contenu dans un fichier XML
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        DOMSource source = new DOMSource(doc);
	        StreamResult resultat = new StreamResult(new File("test.xml"));
	 
	        transformer.transform(source, resultat);
	 
	        System.out.println("Fichier sauvegardé avec succès!");
	 
	     } catch (ParserConfigurationException pce) {
	         pce.printStackTrace();
	     } catch (TransformerException tfe) {
	         tfe.printStackTrace();
	     }
	  }
	}
