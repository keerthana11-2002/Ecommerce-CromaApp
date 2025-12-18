package testCases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.SortingByDiscountPage;
import testBase.TestBase;

public class SortByDiscountTest extends TestBase {

	@Test
	public void verifySortByDiscount() {
		SortingByDiscountPage obj = new SortingByDiscountPage(driver);
		obj.setSearch("Refrigerator");
		obj.openFilters();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement discount = wait.until(ExpectedConditions.elementToBeClickable(obj.getDiscountFilter()));

		js.executeScript("arguments[0].scrollIntoView({block:'center'});", discount);
		discount.click();

		obj.applyFilter();

		for (WebElement xElement : obj.getDiscount()) {
			String dis = xElement.getText();
			int d = Integer.parseInt(dis.replace("% Off", ""));
			if (d >= 40 && d <= 60) {
				System.out.println("Valid discount: " + d + "%");
			} else {
				System.out.println("Invalid discount: " + d + "%");
			}
		}
	}
}