package com.demo.TestCases;

import org.testng.annotations.Test;

import com.demo.pages.Homepage;
import com.demo.pages.Regestration;

//@Listeners(ListnerHelp.class)
public class TC2_Register extends BaseClass{

	Homepage h;
	
	@Test(priority=0)
	public void Register() throws InterruptedException
	{
		extentTest = extent.startTest("Register");
		h=new Homepage(driver);
		Regestration r=new Regestration(driver);
		h.MouseHover();
		h.ClickRegisterLink();
		Thread.sleep(2000);
		r.Register();
		
		
	}
}
