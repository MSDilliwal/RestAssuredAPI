package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Hp Lap
 *
 */
public class ExcelUtility {
/**
 * 
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @return
 * @throws EncryptedDocumentException
 * @throws FileNotFoundException
 * @throws IOException
 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(Iconstants.excelPath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row=sheet.getRow(rowNum);
		Cell cell =row.getCell(cellNum);
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(cell);
		return value;
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void insertIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(Iconstants.excelPath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(Iconstants.excelPath);
		workbook.write(fileOutputStream);
	}
    /**
     * 
     * @param sheetName
     * @return
     * @throws EncryptedDocumentException
     * @throws FileNotFoundException
     * @throws IOException
     */
	public int getLastNumFromExcel(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(Iconstants.excelPath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		return row;	
	}

}
