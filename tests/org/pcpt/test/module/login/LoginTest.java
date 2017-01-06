package org.pcpt.test.module.login;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
	
	LoginPage login;
	ProductPage product;	
	String productGroup;
	String userName;
	String password;
	PropertiesReader reader; 
	
	@BeforeTest
	public void instantiateLogin(){
		login = PageFactory.initElements(driver, LoginPage.class);
		
	}
	
	@Test
	public void loginTest() {
		
		System.out.println("Logging into PTP application");
		reader=new PropertiesReader(Constants.BUILD_PROERTIES_PATH);
		productGroup=reader.getPropertyValue("ProductGroup");
		userName=reader.getPropertyValue("InformITUserName");
		password=reader.getPropertyValue("InformITPassword");
		System.out.println(driver);
		
		login.login(productGroup, userName, password);
		
	}
	
	
	
}
