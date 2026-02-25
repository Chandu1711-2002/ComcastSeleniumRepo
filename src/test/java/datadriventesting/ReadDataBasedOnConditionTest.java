package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnConditionTest 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\srinivasa rao\\Downloads\\EXcel_TestData\\ReaddataWithCondition.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet("Sheet1");
		/*String expectedTestcaseId="tc_02";
		int rowCount=sheet.getLastRowNum();
		for(int i=0;i<=rowCount;i++)
		{
			//String data="";
			try {
			String data=sheet.getRow(i).getCell(0).toString();
			if(data.equals(expectedTestcaseId))
{
	System.out.println(sheet.getRow(i).getCell(0).toString());
	System.out.println(sheet.getRow(i).getCell(1).toString());
	System.out.println(sheet.getRow(i).getCell(2).toString());
	System.out.println(sheet.getRow(i).getCell(3).toString());
	
}
			}catch(Exception e)
			{
				
			}
			
		}*/
		
		//test case condition is not available
		String expectedTestcaseId="tc_100";
		boolean found=false;
		int rowCount=sheet.getLastRowNum();
		for(int i=0;i<=rowCount;i++)
		{
			//String data="";
			try {
			String data=sheet.getRow(i).getCell(0).toString();
			if(data.equals(expectedTestcaseId))
             {
				found=true;
	          System.out.println(sheet.getRow(i).getCell(0).toString());
	          System.out.println(sheet.getRow(i).getCell(1).toString());
	          System.out.println(sheet.getRow(i).getCell(2).toString());
	          System.out.println(sheet.getRow(i).getCell(3).toString());
	          
               }
			}catch(Exception e)
			{
				
			}
		}
			if(!found)
			{
				System.out.println(expectedTestcaseId +" is not available");
			}
			
		}
		

		
}
