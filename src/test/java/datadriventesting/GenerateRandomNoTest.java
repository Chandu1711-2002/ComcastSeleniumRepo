package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenerateRandomNoTest {

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
		    else if(browser.equals("firefox"))
		    {
		    	driver=new FirefoxDriver();
		    }
		    else if(browser.equals("edge"))
		    {
		    	driver=new EdgeDriver();
		    }
		    else
		    {
		    	driver=new ChromeDriver();
		    }
		    
		    
		    Random ran=new Random();
			   int random=  ran.nextInt(1000);
				//System.out.println(random);
			   
			   driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Thread.sleep(2000);
				driver.get(url);
				driver.findElement(By.name("user_name")).sendKeys(username);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
				//read test script data from excel 
				FileInputStream fis2=new FileInputStream("C:\\Users\\srinivasa rao\\Downloads\\EXcel_TestData\\ReaddataWithCondition.xlsx");
				Workbook wb=WorkbookFactory.create(fis2);
				Sheet sheet=wb.getSheet("Sheet1");
				String data=sheet.getRow(1).getCell(2).toString() +random;
				String data2=sheet.getRow(1).getCell(3).toString();
				driver.findElement(By.linkText("Organizations")).click();
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();	
				
				driver.findElement(By.name("accountname")).sendKeys(data);
				driver.findElement(By.name("ship_street")).sendKeys(data2);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				driver.close();

	}

}
