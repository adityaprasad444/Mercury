package com.demo.TestCases;

import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import com.demo.pages.LoginHome;

public class TC3_Logout extends BaseClass {

	Actions act;
	LoginHome lh;

	@Test(priority = 2)
	public void logout() throws Exception   {
		extentTest = extent.startTest("logout");
		lh= new LoginHome(driver);
		lh.logout();
	}
}
