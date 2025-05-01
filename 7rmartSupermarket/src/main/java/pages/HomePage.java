package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
 public WebDriver driver;
 public HomePage(WebDriver driver){
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
 
 @FindBy(xpath="//a[@data-toggle='dropdown']")private WebElement admin;
 @FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Logout']")private WebElement logout;
 @FindBy(xpath = "//b[text()='7rmart supermarket']")private WebElement loginpage;
 
 public void clickOnAdminfield() {
	 admin.click();
 }
 public void clickOnLogoutbutton() {
	 logout.click();
 }
 public boolean loginPageDisplayed() {
	 return loginpage.isDisplayed(); 
 }
 
}
