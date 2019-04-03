package Script;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.BaseTest;
import Page.LoginPage;

public class LoginPageTest extends BaseTest {

	@Test(priority=1)
	public void signUp(){
		LoginPage loginpage=new LoginPage(driver);
		loginpage.clickSignUp();
	}
	
	@Test(priority=2)
	public void loginApp(){
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login("vijay123", "Vijay_123");
	}
}
