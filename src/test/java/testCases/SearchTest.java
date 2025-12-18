package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.TestBase;

public class SearchTest extends TestBase {

	@Test

	public void verifySearchFunctionality() {
		SearchPage obj = new SearchPage(driver);
		obj.setSearch("Refrigerator");
		obj.clickBtn();
		String text = obj.getSearchName();
		Assert.assertTrue(text.contains("Refrigerator"), "Search result does not match");
	}

}
