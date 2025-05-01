package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	
	@Test
 public void verifyUsercanSuccessfullyLogoutAfterLogin() throws IOException {
	 String username=ExcelUtility.readStringData(0, 0, "LoginPage");
		String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninbutton();
		HomePage home=new HomePage(driver);
		home.clickOnAdminfield();
		home.clickOnLogoutbutton();
		boolean isLoginPadeisDisplayed=home.loginPageDisplayed();
		Assert.assertTrue(isLoginPadeisDisplayed,"User was Unable to Logout Successfully");
 }
}
