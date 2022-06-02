package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getTotalRows(String excelFile, String SheetName) throws IOException {
		fis = new FileInputStream(excelFile);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(SheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
	//	int rowCount = sheet.getLastRowNum();
		System.out.println("Total Rows:  "+rowCount);
		return rowCount;
	}
	
	public static int getTotalColumns(String excelFile, String SheetName, int rowNum) throws IOException {
		fis = new FileInputStream(excelFile);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(SheetName);
		row = sheet.getRow(rowNum);
//		int colCount = sheet.getRow(1).getPhysicalNumberOfCells();
		int colCount = row.getLastCellNum();
		System.out.println("Total Columns:  "+colCount);
		return colCount;
	}
	
	public static String getCellData(String excelFile, String SheetName, int rownum, int colnum) throws IOException {
		fis = new FileInputStream(excelFile);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(SheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try {
		DataFormatter formatter = new DataFormatter();
		String cellData = formatter.formatCellValue(cell);
		return cellData;
		}
		catch (Exception e) {
			data="";
		}
		wb.close();
		fis.close();
		return data;
	}	


public static void setCellData(String excelFile, String SheetName, int rownum, int colnum, String data) throws IOException {
		fis = new FileInputStream(excelFile);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(SheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		cell.setCellValue(data);
		fos = new FileOutputStream(excelFile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
}
}