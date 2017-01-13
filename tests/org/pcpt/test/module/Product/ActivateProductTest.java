package org.pcpt.test.module.Product;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.pcpt.sdk.Constants;
import org.pcpt.sdk.LogReporter;
import org.pcpt.sdk.PropertiesReader;
import org.pcpt.sdk.TestBase;
import org.pcpt.sdk.Wait;
import org.ptp.product.ProductPage;
import org.ptp.product.VerifyProductPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActivateProductTest extends TestBase {
	
	ProductPage product;
	VerifyProductPage verifyObj;
	String activationMessage="";
	
	Wait wait;
	PropertiesReader reader; 
	
	@BeforeClass
	public void initializeProductPage(){
		System.out.println("Before Class");
		product=new ProductPage(driver);
		verifyObj= new VerifyProductPage();
		wait=new Wait(driver);
	}
	
	@Test
	public void checkIfProductActivated(){
		System.out.println("Testing");
		boolean productactivated = product.isProductActivated();
		System.out.println(" Product Activated" +productactivated);
		//LogReporter.getInstance().logInfo(this.getClass().toString(), "Product Activated " +productactivated);
	}
	
	@Test
	public void validActivateProductTest() throws Exception{
		reader = new PropertiesReader(Constants.BUILD_PROERTIES_PATH);
		String accessCode=reader.getPropertyValue("AccessCode");
		String productName=reader.getPropertyValue("ProductName");
		activationMessage=product.activateProduct(accessCode, "success");
		
		verifyObj.verifyActivationMessage(activationMessage, Constants.validActivationMessage );
		//System.out.println("Products Activated " +product.productList.getText());
		Assert.assertTrue("Product " +productName+ "does not exist", product.isProductDisplayed(productName));
		
		
	}
	
	@Test
	public void invalidActivateProductTest() throws Exception{
		reader = new PropertiesReader(Constants.BUILD_PROERTIES_PATH);
		String accessCode=reader.getPropertyValue("InvalidAccessCode");
		activationMessage=product.activateProduct(accessCode , "warning");
		verifyObj.verifyActivationMessage(activationMessage, Constants.invalidActivationMessage );
		product.cancelActivation();
		//System.out.println("Products Activated " +product.productList.getText());
		
	}
		
	
	@Test(dependsOnMethods="validActivateProductTest")
	public void duplicateActivateProductTest() throws Exception{
		reader = new PropertiesReader(Constants.BUILD_PROERTIES_PATH);
		String accessCode=reader.getPropertyValue("AccessCode");
		activationMessage=product.activateProduct(accessCode, "warning");
		verifyObj.verifyActivationMessage(activationMessage, Constants.alreadyActivatedmessage );
		product.cancelActivation();
		
	}
		
	}
	
	


