package day07;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PrintExcelData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
      
		
		String path = "./TestData/Book1.xlsx";
		FileInputStream fin = new FileInputStream(path);

		Workbook workbook = WorkbookFactory.create(fin);

		Sheet sheet = workbook.getSheet("DemoWebShop");
		
		int rowSize = sheet.getPhysicalNumberOfRows();
		
	     for (int i = 0 ; i< rowSize; i++) {
	    	 
	    	 Row row = sheet.getRow(i);
	    	 
	    	 int cellSize = row.getPhysicalNumberOfCells();
	    	 
	    	 for (int j = 0 ; j<cellSize ; j++) {
	    		 
	    		 Cell cell = row.getCell(j);
	    		 
	    		 String data = cell.getStringCellValue();
	    		 System.out.println(data);
	    	 }
	    	 System.out.println("=============================");
	     }

	}

}
