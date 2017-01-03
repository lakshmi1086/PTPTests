package org.ptp.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.pcpt.sdk.LogReporter;

public class ProductPage {
	
	public WebDriver driver;
	
	@FindBy(css="a.btn.btn-primary.btn-md")
	public WebElement activateProductBtn;
	
	@FindBy(css="button.btn.btn-primary.btn-md")
	public WebElement loadSavedExamBtn;
	
	@FindBy(xpath="//div[@class='form-group']/input[@name='activationCode']")
	public WebElement accessCodeTxtBox;
	
	@FindBy(css="div.alert.fade.in>span.ng-binding")
	public WebElement productList;
	
	@FindBy(css="button.btn.btn-primary")
	public WebElement activateBtn;
	
	String productText="";
	
	public ProductPage(WebDriver driver){
		this.driver=driver;
		ProductPage product=PageFactory.initElements(driver,this.getClass());
	}
	
	public boolean isProductActivated(){
		
		productText=productList.getText();
		if(productText.equalsIgnoreCase("No Product Activated"))
		return false;
		else
		return true;
		
	}
	
	public void activateProduct(String accessCode){
		new VerifyProductPage().verifyActivateBtn(activateBtn);
		activateProductBtn.click();
		LogReporter.getInstance().logInfo(this.getClass().toString(), "Clicked Activate Product button ");
		accessCodeTxtBox.sendKeys(accessCode);
		LogReporter.getInstance().logInfo(this.getClass().toString(), "Entered Access code " +accessCode);
		activateBtn.click();
		LogReporter.getInstance().logInfo(this.getClass().toString(), "Clicked Activate button");
	}

}
