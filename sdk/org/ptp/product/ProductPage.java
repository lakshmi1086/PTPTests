package org.ptp.product;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.pcpt.sdk.LogReporter;
import org.pcpt.sdk.Wait;

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
	List<WebElement> myProducts;
	
	
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
		Wait wait = new Wait(driver);
		wait.waitForPageToLoad();
		activateProductBtn.click();
		LogReporter.getInstance().logInfo(this.getClass().toString(), "Clicked Activate Product button ");
		accessCodeTxtBox.sendKeys(accessCode);
		LogReporter.getInstance().logInfo(this.getClass().toString(), "Entered Access code " +accessCode);
	//	Thread.sleep(2000);
		activateBtn.click();
		LogReporter.getInstance().logInfo(this.getClass().toString(), "Clicked Activate button");
		//Thread.sleep(2000);
		wait.waitUntilElementIsVisible(By.cssSelector("div.alert.alert-success.fade.in>span.ng-binding"), "Element Not Visible");
		activationMessage= driver.findElement(By.cssSelector("div.alert.alert-success.fade.in>span.ng-binding"));
		System.out.println("Activation message" +activationMessage.getText());
				
	}
	
	public void logout(){
		Wait wait = new Wait(driver);
		wait.waitUntilElementIsVisible(By.cssSelector("div#userAction>span.caret"), "Element not visible");
		Actions actions = new Actions(driver);

		actions.moveToElement(driver.findElement(By.cssSelector("div#userAction>span.caret"))).click().perform();
		actions.moveToElement(driver.findElement(By.cssSelector("ul.dropdown-menu>li>a"))).click().perform();
		//driver.findElement(By.cssSelector("ul.dropdown-menu>li>a")).click();
		
	}
	
	public List<WebElement> getProducts(){
		myProducts=driver.findElements(By.cssSelector("div#productName"));
		System.out.println("My Products : "  +myProducts.get(0).getText());
		return myProducts;
		
	}
}

