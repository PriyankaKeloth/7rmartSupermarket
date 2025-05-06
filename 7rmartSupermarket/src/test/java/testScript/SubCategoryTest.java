package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class SubCategoryTest extends Base {
	
@Test(priority=1,description="verifying whether the user is able to successfully add new Subcategory")
	public void verifyUsercanAddNewSubCategory() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "LoginPage");
		String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninbutton();
		SubCategoryPage subcategory=new SubCategoryPage(driver);
		subcategory.clickOnMoreInfoInSubCategoryField();
		subcategory.clickOnNewInListSubCategories();
		subcategory.selectCategoryOnCategoryField();
		RandomDataUtility random=new RandomDataUtility();
		String subCatName=random.createRandomSubCategory();
		subcategory.enterSubcategoryOnSubcategoryField(subCatName);
		subcategory.clickOnSaveButton();
		boolean isSuccessfullyCreatedAlertDisplyed=subcategory.subcategotySuccessfullyCreatedAlert();
		Assert.assertTrue(isSuccessfullyCreatedAlertDisplyed,"User was unable to add subcategory successfully");
	}
	
}
