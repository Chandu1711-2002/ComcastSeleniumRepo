package practice.testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoTestUsingExcel {
	@Test(dataProvider = "getDetails")
	public void data(String n,String co) throws InterruptedException {
		
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("http://amazon.in");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(n,Keys.ENTER);
	//Thread.sleep(1000);

	String x="//span[contains(text(),'"+n+"')]/../../../../../..//span[@class='a-price-whole']";
	String price=driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	driver.quit();
	}
	@DataProvider
	public Object[][] getDetails() throws EncryptedDocumentException, IOException
	{
		
//		Object[][] obj=new Object[3][2];
//		obj[0][0]="iPhone 17 Pro 256 GB: 15.93 cm (6.3″) Display with Promotion up to 120Hz, A19 Pro Chip, Breakthrough Battery Life, Pro Fusion Camera System with Center Stage Front Camera; Deep Blue";
//		obj[0][1]="silver";
//		obj[1][0]="iPhone 17 Pro Max 1 TB";
//		obj[1][1]="white";
//		obj[2][0]="iPhone 16 Pro Max 1 TB";
//		obj[2][1]="silver";
//		return obj;
		
		FileInputStream fis=new FileInputStream("./TestData/ReaddataWithCondition.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("product");
		int row=sh.getLastRowNum(); //it give the row count exculding the header
		int col=sh.getRow(1).getLastCellNum();
		Object[][] obj=new Object[row][2];
		for(int i=1;i<=row;i++)
		{
			for(int j=0;j<=col-1;j++)
			{
			obj[i-1][j]=sh.getRow(i).getCell(j).toString();
		     }
		}
		
		return obj;
		
	}

}
