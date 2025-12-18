package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class PriceCalculationPage extends BasePage {

	public PriceCalculationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "searchV2")
	WebElement searchElement;

	@FindBy(xpath = "//div[@id='search-AB-Testing']//span[@class='icon']")
	WebElement searchIcon;

	@FindBy(xpath = "//div[@class='all-filters']")
	WebElement filterElement;

	@FindBy(xpath = "//label[@for='discount_group-40% To 60%']")
	WebElement selectFilter;

	@FindBy(xpath = "//div[@class='icon-text apply']//span[text()='Apply']")
	WebElement applyBtn;
	@FindBy(xpath = "//p[text()='Discount']")
	WebElement discountFilter;
	@FindBy(xpath = "//span[contains(@class,'amount plp')]")
	List<WebElement> amount;

	public void setSearch(String name) {
		searchElement.sendKeys(name);
		searchIcon.click();

	}

	public void openFilters() {
		filterElement.click();
	}

	public WebElement getDiscountFilter() {
		return discountFilter;
	}

	public void applyFilter() {
		selectFilter.click();
		applyBtn.click();
	}

	public List<WebElement> getPrices() {
		return amount;
	}

}
