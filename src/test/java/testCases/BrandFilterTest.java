package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BrandFilteringPage;
import testBase.TestBase;

public class BrandFilterTest extends TestBase {

	@Test
	public void verifyBrand() {
		BrandFilteringPage obj = new BrandFilteringPage(driver);
		obj.setSearch("Refrigerator");

		obj.searchBrand();

		String[] brands = { "LG", "Samsung", "Panasonic" };
		for (String brand : brands) {
			obj.selectBrand(brand);
			System.out.println("Selected brand: " + brand);
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(obj.getProductTitles()));
		List<WebElement> products = obj.getProductTitles();

		for (WebElement product : products) {
			String productName = product.getText().toLowerCase();

			boolean match = false;
			for (String brand : brands) {
				if (productName.contains(brand.toLowerCase())) {
					match = true;
					break;
				}
			}
			Assert.assertTrue(match, "Product does not match selected brands: " + productName);
		}

		System.out.println("Brand filtering verified successfully");
	}

}