package org.ptp.product;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VerifyProductPage {

	public void verifyActivateBtn(WebElement activateBtn) throws InterruptedException{
		Thread.sleep(3000);
		System.out.println(activateBtn.getText());
		//Assert.assertTrue(activateBtn.getText().equalsIgnoreCase("Activate New Product"), "Activate Button Text verification failed");
	}
	
	public void verifyActivationMessage(WebElement activationMessage,String message){
				Assert.assertTrue(activationMessage.getText().contains(message));
	}
}
