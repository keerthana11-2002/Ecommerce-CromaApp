package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "searchV2")
	WebElement searchElement;

	@FindBy(xpath = "//div[@id='search-AB-Testing']//span[@class='icon']")
	WebElement searchIcon;

	@FindBy(xpath = "//h1[@class='cat-title']")
	WebElement searchName;

	public void setSearch(String name) {
		searchElement.sendKeys(name);
	}

	public void clickBtn() {
		searchIcon.click();
	}

	public String getSearchName() {
		return searchName.getText();

	}

}
