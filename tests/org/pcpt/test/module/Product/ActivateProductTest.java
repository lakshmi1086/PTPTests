package org.pcpt.test.module.Product;


import org.pcpt.sdk.LogReporter;
import org.pcpt.sdk.TestBase;
import org.ptp.product.ProductPage;
import org.testng.annotations.Test;

public class ActivateProductTest extends TestBase {
	
	ProductPage product;
	
	@Test
	public void checkIfProductActivated(){
		product=new ProductPage(driver);
		boolean productactivated = product.isProductActivated();
		LogReporter.getInstance().logInfo(this.getClass().toString(), "Product Activated " +productactivated);
	}
	
	

}
