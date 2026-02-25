package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\srinivasa rao\\Downloads\\EXcel_TestData\\ReadMultipleData.xlsx");
        Workbook wb=WorkbookFactory.create(fis);
       Sheet sheet= wb.getSheet("Sheet1");
//     System.out.println(sheet.getRow(1).getCell(0).toString());
//     System.out.println(sheet.getRow(1).getCell(1).toString());
       int row= sheet.getPhysicalNumberOfRows();
       //int rowcount=sheet.getLastRowNum();
       int cols=sheet.getRow(0).getPhysicalNumberOfCells();
       for(int i=1;i<=row-1;i++)
       {
    	   for(int j=0;j<=cols-1;j++)
    	   {
    		   System.out.print(sheet.getRow(i).getCell(j).toString()+" ");
    	   }
    	   System.out.println();
       }
       
	}

}
