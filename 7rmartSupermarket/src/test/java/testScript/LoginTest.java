package testScript;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage home;

	@Test(priority = 1, description = "verifying whether the user is able to successfully login with valid credentials", retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginwithValidCredentials() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home=login.clickOnSigninbutton();
		boolean isDashboardDisplayed = login.dashboardIsDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.VALIDCREDENTIALERROR);
	}

	@Test(priority = 2, description = "verifying whether the user is unable to successfully login with invalid username",groups= {"smoke"})
	public void verifyUserLoginwithInvalidUsername() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home=login.clickOnSigninbutton();
		boolean isAlertDisplayed = login.invalidUserNameAlert();
		Assert.assertTrue(isAlertDisplayed,Messages.INVALIDUSERNAMECREDENTIALERROR);

	}

	@Test(priority = 3, description = "verify whether the user is unable to successfully login with invalid password",groups= {"smoke"})
	public void verifyUserLoginwithInvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home=login.clickOnSigninbutton();
		boolean isAlertDisplayed = login.invalidUserNameAlert();
		Assert.assertTrue(isAlertDisplayed, Messages.INVALIDPASSWORDCREDENTIALERROR);
	}

	@Test(dataProvider="loginProvider",priority = 4, description = "verifying whether the user is unable to successfully login with Invalid credentials")
	public void verifyUserLoginwithInvalidCredentials(String username,String password ) throws IOException {
		//String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		//String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home=login.clickOnSigninbutton();
		boolean isAlertDisplayed = login.invalidUserNameAlert();
		Assert.assertTrue(isAlertDisplayed, Messages.INVALIDCREDENTIALERROR);

	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {
		return new Object[][] { new Object[] {"123","admin"} 
		//return new Object[][] { new Object[] { "admin", "admin" }, new Object[] { "1234", "123" }, new Object[] {
				//ExcelUtility.readStringData(3, 0, "Login"), ExcelUtility.readStringData(3, 1, "Login")
				};
	}
}
