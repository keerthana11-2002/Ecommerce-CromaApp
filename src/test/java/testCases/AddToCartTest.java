package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import testBase.TestBase;

public class AddToCartTest extends TestBase {
	@Test
	public void verifyAddToCart() {

		AddToCartPage obj = new AddToCartPage(driver);

		obj.searchProduct("Refrigerator");
		obj.openFirstProduct();

		String productTitle = obj.getProductTitle();

		obj.addToCart();

		String cartTitle = obj.getCartProductTitle();

		Assert.assertEquals(cartTitle, productTitle, "Product in cart does not match selected product");

		System.out.println("Product successfully added to cart");
	}
}
