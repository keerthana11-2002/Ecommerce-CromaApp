package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	public static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	@BeforeMethod()
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.croma.com/");
	}

	public String captureScreen(String testName) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) TestBase.getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);

		String targetPath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timeStamp + ".png";

		FileUtils.copyFile(source, new File(targetPath));

		return targetPath;
	}

	@AfterMethod()
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
