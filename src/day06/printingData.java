package day06;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.SheetBuilder;

public class printingData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//creating path for the file 
	   String path = "./TestData/Book1.xlsx";
	   FileInputStream fin = new FileInputStream(path);
	   
	   // creating workbook 
	   Workbook workbook = WorkbookFactory.create(fin);
	   
	   //selecting sheet
	   Sheet sheet = workbook.getSheet("DemoWebShop");
	   
	   //selecting row 
	   Row row = sheet.getRow(4);
	   
	   //selecting cell
	   Cell cell = row.getCell(2);
	   
	   String email = cell.getStringCellValue() ;
	   System.out.println(email);
	   
	   
	   

	}

}
