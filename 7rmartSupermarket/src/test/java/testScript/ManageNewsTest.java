package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	
	@Test
	public void verifyUsercanAddNews() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "LoginPage");
		String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninbutton();
		ManageNewsPage managenews=new ManageNewsPage(driver);
		managenews.clickOnManageNews();
		managenews.clickOnNewinManageNews();
		String news=ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		managenews.enteraNewsOnEnterTheNews(news);
		managenews.clickOnSaveButtonInEnterNewsInfo();
		
	}
	@Test
	public void verifyUsercanSearchNews() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "LoginPage");
		String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninbutton();
		ManageNewsPage managenews=new ManageNewsPage(driver);
		managenews.clickOnManageNews();
		managenews.clickOnSearchButton();
		String news1=ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		managenews.entertheNewsOnSearchManageNews(news1);
		managenews.clickOnSearchButtonInSearchMangeNews();
	}

}
