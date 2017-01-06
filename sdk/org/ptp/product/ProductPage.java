package org.ptp.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.pcpt.sdk.LogReporter;

public class ProductPage {
	
	public WebDriver driver;
	ProductPage product;
	
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
	public WebElement activationMessage;
	
	
	public VerifyProductPage verifyObj;
	
	public ProductPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public boolean isProductActivated(){
		//WebElement productList=driver.findElement(By.cssSelector("div.alert.fade.in>span.ng-binding"));
		productText=productList.getText();
		System.out.println(productText);
		if(productText.equalsIgnoreCase("No Product Activated."))
		return false;
		else
		return true;
		
	}
	
	public void activateProduct(String accessCode) throws Exception{
		activateProductBtn.click();
		LogReporter.getInstance().logInfo(this.getClass().toString(), "Clicked Activate Product button ");
		accessCodeTxtBox.sendKeys(accessCode);
		LogReporter.getInstance().logInfo(this.getClass().toString(), "Entered Access code " +accessCode);
		activateBtn.click();
		LogReporter.getInstance().logInfo(this.getClass().toString(), "Clicked Activate button");
		Thread.sleep(3000);
		activationMessage= driver.findElement(By.cssSelector("div.alert.alert-warning.fade.in>span.ng-binding"));
		
		System.out.println("Activation message" +activationMessage.getText());
		
	}
	
	public void logout(){
		driver.findElement(By.cssSelector("div#userAction")).click();
		driver.findElement(By.cssSelector("ul.dropdown-menu>li>a")).click();
		
	}

}
