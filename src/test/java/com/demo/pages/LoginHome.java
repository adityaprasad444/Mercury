package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.TestCases.BaseClass;

public class LoginHome extends BaseClass {
	Actions act;
	
	public LoginHome(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		act =new Actions(driver);
	}
	
	@FindBy(xpath="/html/body/nav[2]/div/div[2]/ul/li[2]/a")
	public WebElement Welcometext;
		
	@FindBy(xpath="/html/body/nav[2]/div/div[2]/ul/li[2]/ul/li[3]/a")
	public WebElement Logout;
	
	@FindBy(xpath="/html/body/nav[2]/div/div[2]/ul/li[2]/ul/li[1]/a")
	public WebElement Profile;
	
	@FindBy(xpath="/html/body/nav[2]/div/div[2]/ul/li[2]/ul/li[2]/a")
	public WebElement MyBookings;
	
	public void logout() throws Exception  {
		Thread.sleep(1000);
		act.moveToElement(Welcometext).perform();
		System.out.println("Mouse hover to welcome Text");
		Thread.sleep(2000);
		Logout.click();
		System.out.println("Logout Clicked");
	}
	
	
}
