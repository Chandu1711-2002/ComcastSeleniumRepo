package PracticeOrgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgWithIndustriesTest {

	public static void main(String[] args) throws IOException, InterruptedException {
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
			
			driver.findElement(By.linkText("Organizations")).click();
			
			//generate the random number
			 Random ran=new Random();
			 int randomint=ran.nextInt(2000);
			 
			//read testscript data from excel file
			 FileInputStream fis2 =new FileInputStream("C:\\Users\\srinivasa rao\\Downloads\\EXcel_TestData\\ReaddataWithCondition.xlsx");
			 Workbook wb=WorkbookFactory.create(fis2);
			 Sheet sheet=wb.getSheet("Sheet1");
			 Row row=sheet.getRow(4);
			 String orgname=row.getCell(2).toString()+randomint;
			 String sadd=row.getCell(3).toString();
			 String industry=row.getCell(4).toString();
			 String type=row.getCell(5).toString();
			 wb.close();
				
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();	
				driver.findElement(By.name("accountname")).sendKeys(orgname);
				driver.findElement(By.name("ship_street")).sendKeys(sadd);
				WebElement dd1=driver.findElement(By.name("industry"));
				Select s=new Select(dd1);
				WebElement dd2=driver.findElement(By.name("accounttype"));
				Select s1=new Select(dd2);
				s.selectByVisibleText(industry);
				s1.selectByVisibleText(type);
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				Thread.sleep(1000);
				//validation
				if(driver.findElement(By.id("dtlview_Industry")).getText().equals(industry))
				{
					System.out.println("pass");
				}
				else
				{
					System.out.println("fail");
				}
				
				if(driver.findElement(By.id("dtlview_Type")).getText().equals(type))
				{
					System.out.println("pass");
				}
				else
				{
					System.out.println("fail");
				}
	}

}
