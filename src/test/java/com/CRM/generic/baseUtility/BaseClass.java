package com.CRM.generic.baseUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	@BeforeSuite
	public void configBeforeSuite() {
		System.out.println("connect to DB,report config");
	}

	
	@BeforeClass
	public void congigBeforeClass() {
		System.out.println("launch browser");
	}
	
	
	
	@BeforeMethod
	public void configBm() {
		System.out.println("login");
	}
	
 
	@AfterMethod
	public void configAM() {
		System.out.println("logout");
	}
	
	@AfterClass
	public void configAfterClass() {
		System.out.println("close browser");
	}
	
	@AfterSuite
	public void configAfterSuite() {
		System.out.println("close DB,report config");

}
}
