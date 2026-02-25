package practice.pom.repository;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SampleTestWithPOM {
	@FindBy(name="user_name")
	WebElement username;
	
	@FindBy(name="user_password")
	WebElement password;
//	
//	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
//	WebElement button;
	
	@FindBys({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	WebElement button;
	
	@Test
	public void sampleTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.28.218:8888/index.php");
		SampleTestWithPOM s=PageFactory.initElements(driver,SampleTestWithPOM.class); //pagefactory will load all the latest elements in the s class
		s.username.sendKeys("admin");
		s.password.sendKeys("admin");
		driver.navigate().refresh();
		s.username.sendKeys("admin");
		s.password.sendKeys("admin");
		s.button.click();
	}

}
