package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.PriceCalculationPage;
import testBase.TestBase;

public class PriceCalculationTest extends TestBase {

	@Test
	public void verifyCalculation() {
		PriceCalculationPage obj = new PriceCalculationPage(driver);
		obj.setSearch("Refrigerator");
		obj.openFilters();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement discount = wait.until(ExpectedConditions.elementToBeClickable(obj.getDiscountFilter()));

		js.executeScript("arguments[0].scrollIntoView({block:'center'});", discount);
		discount.click();

		obj.applyFilter();

		List<WebElement> prices = obj.getPrices();
		int count = Math.min(10, prices.size());

		int total = 0;
		for (int i = 0; i < count; i++) {
			int price = Integer.parseInt(prices.get(i).getText().replace("₹", "").replace(",", "").trim());
			total += price;
		}

		int average = total / count;
		System.out.println("Average price of top " + count + " products: ₹" + average);

		Assert.assertTrue(average > 0, "Average price calculation failed");
	}
}