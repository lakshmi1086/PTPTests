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
	String validActivationMessage="You have successfully activated";
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
		//LogReporter.getInstance().logInfo(this.getClass().toString(), "Product Activated " +productactivated);*/
	}
	
	@Test
	public void validActivateProductTest() throws Exception{
		reader = new PropertiesReader(Constants.BUILD_PROERTIES_PATH);
		String accessCode=reader.getPropertyValue("AccessCode");
		String productName=reader.getPropertyValue("ProductName");
		product.activateProduct(accessCode);
		verifyObj.verifyActivationMessage(product.activationMessage, validActivationMessage );
		//System.out.println("Products Activated " +product.productList.getText());
		for(WebElement activatedproduct : product.getProducts()){
		if(activatedproduct.getText().equalsIgnoreCase(productName)){
			LogReporter.getInstance().logInfo(this.getClass().toString(), "Successfully activated product " +productName);
			break;
		}
		}
		
	}
	
	

}
