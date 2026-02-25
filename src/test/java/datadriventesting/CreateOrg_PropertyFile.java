package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrg_PropertyFile {
	public static void main(String[] args) throws IOException
	{
		//WebDriver driver=new ChromeDriver();
		//driver.get("http://49.249.28.218:8888/index.php");
		FileInputStream fis=new FileInputStream("C:\\Users\\srinivasa rao\\Downloads\\commondata.properties");
		 Properties prop=new Properties();
		 prop.load(fis);
		 String browser=prop.getProperty("browser");
		 String url=prop.getProperty("url");
		 String username=prop.getProperty("username");
		 String password=prop.getProperty("password");
		 String orgname=prop.getProperty("orgname");
		 String sadd=prop.getProperty("shippingadd");
		 
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
			
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();	
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			driver.findElement(By.name("ship_street")).sendKeys(sadd);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
