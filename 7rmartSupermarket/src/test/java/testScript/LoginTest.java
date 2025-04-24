package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
@Test
	public void verifyUserLoginwithValidCredentials() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "LoginPage");
		String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninbutton();
		boolean isDashboardDisplayed=login.dashboardIsDisplayed();
		Assert.assertTrue(isDashboardDisplayed,"User was Unable to Login Successfully");
	}
@Test
	public void verifyUserLoginwithInvalidUsername() throws IOException {
		String username=ExcelUtility.readStringData(1, 0, "LoginPage");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninbutton();
		String actual=login.getPageTitle();
		String expected="//b[text()='7rmart supermarket']";
		Assert.assertEquals(actual, expected,"User was able to Login with Invalid Username");
	}
@Test
	public void verifyUserLoginwithInvalidPassword() throws IOException {
		String username=ExcelUtility.readStringData(2, 0, "LoginPage");
		String password=ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninbutton();
	}
@Test
	public void verifyUserLoginwithInvalidCredentials() throws IOException {
		String username=ExcelUtility.readStringData(3, 0, "LoginPage");
		String password=ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninbutton();
	}
}
