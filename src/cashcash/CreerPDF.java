package cashcash;

//import
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Logger;


public class CreerPDF {

	public static void main(String[]args)throws DocumentException {
		// effectuer un try catch pour les exceptions
		try {
			//cr�ation du document avec le name
			Document pdfDoc = new Document();
			String name = "testt.pdf";
			PdfWriter.getInstance(pdfDoc, new FileOutputStream(name));

			//ouverture du document
			pdfDoc.open();

			//ce que contient le PDF
			Phrase header = new Phrase("Bonjour � vous\n\n" +
					"Je me permets de vous contacter concernant le mat�riel avec le num�ro de s�rie: 14 26 34 18 34.\n" +
					"Merci de me confirmer ci-joint l'avanc� pour la commande.\n" +
					"Merci � vous et bonne journ�e\n\n" +
					"Cordialement,\n" +
					"LeGourpe V de V.");

			pdfDoc.add(header);
			//fermeture du document PDF
			pdfDoc.close();

			//certification que le PDF est bien cr�e
			System.out.println("PDF bien cr�e");

		} catch (FileNotFoundException DocumentException) {
			Logger.getLogger(CreerPDF.class.getName());
		}
	}
}

