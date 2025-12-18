package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class BrandFilteringPage extends BasePage {

	public BrandFilteringPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "searchV2")
	WebElement searchElement;

	@FindBy(xpath = "//div[@id='search-AB-Testing']//span[@class='icon']")
	WebElement searchIcon;

	@FindBy(xpath = "(//p[text()='Brand'])[1]")
	WebElement clickBrand;

	@FindBy(xpath = "//h3[contains(@class,'product-title')]")
	List<WebElement> productTitles;

	public void setSearch(String name) {
		searchElement.sendKeys(name);
		searchIcon.click();
	}

	public void searchBrand() {
		clickBrand.click();
	}

	public void selectBrand(String brandName) {
		String xpath = "//label[@for='SG-ManufacturerDetails-Brand-" + brandName + "']";
		driver.findElement(By.xpath(xpath)).click();
	}

	public List<WebElement> getProductTitles() {
		return productTitles;
	}

}
