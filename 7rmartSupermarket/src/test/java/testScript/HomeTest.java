package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage home;
	@Test(priority=1,description="Verify whether the user can able to successfully Logout after login")
 public void verifyUsercanSuccessfullyLogoutAfterLogin() throws IOException {
	 String username=ExcelUtility.readStringData(0, 0, "LoginPage");
		String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home=login.clickOnSigninbutton();
		home.clickOnAdminfield().clickOnLogoutbutton();
		boolean isLoginPadeisDisplayed=home.loginPageDisplayed();
		Assert.assertTrue(isLoginPadeisDisplayed,Messages.USERCANSUCCESSFULLYLOGOUTAFTERLOGIN);
 }
}
