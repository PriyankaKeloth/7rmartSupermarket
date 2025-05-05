package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {

	public WebDriver driver;
	
	public AdminUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//p[normalize-space()='Admin Users']")private WebElement adminuser;
@FindBy(xpath = "//p[normalize-space()='Manage Users']")private WebElement manageuser;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")private WebElement newuser;
@FindBy(id="username")private WebElement newUsername;
@FindBy(id="password")private WebElement userpassword;
@FindBy(id="user_type")private WebElement usertype;
@FindBy(xpath="//button[@name='Create']")private WebElement savebutton;
@FindBy(xpath="//a[@onclick='click_button(2)']")private WebElement searchbutton;
@FindBy(id="un")private WebElement usernamesearch;
@FindBy(id="ut")private WebElement usertypesearch;
@FindBy(xpath="//button[@name='Search']")private WebElement searchsubmittbotton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;






  public void clickOnAdminUsersField() {
	adminuser.click();
  }
	
  public void selectOnManageUsers() {
	  manageuser.click();
  }
  public void clickOnNewUserButton() {
	  newuser.click();
  }
  public void enterNewUserNameOnUsernameField(String newuserusername) {
	  newUsername.sendKeys(newuserusername);
  }
  public void enterNewUserPasswordOnPasswordField(String newuserpassword) {
	  userpassword.sendKeys(newuserpassword);
  }	
  public void clickUserTypeDropdown() {
	  
	  Select select= new Select(usertype);
	  select.selectByVisibleText("Admin");
	 // usertype.click();
  }
  public void clickOnSaveButton() {
	  savebutton.click();
  }
  public void clickOnSearchButton() {
	  searchbutton.click();
  }
  public void enterUserNameOnSearchAdminUser(String usernamesearch1) {
	  usernamesearch.sendKeys(usernamesearch1);
  }
  public void selectUsertypeOnSearchAdminUser() {
	  Select select= new Select(usertypesearch);
	  select.selectByVisibleText("Admin");
  }
  public void clickOnSearchSubmittButton() {
	  searchsubmittbotton.click();
  }
  public boolean usercreatedSuccessfullyAlert() {
		return alert.isDisplayed();
	}
}
