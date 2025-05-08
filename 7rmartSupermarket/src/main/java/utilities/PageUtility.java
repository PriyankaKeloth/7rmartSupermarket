package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
 public WebDriver driver;
	public void selectDropdownWithIndex(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
	}

	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}
	public void selectDropdownWithVisibletext(WebElement element,String visibletext) {
		Select object=new Select(element);
		object.selectByVisibleText(visibletext);
		}
	public void rightclickUsingMouseAction(WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).build().perform();;
	}
	public void mouseoverUsingMouseAction(WebElement element) {
		Actions action=new Actions(driver);
    	action.moveToElement(element).build().perform();
	}
	public void clickCheckBox(WebElement element) {
		element.click();
	}
	public void clickRadioButton(WebElement element) {
		element.click();
	}
}
