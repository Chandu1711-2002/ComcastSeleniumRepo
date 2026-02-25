package practice.pom.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTestwithoutPOM
{
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.28.218:8888/index.php");
		WebElement username=driver.findElement(By.name("user_name"));
		WebElement password=driver.findElement(By.name("user_password"));
		WebElement button=driver.findElement(By.id("submitButton"));
		username.sendKeys("admin");
		password.sendKeys("admin");
		driver.navigate().refresh();
		button.click();
	}

}
