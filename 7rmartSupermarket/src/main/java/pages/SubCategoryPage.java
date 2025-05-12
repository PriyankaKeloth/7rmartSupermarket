package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.PageUtility;

public class SubCategoryPage {

	public WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	private WebElement subcategoryMoreinfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newSubCategory;
	@FindBy(id = "cat_id")
	private WebElement category;
	@FindBy(id = "subcategory")
	private WebElement subCategory;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	public SubCategoryPage clickOnMoreInfoInSubCategoryField() {
		subcategoryMoreinfo.click();
		return this;
	}

	public SubCategoryPage clickOnNewInListSubCategories() {
		newSubCategory.click();
		return this;
	}

	public SubCategoryPage selectCategoryOnCategoryField() {
		PageUtility page = new PageUtility();
		page.selectDropdownWithVisibletext(category, Constant.DROPDOWNVALUE2);

		return this;
	}

	public SubCategoryPage enterSubcategoryOnSubcategoryField(String subCatName) {
		subCategory.sendKeys(subCatName);
		return this;
	}

	public SubCategoryPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public boolean subcategotySuccessfullyCreatedAlert() {
		return alert.isDisplayed();
	}
}
