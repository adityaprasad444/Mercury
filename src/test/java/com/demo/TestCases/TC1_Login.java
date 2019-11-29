package com.demo.TestCases;

import org.testng.annotations.Test;
import com.demo.pages.Homepage;


//@Listeners(ListnerHelp.class)
public class TC1_Login extends BaseClass{


	@Test(priority = 1)
	public void Login () throws InterruptedException {
		extentTest = extent.startTest("Login");
		Homepage h=new Homepage(driver);
		h.MouseHover();
		Thread.sleep(2000);
		h.login();
		Thread.sleep(5000);
		System.out.println("Login Success");
	}

}