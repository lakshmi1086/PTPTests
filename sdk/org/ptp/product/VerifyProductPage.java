package org.ptp.product;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VerifyProductPage {

	public void verifyActivateBtn(WebElement activateBtn){
		Assert.assertTrue(activateBtn.getText().equalsIgnoreCase("Activate New Product"), "Activate Button Text verification failed");
	}
}
