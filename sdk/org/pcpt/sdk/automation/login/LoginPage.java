package org.pcpt.sdk.automation.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Page class which replicates the view of login page
 */
public class LoginPage {

	@FindBy(id = "username")
	
	protected WebElement usernameInputBox;

	@FindBy(id = "platform")
	protected WebElement drpProductGroup;
	
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
	public void login(String productGroup, String username, String password) {
		Select drpProduct = new Select(drpProductGroup);
		drpProduct.selectByVisibleText(productGroup);
		txtUserName.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
}
