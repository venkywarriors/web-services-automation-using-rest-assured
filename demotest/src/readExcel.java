package test.pdfcompare;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class readExcel extends BaseTest {

	@SuppressWarnings("deprecation")
	public static String readData(int coloum, int rows, String sheetname) throws IOException {

		String data = null;
		Workbook wb = null;
		String fileName = "Testdata.xlsx";
		FileInputStream fileInputStream = new FileInputStream(fileName);
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			wb = new XSSFWorkbook(fileInputStream);
		} else if (fileExtensionName.equals(".xls")) {
			wb = new HSSFWorkbook(fileInputStream);
		}
		Sheet sheet = wb.getSheet(sheetname);
		Row row = sheet.getRow(rows);
		Cell cell = row.getCell(coloum);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			// System.out.println("string:" +cell.getStringCellValue()+"::");
			data = cell.getStringCellValue();
		}
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			// System.out.println("numeric: " + cell.getNumericCellValue());
		}

		data = cell.toString();
		return data;
	}

	@SuppressWarnings("resource")
	public static  int getColumnnumber(String sheetName, String colName) throws IOException {

		FileInputStream fis = new FileInputStream("Testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(0);
		int col_Num = 0;
		int colNum = row.getLastCellNum();
		for (int i = 0; i < colNum; i++) {
			try{
			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
				col_Num = i;
			}
			catch (Exception e) {
				continue;
			}
		}
		System.out.println("Column number : " + col_Num);
		return col_Num;
	}
	
	
	public static  int getOriginalRow(String sheetName, String colName,String tosearch) throws IOException {

		int gg = getColumnnumber(sheetName,colName);
		int ggdd = getTotalRows(sheetName,colName);
		int returnRowNumber = 0;
		for(int i=1;i<=ggdd;i++)
		{
			try{
			String uuu = readData(gg, i, sheetName);
			if(uuu.equalsIgnoreCase(tosearch))
			{
				returnRowNumber=i;
				break;
				
			}
			}
			catch (Exception e) {
				continue;
			}
		}
		System.out.println(returnRowNumber);
		return returnRowNumber;

	}
	
	@SuppressWarnings("resource")
	public static  int getTotalRows(String sheetName, String colName) throws IOException {

		FileInputStream fis = new FileInputStream("Testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rowNum = sheet.getLastRowNum();
		System.out.println("Total Number of rows in the excel is : " + rowNum);
		return rowNum;

	}

	
/*	public  static void main(String[] args) throws Exception {
		
		int uuu = getOriginalRow("Credentials", "NA","33");
		System.out.println(uuu);

		

	}*/
}
