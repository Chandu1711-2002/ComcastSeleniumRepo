package datadriventesting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SampleDataDrivenTesting 
{
	
		public static void main(String[] args) throws Exception
		{
			// FileInputStream fis=new FileInputStream("‪C:\\Users\\srinivasa rao\\Downloads\\commondata.properties");
			FileInputStream fis=new FileInputStream("C:\\Users\\srinivasa rao\\Downloads\\commondata.properties");
			 Properties prop=new Properties();
			 prop.load(fis);
			 String browser=prop.getProperty("browser");
			 String url=prop.getProperty("url");
			 String username=prop.getProperty("username");
			 String password=prop.getProperty("password");
	
//			 	Scanner sc=new Scanner(System.in);
//			 	System.out.println("enter the browser");
//			 	String browser=sc.next();
			 	//System.out.println(browser);
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
			    
			
				// driver=new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Thread.sleep(2000);
				driver.get(url);
				driver.findElement(By.name("user_name")).sendKeys(username);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
				
				driver.findElement(By.linkText("Organizations")).click();
				
				driver.close();
		}

	}


