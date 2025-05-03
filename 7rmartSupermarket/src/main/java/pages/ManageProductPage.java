package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageProductPage {
	public WebDriver driver;
	public ManageProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p[text()='Manage Product']")private WebElement manageProduct;
	@FindBy(xpath="//a[text()=' New']")private WebElement newProduct;
	@FindBy(id="title")private WebElement title;
	@FindBy(xpath="//input[@value='Others']")private WebElement productTypeRadio;
	@FindBy(id="cat_id")private WebElement category;
	@FindBy(id="sub_id")private WebElement subcategory;
	@FindBy(id="purpose1")private WebElement priceTypeRadio;
	@FindBy(id="p_minimum")private WebElement minimumPiece;
	@FindBy(id="p_max")private WebElement maximumQuantity;
	@FindBy(id="p_price")private WebElement actualprice;
	@FindBy(id="p_mrp")private WebElement mrp;
	@FindBy(id="p_stock")private WebElement stockAvailability;
	@FindBy(xpath="//div[@role='textbox']")private WebElement description;
	@FindBy(xpath="//label[normalize-space()='Yes']")private WebElement stockRadio;
	@FindBy(id="main_img")private WebElement image;
	@FindBy(xpath="//input[@name='featured' and @value='yes']") private WebElement featuredRadio;
	@FindBy(xpath="//input[@name='combo' and @value='no']")private WebElement comboPackRadio;
	@FindBy(xpath="//button[text()='Save']")private WebElement saveButton;
	
	
	
	public void clickOnManageProduct() {
		manageProduct.click();
	}
	public void clickOnNewForAddProduct() {
		newProduct.click();
	}
	public void enterProductNameOnTitleField(String product) {
		title.sendKeys(product);
	}
	public void clickOnProductType() {
		productTypeRadio.click();
	}
	public void selectOnCategory() {
		Select select= new Select(category);
		select.selectByVisibleText("select");
	}
	public void selectOnSubcategory() {
		Select select= new Select(subcategory);
		select.selectByVisibleText("select");
	}
	public void clickOnPriceTypeRadio() {
		priceTypeRadio.click();
	}
	public void selectOnMinimumPiece() {
		Select select= new Select(minimumPiece);
		select.selectByIndex(1);
	}
	public void enterMaximumQuantitycanOrder(String quantity) {
		maximumQuantity.sendKeys(quantity);
	}
	public void enterPriceOnPricefield(String price) {
		actualprice.sendKeys(price);
	}
	public void enterMrpOnMrpfield(String mrpprice) {
		mrp.sendKeys(mrpprice);
	}
	public void enterStockOnStockAvailabilityField(String stock) {
		stockAvailability.sendKeys(stock);
	}
	public void enteraNoteOnDescriptionField(String note) {
		description.sendKeys(note);
	}
	public void clickOnavailabilityofStockOnStockfield() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
		js.executeScript("arguments[0].click();", stockRadio);
		//stockRadio.click();
	}
	public void uploadProductPictureInImageField() {
		image.sendKeys("C:\\Users\\Ranil\\git\\7rmartSupermarket\\7rmartSupermarket\\src\\test\\resources\\ManageProduct");	
	}
	public void clickFeaturedInFeaturedField() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
		js.executeScript("arguments[0].click();", featuredRadio);
		//featuredRadio.click();
	}
	public void clickComboDetailsinComboPackField() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
		js.executeScript("arguments[0].click();", comboPackRadio);
	}
	public void clickOnSaveButton() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,450)", "");
		js.executeScript("arguments[0].click();", saveButton);
	}

}
