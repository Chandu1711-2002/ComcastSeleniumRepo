package PracticeContactsTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

public class CreateContactWithSupportDateTest {

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
				
				Date dateobj=new Date();
				
				//to get current date
				SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");  //MM should be in capital only
				String actualdate=sim.format(dateobj);
				//System.out.println(actualdate);
	
				//to get date after some days or before some days
				Calendar cal=sim.getCalendar();
				cal.add(Calendar.DAY_OF_MONTH, 30);
				String enddateRequires=sim.format(cal.getTime());
				//System.out.println(dateRequires);
				driver.findElement(By.name("support_start_date")).clear();
				driver.findElement(By.name("support_start_date")).sendKeys(actualdate);
				driver.findElement(By.name("support_end_date")).clear();
				driver.findElement(By.name("support_end_date")).sendKeys(enddateRequires);
			
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//verify header orgname information expected result
				
				String actualstartdate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
				if(actualdate.equals(actualstartdate))
				{
					System.out.println(actualdate +"is correct");
				}
				else
				{
					System.out.println(actualdate +"is not correct");
				}
				
				
				String actualenddate=driver.findElement(By.id("dtlview_Support End Date")).getText();
				if(enddateRequires.equals(actualenddate))
				{
					System.out.println(enddateRequires +"is correct");
				}
				else
				{
					System.out.println(enddateRequires +"is not correct");
				}
				
		}


	}



