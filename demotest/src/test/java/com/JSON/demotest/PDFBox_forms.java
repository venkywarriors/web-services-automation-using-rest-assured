import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class PDFBox_forms {

	private static PDDocument _pdfDocument;

	public static void main(String[] args) throws IOException {

		String originalPdf = "D:\\interactivePDFs\\OoPdfFormExample.pdf";
		String targetPdf = "D:\\interactivePDFs\\OoPdfFormExample_filled.pdf";

		populateAndCopy(originalPdf, targetPdf);

		System.out.println("Complete");
	}

	private static void populateAndCopy(String originalPdf, String targetPdf) throws IOException {
		_pdfDocument = PDDocument.load(new File(originalPdf));

		_pdfDocument.getNumberOfPages();

		setField("Given Name Text Box", "Venkateshwara");
		setField("Family Name Text Box", "Doijode");
		setField("House nr Text Box", "120");
		setField("Gender List Box", "Woman");
		setField("Driving License Check Box", "Yes");

		_pdfDocument.save(targetPdf);
		_pdfDocument.close();
	}

	public static void setField(String name, String value) throws IOException {
		PDDocumentCatalog docCatalog = _pdfDocument.getDocumentCatalog();
		PDAcroForm acroForm = docCatalog.getAcroForm();
		PDField field = acroForm.getField(name);
		if (field != null) {
			field.setValue(value);
		} else {
			System.err.println("No field found with name:" + name);
		}
	}

}
