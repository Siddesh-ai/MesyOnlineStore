package ecommerce.mecys.genericutility.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Throwable {

		FileInputStream fis = new FileInputStream("D:\\Selenium_Workspace\\fashion\\src\\main\\resources\\mesysOnlineStoreDataxlsx.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}

	public int getRowcount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("D:\\Selenium_Workspace\\fashion\\src\\main\\resources\\mesysOnlineStoreDataxlsx.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;	
	}
	
	public double getIntDataFromExcel(String sheetName, int rowNum, int celNum) throws Throwable {

		FileInputStream fis = new FileInputStream("D:\\Selenium_Workspace\\fashion\\src\\main\\resources\\mesysOnlineStoreDataxlsx.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		double data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getNumericCellValue();
		wb.close();
		return data;
	}


	public void setDataIntoExcel(String sheetName, int rowNum, int celNum, String Data) throws Throwable {
		FileInputStream fis = new FileInputStream("D:\\Selenium_Workspace\\fashion\\src\\main\\resources\\mesysOnlineStoreDataxlsx.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);

		FileOutputStream fos = new FileOutputStream("./testdata/testScriptData.xlsx");
		wb.write(fos);
		wb.close();

	}
}
