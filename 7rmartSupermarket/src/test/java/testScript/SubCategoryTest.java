package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class SubCategoryTest extends Base {
	SubCategoryPage subcategory;
@Test(priority=1,description="verifying whether the user is able to successfully add new Subcategory")
	public void verifyUsercanAddNewSubCategory() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "LoginPage");
		String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSigninbutton();
		subcategory.clickOnMoreInfoInSubCategoryField().clickOnNewInListSubCategories().selectCategoryOnCategoryField();
		RandomDataUtility random=new RandomDataUtility();
		String subCatName=random.createRandomSubCategory();
		subcategory.enterSubcategoryOnSubcategoryField(subCatName).clickOnSaveButton();
		boolean isSuccessfullyCreatedAlertDisplyed=subcategory.subcategotySuccessfullyCreatedAlert();
		Assert.assertTrue(isSuccessfullyCreatedAlertDisplyed,Messages.USERCANADDNEWSUBCATEGORY);
	}
	
}
