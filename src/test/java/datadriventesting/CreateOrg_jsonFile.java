package datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrg_jsonFile {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		
		//read common data from json file
		        //step 1:parse json physical file into java object representation using jsonparse class
				JSONParser parser=new JSONParser();
				//step 2:read the data from physical file and convert into json object using parse()
			    Object obj=	parser.parse(new FileReader("C:\\Users\\srinivasa rao\\Downloads\\EXcel_TestData\\JSon_testdata.json"));
				//step 3:downcast the java object into json object
		        JSONObject map=(JSONObject)obj;
		        
		 String url=(String)map.get("url");
		 String un=(String)map.get("username");
		 String pwd=(String)map.get("password");
		 String browser=(String)map.get("browser");
		 
		 //generate the random number
		 Random ran=new Random();
		 int randomint=ran.nextInt(1000);
		 
		 //read testscript data from excel file
		 FileInputStream fis =new FileInputStream("C:\\Users\\srinivasa rao\\Downloads\\EXcel_TestData\\ReaddataWithCondition.xlsx");
		 Workbook wb=WorkbookFactory.create(fis);
		 Sheet sheet=wb.getSheet("Sheet1");
		 Row row=sheet.getRow(1);
		 String orgname=row.getCell(2).toString()+randomint;
		 String sadd=row.getCell(3).toString();
		 wb.close();
		 

		   WebDriver driver=null;
		   if(browser.equals("chrome"))
		   {
			   driver=new ChromeDriver();
		   }
		   else
		   {
			   driver=new FirefoxDriver();
		   }
		    driver.get(url);
			driver.findElement(By.name("user_name")).sendKeys(un);
			driver.findElement(By.name("user_password")).sendKeys(pwd);
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("Organizations")).click();
			
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();	
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			driver.findElement(By.name("ship_street")).sendKeys(sadd);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}


	
}
