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

	
	@FindBy(xpath = "//a[text()=' New']")
	private WebElement newNews;
	@FindBy(id = "news")
	private WebElement entertheNews;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement savebutton;
	@FindBy(xpath = "//a[normalize-space()='Search']")
	private WebElement search;
	@FindBy(xpath = "//input[@name='un']")
	private WebElement searchNews;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchsubmittbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	

	public ManageNewsPage clickOnNewinManageNews() {
		newNews.click();
		return this;
	}

	public ManageNewsPage enteraNewsOnEnterTheNews(String news) {
		entertheNews.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickOnSaveButtonInEnterNewsInfo() {
		savebutton.click();
		return this;
	}

	public ManageNewsPage clickOnSearchButton() {
		search.click();
		return this;
	}

	public ManageNewsPage entertheNewsOnSearchManageNews(String news1) {
		searchNews.sendKeys(news1);
		return this;
	}

	public ManageNewsPage clickOnSearchButtonInSearchMangeNews() {
		searchsubmittbutton.click();
		return this;
	}

	public boolean newsCreatedSuccessfullyAlertDisplayed() {
		return alert.isDisplayed();
	}

}
