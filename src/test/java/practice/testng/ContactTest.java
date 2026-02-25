package practice.testng;

import org.testng.annotations.Test;

public class ContactTest {
	@Test(priority=-1)
	public void createContactTest() {
		System.out.println("execute createcontact");
	}
	
	@Test(priority=0)
	public void modifyContactTest() {
		System.out.println("execute modifycontact");
	}

	@Test(priority=3)
	public void deleteContactTest() {
		System.out.println("execute deletecontact");
	}
}
