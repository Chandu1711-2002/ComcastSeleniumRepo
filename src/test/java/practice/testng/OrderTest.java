package practice.testng;

import org.testng.annotations.Test;

public class OrderTest {
	
	@Test
	public void createOrderTest()
	{
		System.out.println("execute create order test");
		String str=null;
		System.out.println(str.equals("123"));
	}
	
	@Test(dependsOnMethods="createOrderTest")
	public void billingAnOrderTest()
	{
		System.out.println("execute billing order test");
	}

}






