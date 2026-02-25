package PracticeContactsTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateContactTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\srinivasa rao\\Downloads\\commondata.properties");
		 Properties prop=new Properties();
		 prop.load(fis);
		 String browser=prop.getProperty("browser");
		 String url=prop.getProperty("url");
		 String username=prop.getProperty("username");
		 String password=prop.getProperty("password");
		
		 
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
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("Contacts")).click();
			
			//generate the random number
			 Random ran=new Random();
			 int randomint=ran.nextInt(2000);
			 
			 //read testscript data from excel file
			 FileInputStream fis2 =new FileInputStream("C:\\Users\\srinivasa rao\\Downloads\\EXcel_TestData\\ReaddataWithCondition.xlsx");
			 Workbook wb=WorkbookFactory.create(fis2);
			 Sheet sheet=wb.getSheet("con");
			 Row row=sheet.getRow(1);
			 String lastname=row.getCell(2).toString()+randomint;
			// String sadd=row.getCell(3).toString();
			 wb.close();
				
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();	
				driver.findElement(By.name("lastname")).sendKeys(lastname);
			
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//verify header orgname information expected result
				
				String actuallastname=driver.findElement(By.id("dtlview_Last Name")).getText();
				if(lastname.equals(actuallastname))
				{
					System.out.println(lastname +"is created");
				}
				else
				{
					System.out.println(lastname +"is not created");
				}
		}

}
