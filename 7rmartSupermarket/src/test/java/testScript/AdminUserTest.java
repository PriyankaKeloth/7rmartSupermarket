package testScript;






import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base {
	HomePage home;
	AdminUserPage adminuser;
	
	@Test(priority=1,description="verifying whether the admin is able to add new user")
	public void verifyAdmincanAddaNewUser() throws IOException {
		
		String username=ExcelUtility.readStringData(0, 0, "LoginPage");
		String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home=login.clickOnSigninbutton();
		
		adminuser=home.clickOnAdminUsersField();
		adminuser.selectOnManageUsers().clickOnNewUserButton();
		RandomDataUtility random=new RandomDataUtility();
		String newuserusername=random.createRandomUserName();
		String newuserpassword=random.createRandomPassword();
		adminuser.enterNewUserNameOnUsernameField(newuserusername).enterNewUserPasswordOnPasswordField(newuserpassword).clickUserTypeDropdown().clickOnSaveButton();
	    boolean isUserCreatedSuccessfullyAlertDisplayed=adminuser.usercreatedSuccessfullyAlert();
	    Assert.assertTrue(isUserCreatedSuccessfullyAlertDisplayed, Messages.ADMINCANADDNEWUSER);
		
		
	}
	
	@Test(priority=2,description="verifying whether the admin is able to search the user")
	public void verifyAdmincanSearchaUser() throws IOException {
		
			String username=ExcelUtility.readStringData(0, 0, "LoginPage");
			String password=ExcelUtility.readStringData(0, 1, "LoginPage");
			LoginPage login=new LoginPage(driver);
			login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSigninbutton();
			
			adminuser=home.clickOnAdminUsersField();
			adminuser.selectOnManageUsers().clickOnNewUserButton().clickOnSearchButton();
			String usernamesearch1=ExcelUtility.readStringData(0, 0, "AdminUserPage");
			adminuser.enterUserNameOnSearchAdminUser(usernamesearch1).selectUsertypeOnSearchAdminUser().clickOnSearchSubmittButton();
			
	}

}
