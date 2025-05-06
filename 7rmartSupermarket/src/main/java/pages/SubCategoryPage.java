package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SubCategoryPage {

	public WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")private WebElement subcategoryMoreinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newSubCategory;
	@FindBy(id="cat_id")private WebElement category;
	@FindBy(id="subcategory")private WebElement subCategory;
	@FindBy(xpath="//button[text()='Save']")private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	
	
	
	public void clickOnMoreInfoInSubCategoryField() {
		subcategoryMoreinfo.click();
	}
	public void clickOnNewInListSubCategories() {
		newSubCategory.click();
	}
	public void selectCategoryOnCategoryField() {
		Select select= new Select(category);
		  select.selectByVisibleText("Grocery");
	}
	public void enterSubcategoryOnSubcategoryField(String subCatName) {
		subCategory.sendKeys(subCatName);
	}
	public void clickOnSaveButton() {
		saveButton.click();
	}
	public boolean subcategotySuccessfullyCreatedAlert() {
		return alert.isDisplayed();
	}
}
