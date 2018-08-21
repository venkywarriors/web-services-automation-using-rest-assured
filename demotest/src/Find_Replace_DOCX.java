package test.pdfcompare;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public class Find_Replace_DOCX extends readExcel{
	
	
	public static String monthCodeSF(String monthCode)
	{
		Map<String, String> month= new HashMap<String, String>();
		month.put("NA" , "test1");
		month.put("February", "Feb");
		month.put("March", "Mar");
		month.put("December", "Dec");
		
		return month.get(monthCode);		
	}

	public static void main(String[] args) throws IOException,
	InvalidFormatException,
	org.apache.poi.openxml4j.exceptions.InvalidFormatException {
	
		String path = "C:\\Users\\705701\\Downloads\\";
		
		if (new File(path+"output_doc.docx").delete()) {
			 System.out.println(new File(path+"output_doc.docx").getName() + " is deleted!");
		}
		
		//          test_PDF
		
		 String rrr="[VZ20NA]"; 
		XWPFDocument doc = new XWPFDocument(OPCPackage.open(path+"test_PDF.docx"));
	    for (XWPFParagraph p : doc.getParagraphs()) {
	        List<XWPFRun> runs = p.getRuns();
	        if (runs != null) {
	            for (XWPFRun r : runs) {
	                String text = r.getText(0);
	                
	              
	                if (text != null && text.contains(rrr)) {
	                	
	                	 String temp1 =rrr.replace("[VZ", "").replace("]", "");
	            		  	
	                	     	String temp2=temp1.substring(0,2);
	                	     	String temp3=temp1.substring(2,4);
	                	     	
	                	     	int orginal_row=getOriginalRow("Credentials", "vendor_number",temp2);
	                	     	System.out.println(orginal_row);
	                	     	
	                	     	int col_number = getColumnnumber("Credentials", monthCodeSF(temp3));   	
	                	     	System.out.println(col_number);
	                	     	
	                	     	System.out.println(readData(col_number, orginal_row, "Credentials"));
	                   text = text.replace(rrr, readData(col_number, orginal_row, "Credentials"));
	                    r.setText(text, 0);
	                }
	            }
	        }
	    }
	   /* for (XWPFTable tbl : doc.getTables()) {
	        for (XWPFTableRow row : tbl.getRows()) {
	            for (XWPFTableCell cell : row.getTableCells()) {
	                for (XWPFParagraph p : cell.getParagraphs()) {
	                    for (XWPFRun r : p.getRuns()) {
	                        String text = r.getText(0);
	                        if (text != null && text.contains("{City}")) {
	                            text = text.replace("{City}", "New York");
	                            r.setText(text, 0);
	                        }
	                    }
	                }
	            }
	        }
	    }*/
	    	System.out.println("complete");
	        doc.write(new FileOutputStream(path+"output_doc.docx"));
	    	Desktop desktop = Desktop.getDesktop();
			// Returns the Desktop instance of the current browser context

			if ((new File(path+"output_doc.docx").exists()))
			{

				// Launches the associated application to open the file

				desktop.open((new File(path+"output_doc.docx")));
			}
		
	}

	}
