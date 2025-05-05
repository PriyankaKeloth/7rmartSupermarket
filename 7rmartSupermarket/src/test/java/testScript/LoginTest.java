package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
@Test(priority=1,description="verifying whether the user is able to successfully login with valid credentials")
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
@Test(priority=2,description="verifying whether the user is unable to successfully login with invalid username")
	public void verifyUserLoginwithInvalidUsername() throws IOException {
		String username=ExcelUtility.readStringData(1, 0, "LoginPage");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninbutton();
		boolean isAlertDisplayed=login.invalidUserNameAlert();
		Assert.assertTrue(isAlertDisplayed, "User was able to Login with Invalid Username");
		
	}
@Test(priority=3,description="verify whether the user is unable to successfully login with invalid password")
	public void verifyUserLoginwithInvalidPassword() throws IOException {
		String username=ExcelUtility.readStringData(2, 0, "LoginPage");
		String password=ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninbutton();
		boolean isAlertDisplayed=login.invalidUserNameAlert();
		Assert.assertTrue(isAlertDisplayed, "User was able to Login with Invalid Password");
	}
@Test(priority=4,description="verifying whether the user is unable to successfully login with Invalid credentials")
	public void verifyUserLoginwithInvalidCredentials() throws IOException {
		String username=ExcelUtility.readStringData(3, 0, "LoginPage");
		String password=ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninbutton();
		boolean isAlertDisplayed=login.invalidUserNameAlert();
		Assert.assertTrue(isAlertDisplayed, "User was able to Login with Invalid Credentials");
	}
}
