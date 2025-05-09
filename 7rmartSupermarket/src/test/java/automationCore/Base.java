package automationCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenShortUtility;

public class Base {
	Properties prop;
	FileInputStream fs;

	public WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initialiseBrowser(String browser) throws Exception {
		prop=new Properties();
		fs=new FileInputStream(Constant.CONFIGFILE);
		prop.load(fs);
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Invalid browser");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // implicit commands works during browser
																			// initializing time
	}

	@AfterMethod(alwaysRun=true)

	public void driverQuit(ITestResult iTestResult) throws IOException

	{

		if (iTestResult.getStatus() == ITestResult.FAILURE)

		{

			ScreenShortUtility screenShot = new ScreenShortUtility();

			screenShot.getScreenshot(driver, iTestResult.getName());

		}

		 driver.quit();

	}
}
