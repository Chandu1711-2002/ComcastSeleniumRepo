package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		//step 1:get the excel path location and java object of physical excel file
		FileInputStream fis=new FileInputStream("C:\\Users\\srinivasa rao\\Downloads\\EXcel_TestData\\TestScriptData.xlsx");
		//step 2:open workbook in read mode
	    Workbook wb=   WorkbookFactory.create(fis);
		
		//step 3:get the control of org sheet
		Sheet sheet=wb.getSheet("org");  // we should get the sheet from ss usermodel only
		//step 4:get the control of first row
		Row r=sheet.getRow(1);
		//step 5:get the control of 2nd cell and read the string data
		Cell c=r.getCell(2);
	    System.out.println(c.getNumericCellValue());
		//step 6:close the workbook
	    wb.close();
	}

}
