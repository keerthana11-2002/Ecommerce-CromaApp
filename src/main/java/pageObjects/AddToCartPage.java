package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class AddToCartPage extends BasePage {

	public AddToCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "searchV2")
	WebElement searchElement;

	@FindBy(xpath = "//div[@id='search-AB-Testing']//span[@class='icon']")
	WebElement searchIcon;

	@FindBy(xpath = "(//li[@class='product-item'])[1]")
	WebElement firstProduct;

	@FindBy(xpath = "//h1[contains(@class,'pd-title')]")
	WebElement productTitle;

	@FindBy(xpath = "//button[contains(@class,'add-to-cart')]")
	WebElement addToCartBtn;

	@FindBy(xpath = "//button[contains(@class,'proceed-tocart')]")
	WebElement proceedToCartBtn;

	@FindBy(xpath = "//h3[contains(@class,'product-title')]")
	WebElement cartProductTitle;

	public void searchProduct(String name) {
		searchElement.sendKeys(name);
		searchIcon.click();
	}

	public void openFirstProduct() {
		firstProduct.click();
		switchToNewTab();
	}

	public String getProductTitle() {
		return productTitle.getText();
	}

	public void addToCart() {
		JavascriptExecutor jsExecutor = ((JavascriptExecutor) driver);
		jsExecutor.executeScript("window.scrollBy(0,700)");

		addToCartBtn.click();
		proceedToCartBtn.click();
	}

	public String getCartProductTitle() {
		return cartProductTitle.getText();
	}

	private void switchToNewTab() {
		Set<String> windows = driver.getWindowHandles();
		List<String> tabs = new ArrayList<>(windows);
		driver.switchTo().window(tabs.get(1));
	}

}
