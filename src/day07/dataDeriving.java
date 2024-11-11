package day07;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellAddress;

public class dataDeriving {

	public static void main(String[] args) {

		String firstName = getCellDataFromExcel("DemoWebShop", 1, 0);
		String lastName = getCellDataFromExcel("DemoWebShop", 1, 1);
		String email = getCellDataFromExcel("DemoWebShop", 1, 2);
		String password = getCellDataFromExcel("DemoWebShop", 1, 3);
		String confirmPassword = getCellDataFromExcel("DemoWebShop", 1, 4);

		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(email);
		System.out.println(password);
		System.out.println(confirmPassword);
		
		System.out.println("============================================");
		
		String[] rowData = getRowDataFromExcel("DemoWebShop", 0);
		for( String cellData : rowData )
		{
			System.out.println( cellData );
		}
		
		System.out.println("============================================");
		
		String[][] sheetData = getAllDataFromExcel("DemoWebShop") ;
		for (String[] rowdata : sheetData) 
		{
			for( String cellData : rowdata )
			{
				System.out.print( cellData + "      ");
			}
			System.out.println();
		}

	}

	public static String getCellDataFromExcel(String sheetName, int rowIndex, int cellIndex) {

		try {
			String path = "./TestData/Book1.xlsx";
			FileInputStream fin = new FileInputStream(path);

			Workbook workbook = WorkbookFactory.create(fin);

			Sheet sheet = workbook.getSheet(sheetName);

			Row row = sheet.getRow(rowIndex);

			Cell cell = row.getCell(cellIndex);

			String data = cell.getStringCellValue();

			return data;
		} catch (Exception e) {
			System.out.println("something went wrong");
		}
		return null;

	}

	public static String[] getRowDataFromExcel(String sheetName, int rowIndex) {

		try {

			String path = "./TestData/Book1.xlsx";
			FileInputStream fin = new FileInputStream(path);

			Workbook workbook = WorkbookFactory.create(fin);

			Sheet sheet = workbook.getSheet(sheetName);

			Row row = sheet.getRow(rowIndex);

			int cellSize = row.getPhysicalNumberOfCells();

			String[] rowData = new String[cellSize];

			// Getting cell data
			for (int i = 0; i < cellSize; i++) {
				Cell cell = row.getCell(i);
				String data = cell.getStringCellValue();
				rowData[i] = data;
			}

			return rowData;
		} catch (Exception e) {
			System.out.println("something went wrong");
		}
		return null;

	}
	public static String[][] getAllDataFromExcel(String sheetName) {
		try {
			
			String path = "./TestData/Book1.xlsx";
			FileInputStream fin = new FileInputStream(path);
			Workbook workbook = WorkbookFactory.create(fin);
			Sheet sheet = workbook.getSheet(sheetName);
			int rowSize = sheet.getPhysicalNumberOfRows() ;
			String[][] sheetData = new String[ rowSize ][] ;
			
			for( int i = 0 ; i < rowSize ; i++ )
			{
				Row row = sheet.getRow(i) ;
				int cellSize = row.getPhysicalNumberOfCells() ;
				sheetData[i] = new String[cellSize];
				
				for(int j = 0 ; j < cellSize ; j++ )
				{
					Cell cell = row.getCell(j);
					String data = cell.getStringCellValue();
					sheetData[i][j] = data ;
				}
				
			}
			return sheetData;
		} catch (Exception e) {
			System.out.println("something went wrong");
		}
		return null;
		
	}

}
