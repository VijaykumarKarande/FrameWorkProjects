package Page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic.BaseTest;

public class LoginPage extends BaseTest {

	@FindBy(name = "username")
	private WebElement Username;

	@FindBy(name = "password")
	private WebElement Password;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement LoginBtn;

	@FindBy(xpath = "//a[text()='Sign Up']")
	private WebElement SignUpBtn;

	@FindBy(xpath = "//input[@name='first_name']")
	private WebElement firstName;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickSignUp() {
		SignUpBtn.sendKeys(Keys.ENTER);
		;
		firstName.isDisplayed();
	}

	public void login(String un, String pw) {
		Username.sendKeys(un);
		Password.sendKeys(pw);
		LoginBtn.sendKeys(Keys.ENTER);

	}
}
