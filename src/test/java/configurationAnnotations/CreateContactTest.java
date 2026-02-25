package configurationAnnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateContactTest {
	@Test
	public void createContact() {
		System.out.println("execute create contact");
	}
	
	@BeforeMethod
	public void configBm() {
		System.out.println("execute BM");
	}
 
	@AfterMethod
	public void configAM() {
		System.out.println("execute AM");
	}
	
	@Test
	public void createContactWithSupportDate() {
		System.out.println("excute create contact with support date");
	}
	
	@BeforeClass
	public void congigBeforeClass() {
		System.out.println("execute before class");
	}
	
	@AfterClass
	public void configAfterClass() {
		System.out.println("execute after class");
	}
	
	@BeforeSuite
	public void configBeforeSuite() {
		System.out.println("execute before suite");
	}
	
	@AfterSuite
	public void configAfterSuite() {
		System.out.println("execute after suite");
	}
}
