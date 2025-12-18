package testCases;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void verifyLogin() {
		LoginPage obj = new LoginPage(driver);

		obj.userIconButton();
		obj.loginButton();
		obj.enterEmail("jkkeerthana10@gmail.com");
		obj.continueButton();
		System.out.println("Enter the OTP:");
		Scanner scanner = new Scanner(System.in);
		String otp = scanner.next();

		obj.setOTP(otp);
		obj.submitButton();
		obj.verifyUser();
		Assert.assertTrue(obj.verifyUser(), "Login was not successful");
		scanner.close();
	}

}
