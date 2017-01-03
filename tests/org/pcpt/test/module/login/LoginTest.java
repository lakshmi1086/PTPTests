package org.pcpt.test.mudule.login;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.pattern.PropertiesPatternConverter;
import org.openqa.selenium.support.PageFactory;
import org.pcpt.sdk.Constants;
import org.pcpt.sdk.LogReporter;
import org.pcpt.sdk.PropertiesReader;
import org.pcpt.sdk.TestBase;
import org.pcpt.sdk.automation.login.LoginPage;
import org.ptp.product.ProductPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
	
	LoginPage login;
	ProductPage product;	
	String productGroup;
	String userName;
	String password;
	PropertiesReader reader; 
	
	
	
	@Test
	public void loginTest() {
		login = PageFactory.initElements(driver, LoginPage.class);
		product = new ProductPage();
		LogReporter.getInstance().logInfo("TestClass1", "LoggedByCode");
		System.out.println("Logging into PTP application");
		reader=new PropertiesReader(Constants.BUILD_PROERTIES_PATH);
		productGroup=reader.getPropertyValue("ProductGroup");
		userName=reader.getPropertyValue("InformITUserName");
		password=reader.getPropertyValue("InformITPassword");
		System.out.println(driver);
		
		product=login.login(productGroup, userName, password);
		
	}
	
	@Test
	public void loginTest2() {
		LogReporter.getInstance().logInfo("TestClass2", "LoggedByCode");
		System.out.println("Testing");
	}
	
	@Test
	public void loginTest3() {
		System.out.println("Testing");
	}
}
