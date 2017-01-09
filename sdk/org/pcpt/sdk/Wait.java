package org.pcpt.sdk;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class contains common reusable explicit waits
 */
public class Wait {
	private WebDriver driver;
	private static PropertiesReader propReader;
	private int timeout;
	WebDriverWait wait;

	/**
	 * Constructor
	 */
	public Wait(WebDriver driver) {
		this.driver = driver;
		propReader = new PropertiesReader(Constants.BUILD_PROERTIES_PATH);
		String tout = propReader.getPropertyValue("explicit.timeout");
		timeout = Integer.parseInt(tout);
		wait = new WebDriverWait(driver, timeout);
	}

	/**
	 * Waits until angular finishes http calls in backend
	 */
	public void untilAngularFinishesHttpCalls() {
		final String javaScriptToLoadAngular = "var injector = window.angular.element('body').injector();"
				+ "var $http = injector.get('$http');" + "return ($http.pendingRequests.length === 0)";

		ExpectedCondition<Boolean> pendingHttpCallsCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(javaScriptToLoadAngular).equals(true);
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(pendingHttpCallsCondition);
	}
	
	public void waitUntilElementIsVisible(By locator, String logmessage){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForPageToLoad(){
		 ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
	                };
	   
	        wait.until(pageLoadCondition);
		
		
	}
	
	public void waitUntilElementIsClickable(By locator){
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
}
