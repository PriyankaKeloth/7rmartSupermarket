package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")private WebElement usernamefield;
	@FindBy(xpath = "//input[@placeholder='Password']")private WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign In']")private WebElement signinbutton;
	@FindBy(xpath = "//p[text()='Dashboard']")private WebElement dashboard;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alert;
	

	public LoginPage enterUsernameOnUsernameField(String username) {
		usernamefield.sendKeys(username);
		return this;
	}

	public LoginPage enterPasswordOnPasswordField(String password) {
		passwordfield.sendKeys(password);
		return this;
	}

	public HomePage clickOnSigninbutton() {
		signinbutton.click();
		return new HomePage(driver);
	}
	
	public boolean dashboardIsDisplayed() {
		return dashboard.isDisplayed();
	}
	
	public boolean invalidUserNameAlert() {
		return alert.isDisplayed();
	}
}
