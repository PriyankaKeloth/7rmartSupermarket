package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(priority = 1, description = "verifying whether the user is able to successfully login with valid credentials", retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginwithValidCredentials() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninbutton();
		boolean isDashboardDisplayed = login.dashboardIsDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.VALIDCREDENTIALERROR);
	}

	@Test(priority = 2, description = "verifying whether the user is unable to successfully login with invalid username")
	public void verifyUserLoginwithInvalidUsername() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninbutton();
		boolean isAlertDisplayed = login.invalidUserNameAlert();
		Assert.assertTrue(isAlertDisplayed, "User was able to Login with Invalid Username");

	}

	@Test(priority = 3, description = "verify whether the user is unable to successfully login with invalid password")
	public void verifyUserLoginwithInvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninbutton();
		boolean isAlertDisplayed = login.invalidUserNameAlert();
		Assert.assertTrue(isAlertDisplayed, "User was able to Login with Invalid Password");
	}

	@Test(priority = 4, description = "verifying whether the user is unable to successfully login with Invalid credentials",dataProvider="LoginProvider")
	public void verifyUserLoginwithInvalidCredentials() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninbutton();
		boolean isAlertDisplayed = login.invalidUserNameAlert();
		Assert.assertTrue(isAlertDisplayed, "User was able to Login with Invalid Credentials");

	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {
		return new Object[][] { new Object[] { "admin", "admin" }, new Object[] { "1234", "123" }, new Object[] {
				//ExcelUtility.readStringData(3, 0, "Login"), ExcelUtility.readStringData(3, 1, "Login")
				} };
	}
}
