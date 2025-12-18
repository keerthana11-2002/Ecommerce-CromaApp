package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class LoginPage extends BasePage {
	Actions action;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.action = new Actions(driver);
	}

	@FindBy(className = "user-link")
	WebElement userIcon;

	@FindBy(xpath = "//span[text()='Login']")
	WebElement login;

	@FindBy(xpath = "//input[@placeholder='Enter your Email ID or phone number']")
	WebElement email;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement button;

	@FindBy(id = "partitioned")
	WebElement OTP;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//span[text()='Logout']")
	WebElement logout;

	public void userIconButton() {
		action.moveToElement(userIcon).perform();
	}

	public void loginButton() {
		login.click();
	}

	public void enterEmail(String mail) {
		email.sendKeys(mail);
	}

	public void continueButton() {
		button.click();
	}

	public void setOTP(String otp) {
		OTP.sendKeys(otp);
	}

	public void submitButton() {
		submit.click();
	}

	public boolean verifyUser() {
		action.moveToElement(userIcon).perform();
		return logout.isDisplayed();

	}

}
