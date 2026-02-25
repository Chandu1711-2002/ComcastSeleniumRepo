package practice.testng;

import org.testng.annotations.Test;

public class InvocationCount {

	@Test
	public void createContactTest() {
		for(int i=1;i<=5;i++)
		{
		System.out.println("execute create contact test");
		}
	}
	
}
