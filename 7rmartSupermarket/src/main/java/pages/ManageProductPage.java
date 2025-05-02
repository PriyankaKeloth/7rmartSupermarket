package pages;

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
	@FindBy(xpath="//label[normalize-space()='Yes']")private WebElement StockRadio;
	
	
	
	
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
		StockRadio.click();
	}
	
}
