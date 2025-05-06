package automationCore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenShortUtility;

public class Base {

	public WebDriver driver;
@BeforeMethod
@Parameters("browser")
	public void initialiseBrowser(String browser) throws Exception {
		if(browser.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			throw new Exception("Invalid browser");
		}
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // implicit commands works during browser initializing time
	}
@AfterMethod(alwaysRun=true)

public void driverQuit(ITestResult iTestResult) throws IOException

{

if(iTestResult.getStatus()==ITestResult.FAILURE)

{

	ScreenShortUtility screenShot=new ScreenShortUtility();

	screenShot.getScreenshot(driver, iTestResult.getName());

}

	//driver.quit();

	
}
}



