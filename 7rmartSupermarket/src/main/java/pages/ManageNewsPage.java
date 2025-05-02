package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
 @FindBy(xpath="//p[text()='Manage News']")private WebElement manageNews;
 @FindBy(xpath="//a[text()=' New']")private WebElement newNews;
 @FindBy(id="news")private WebElement entertheNews;
 @FindBy(xpath="//button[@name='create']")private WebElement savebutton;
 @FindBy(xpath="//a[normalize-space()='Search']")private WebElement search;
 @FindBy(xpath="//input[@name='un']")private WebElement searchNews;
 @FindBy(xpath="//button[@name='Search']")private WebElement searchsubmittbutton;
 
 
 
 public void clickOnManageNews() {
	 manageNews.click();
 }
 public void clickOnNewinManageNews() {
	 newNews.click();
 }
 public void enteraNewsOnEnterTheNews(String news) {
	 entertheNews.sendKeys(news);
 }
 public void clickOnSaveButtonInEnterNewsInfo() {
	 savebutton.click();
 }
 public void clickOnSearchButton() {
	 search.click();
 }
 public void entertheNewsOnSearchManageNews(String news1) {
	 searchNews.sendKeys(news1);
 }
 public void clickOnSearchButtonInSearchMangeNews() {
	 searchsubmittbutton.click();
 }
	
}
