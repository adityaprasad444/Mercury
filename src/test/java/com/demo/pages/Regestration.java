package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.demo.utility.ExcelRead;

public class Regestration {
	WebDriver driver;
	ExcelRead er=new ExcelRead();
	Actions act;
	public Regestration(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		act =new Actions(driver);
	}

	@FindBy(xpath="//*[@id=\"acc_first_name\"]")
	public WebElement FirstName;

	@FindBy(xpath="//*[@id=\"acc_last_name\"]")
	public WebElement LastName;

	@FindBy(xpath="//*[@id=\"acc_user_email\"]")
	public WebElement Email;

	@FindBy(xpath="//*[@id=\"acc_user_password\"]")
	public WebElement Password;

	@FindBy(xpath="//*[@id=\"acc_user_passconf\"]")
	public WebElement ConfirmPassword;

	@FindBy(xpath="//select[@class='form-control form-group']")
	public WebElement Countrycode;

	@FindBy(xpath="//input[@name='mobile_no']")
	public WebElement phone;

	@FindBy(xpath="//*[@id=\"modalUserLogin\"]/div/div/div[2]/form/button")
	public WebElement RegisterButton;

	
	@FindBy(xpath="/html/body/div[7]/div/div")
	public WebElement Successpopup;

	@FindBy(xpath="/html/body/div[7]/div/div/div[1]/button")
	public WebElement closesuccesspopup;

	public void Register() throws InterruptedException
	{
		FirstName.sendKeys(er.getdata(1,0));
		LastName.sendKeys(er.getdata(1,1));
		System.out.println("F&L Names entered");

		Email.sendKeys(er.getdata(1,2));
		Password.sendKeys(er.getdata(1,3));
		ConfirmPassword.sendKeys(er.getdata(1,3));
		System.out.println("Passwords Provided");

		Select s= new Select(Countrycode);
		s.selectByVisibleText("+91");
		System.out.println("Country code Selected");
		phone.sendKeys(er.getdata(1,4));
		System.out.println("Phone Number Entered");
		RegisterButton.click();
		System.out.println("Registration Button clicked");
		Thread.sleep(10000);
		act.moveToElement(closesuccesspopup).click().perform();
		System.out.println("Success popup closed");
		Thread.sleep(2000);
	}

}
