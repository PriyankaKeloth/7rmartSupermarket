package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtility;

public class ManageProductTest extends Base {

	@Test
	public void verifyUsercanAddaProduct() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "LoginPage");
		String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninbutton();
		ManageProductPage manageproduct=new ManageProductPage(driver);
		manageproduct.clickOnManageProduct();
		manageproduct.clickOnNewForAddProduct();
		String product=ExcelUtility.readStringData(1, 0, "ManageProductPage");
		manageproduct.enterProductNameOnTitleField(product);
		manageproduct.clickOnProductType();
		//manageproduct.selectOnCategory();
		//manageproduct.selectOnSubcategory();
		manageproduct.clickOnPriceTypeRadio();
		manageproduct.selectOnMinimumPiece();
		String quantity=ExcelUtility.readIntegerData(1, 2, "ManageProductPage");
		manageproduct.enterMaximumQuantitycanOrder(quantity);
		String price=ExcelUtility.readIntegerData(1, 3, "ManageProductPage");
		manageproduct.enterPriceOnPricefield(price);
		String mrpprice=ExcelUtility.readIntegerData(1, 4, "ManageProductPage");
		manageproduct.enterMrpOnMrpfield(mrpprice);
		String stock=ExcelUtility.readIntegerData(1, 5, "ManageProductPage");
		manageproduct.enterStockOnStockAvailabilityField(stock);
		String note=ExcelUtility.readStringData(1, 6, "ManageProductPage");
		manageproduct.enteraNoteOnDescriptionField(note);
		manageproduct.clickOnavailabilityofStockOnStockfield();
	}
}
