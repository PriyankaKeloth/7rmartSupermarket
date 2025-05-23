package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement admin;
	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	private WebElement logout;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement loginpage;
	@FindBy(xpath = "//p[normalize-space()='Admin Users']")
	private WebElement adminuser;
	@FindBy(xpath = "//p[text()='Manage News']")
	private WebElement manageNews;
	@FindBy(xpath = "//p[text()='Manage Category']")
	private WebElement manageCategoryButton;

	public AdminUserPage clickOnAdminUsersField() {
		adminuser.click();
		return new AdminUserPage(driver);
	}

	public ManageNewsPage clickOnManageNews() {
		manageNews.click();
		return new ManageNewsPage(driver);
	}
	public ManageCategoryPage clickCategory() {
		manageCategoryButton.click();
		return new ManageCategoryPage(driver);
	}
	public HomePage clickOnAdminfield() {
		admin.click();
		return this;
	}

	public LoginPage clickOnLogoutbutton() {
		logout.click();
		return new LoginPage(driver);
	}

	public boolean loginPageDisplayed() {
		return loginpage.isDisplayed();
	}

}
