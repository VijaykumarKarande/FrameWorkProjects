package Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant {

	public static int passcount = 0, failcount = 0;
	public static WebDriver driver;
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}

	@BeforeMethod
	public void OneApp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
	}

	@AfterMethod
	public void CloseAPP(ITestResult res) {
		String testName = res.getName();
		int status = res.getStatus();
		if (status == 1) {
			passcount++;
		} else {
			failcount++;
			String path = PHOTO_PATH + testName + ".png";
			Reporter.log("path is : " + path, true);
			FwUtil.getPhoto(driver, path);
		}
		driver.close();
	}

	@AfterSuite
	public void print() {
		FwUtil.setXLData(REPORT_PATH, "sheet1", 1, 0, passcount);
		FwUtil.setXLData(REPORT_PATH, "sheet1", 1, 1, failcount);
	}

}
