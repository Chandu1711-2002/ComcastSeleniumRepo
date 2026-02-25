package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTest {
	@Test
//	public void org() {
//		System.out.println("org test");
//	}
//	
//	@Test
//	public void contact() {
//		System.out.println("contact");
//	}
	
	public void sample() throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://amazon.in");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone Air 256 GB",Keys.ENTER);
		
		Thread.sleep(3000);
		
		String textValue = driver.findElement(By.xpath("//a[@class='a-link-normal s-line-clamp-2 puis-line-clamp-3-for-col-4-and-8 s-link-style a-text-normal']//ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//descendant::span[text()='₹99,000']")).getText();
		
		
		
		System.out.println(textValue);
	}

}
