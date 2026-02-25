package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTestUsingDataProvider {
	@Test(dataProvider="getData")
	public void createContactTest(String fn,String ln) 
	{
		System.out.println(fn+" "+ln);
		
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] obj=new Object[3][2];
		obj[0][0]="ram";
		obj[0][1]="patil";
		obj[1][1]="sita";
		obj[1][1]="chowdary";
		obj[2][0]="akil";
		obj[2][1]="saradhi";
		return obj;
		
	}

}
