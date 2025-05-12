package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUserPage {

	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[normalize-space()='Manage Users']")
	private WebElement manageuser;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newuser;
	@FindBy(id = "username")
	private WebElement newUsername;
	@FindBy(id = "password")
	private WebElement userpassword;
	@FindBy(id = "user_type")
	private WebElement usertype;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement savebutton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchbutton;
	@FindBy(id = "un")
	private WebElement usernamesearch;
	@FindBy(id = "ut")
	private WebElement usertypesearch;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchsubmittbotton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	public AdminUserPage selectOnManageUsers() {
		manageuser.click();
		return this;
	}

	public AdminUserPage clickOnNewUserButton() {
		WaitUtility wait = new WaitUtility();
		wait.waitForWebElementToBeClickable(driver, newuser);
		newuser.click();
		return this;
	}

	public AdminUserPage enterNewUserNameOnUsernameField(String newuserusername) {
		newUsername.sendKeys(newuserusername);
		return this;
	}

	public AdminUserPage enterNewUserPasswordOnPasswordField(String newuserpassword) {
		userpassword.sendKeys(newuserpassword);
		return this;
	}

	public AdminUserPage clickUserTypeDropdown() {
		PageUtility page = new PageUtility();
		page.selectDropdownWithVisibletext(usertype, Constant.DROPDOWNVALUE);
		// usertype.click();
		return this;
	}

	public AdminUserPage clickOnSaveButton() {
		savebutton.click();
		return this;
	}

	public AdminUserPage clickOnSearchButton() {
		searchbutton.click();
		return this;
	}

	public AdminUserPage enterUserNameOnSearchAdminUser(String usernamesearch1) {
		usernamesearch.sendKeys(usernamesearch1);
		return this;
	}

	public AdminUserPage selectUsertypeOnSearchAdminUser() {
		PageUtility page = new PageUtility();
		page.selectDropdownWithVisibletext(usertypesearch, Constant.DROPDOWNVALUE);

		return this;
	}

	public AdminUserPage clickOnSearchSubmittButton() {
		searchsubmittbotton.click();
		return this;
	}

	public boolean usercreatedSuccessfullyAlert() {
		return alert.isDisplayed();
	}
}
