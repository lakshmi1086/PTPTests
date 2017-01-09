package org.pcpt.sdk.automation.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.pcpt.sdk.LogReporter;
import org.pcpt.sdk.Wait;
import org.ptp.product.ProductPage;

/**
 * Page class which replicates the view of login page
 */
public class LoginPage {

	@FindBy(id = "username")
	protected WebElement usernameInputBox;

	@FindBy(id = "platform")
	public WebElement drpProductGroup;
	
	@FindBy(id = "username")
	protected WebElement txtUserName;
		
	@FindBy(id = "password")
	protected WebElement txtPassword;

	@FindBy(css = "button.login-btn.btn.btn-primary")
	protected WebElement btnLogin;
	

	/**
	 * This method is used for login
	 * 
	 * @param username
	 *            username
	 * @param password
	 *            password
	 * @author Lakshmi           
	 */
	
	public void selectProductGroup(String productGroup){
		Select drpProduct = new Select(drpProductGroup);
		drpProduct.selectByVisibleText(productGroup);
		LogReporter.getInstance().logInfo(this.getClass().toString(), "Selected product group " +productGroup);
	}
	
	public void sendUserName(String username){
		txtUserName.sendKeys(username);
		LogReporter.getInstance().logInfo(this.getClass().toString(), "Entered user name " +username);
	}
	
	public void sendPassword(String password){
		txtPassword.sendKeys(password);
		LogReporter.getInstance().logInfo(this.getClass().toString(), "Entered password " +password);
	}
	
	public void clickLoginButton(){
		btnLogin.click();
		LogReporter.getInstance().logInfo(this.getClass().toString(), "Login successful ");
	}
	
	public void login(String productGroup, String username, String password) {
		//System.out.println(driver);
		/*Select drpProduct = new Select(driver.findElement(By.id("platform")));
		drpProduct.selectByVisibleText(productGroup);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.cssSelector("button.login-btn.btn.btn-primary")).click();*/
		
		selectProductGroup(productGroup);
		sendUserName(username);
		sendPassword(password);
		clickLoginButton();		
	
		
		
	}
}

