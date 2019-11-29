package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.demo.TestCases.BaseClass;
import com.demo.utility.ConfigReader;
import com.demo.utility.ExcelRead;

public class Homepage extends BaseClass{

	Actions act;
	ConfigReader CR= new ConfigReader();
	ExcelRead er=new ExcelRead();
	
	public Homepage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		act =new Actions(driver);
		}
	
	@FindBy(xpath="//*[@id=\"modalPopup\"]/div/div/div[1]/button/span")
	public WebElement popupclose;
	
	@FindBy(xpath="//a[contains(text(),'No, thanks')]")
	public WebElement Nothanks;
	
	@FindBy(xpath="/html/body/nav[2]/div/div[2]/ul/li[1]/a")
	public WebElement CustomerLogin;
	
	
	@FindBy(xpath="/html/body/nav[2]/div/div[2]/ul/li[1]/ul/li[1]/a")
	public WebElement userlogin;
	
	@FindBy(xpath="/html/body/nav[2]/div/div[2]/ul/li[1]/ul/li[2]/a")
	public WebElement Register;
	
	@FindBy(xpath="//*[@id=\"sign_user_email\"]")
	public WebElement username;
	
	@FindBy(xpath="//*[@id=\"sign_user_password\"]")
	public WebElement password;
	
	@FindBy(xpath="//*[@id=\"modalLogin\"]/div/div/div[2]/form/button")
	public WebElement login;
	
	public void popupclose() {
		//popupclose.click();
		Nothanks.click();
		System.out.println("Nothanks Clicked");
	}
	
	public void MouseHover() throws InterruptedException {
		act.moveToElement(CustomerLogin).perform();
		Thread.sleep(2000);
		System.out.println("Mouse hover to Cust login");
	}
	
	public void ClickRegisterLink() {
	
		Register.click();
		System.out.println("Registration clicked");
	}
	
	public void login() throws InterruptedException {
		
		userlogin.click();
		Thread.sleep(2000);
		username.clear();
		username.sendKeys(er.getdata(1,2));
		password.clear();
		password.sendKeys(er.getdata(1,3));
		login.click();
	}
	
}
