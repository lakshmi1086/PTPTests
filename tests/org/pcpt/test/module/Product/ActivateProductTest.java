package org.pcpt.test.module.Product;


import org.junit.Assert;
import org.pcpt.sdk.LogReporter;
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
		product.activateProduct("8465EB82D842");
		verifyObj.verifyActivationMessage(product.activationMessage, validActivationMessage );
		Assert.assertTrue(product.productList.getText().contains("CompTIA Network+ N10-006 Authorized Cert Guide"));
		
	}
	
	

}
