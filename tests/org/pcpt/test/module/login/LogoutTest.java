package org.pcpt.test.module.login;

import org.pcpt.sdk.TestBase;
import org.ptp.product.ProductPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {

	@Test
	public void logoutTest(){
		new ProductPage(driver).logout();
	}
	
}
