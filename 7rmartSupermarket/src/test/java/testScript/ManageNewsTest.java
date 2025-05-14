package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	HomePage home;
	ManageNewsPage managenews;
	@Test(priority=1,description="Verify whether the user is able to successfully add the news")
	public void verifyUsercanAddNews() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "LoginPage");
		String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home=login.clickOnSigninbutton();
		managenews.clickOnManageNews().clickOnNewinManageNews();
		String news=ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		managenews.enteraNewsOnEnterTheNews(news).clickOnSaveButtonInEnterNewsInfo();
		boolean isNewsCreatedSuccessfullyAlertDisplayed=managenews.newsCreatedSuccessfullyAlertDisplayed();
		Assert.assertTrue(isNewsCreatedSuccessfullyAlertDisplayed, Messages.USERCANADDNEWS);
		
	}
	@Test(priority=2,description="Verify whether the user is able to successfully search the news")
	public void verifyUsercanSearchNews() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "LoginPage");
		String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSigninbutton();
		managenews.clickOnManageNews().clickOnSearchButton();
		String news1=ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		managenews.entertheNewsOnSearchManageNews(news1).clickOnSearchButtonInSearchMangeNews();
	}

}
