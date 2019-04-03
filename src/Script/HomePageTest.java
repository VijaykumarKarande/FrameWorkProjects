package Script;

import org.testng.annotations.Test;

import Generic.BaseTest;
import Generic.FwUtil;
import Page.HomePage;
import Page.LoginPage;

public class HomePageTest extends BaseTest {
	
	

	@Test(priority=1)
	public void userNameVerify(){
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login("vijay123", "Vijay_123");
		HomePage homepage=new HomePage(driver);
		FwUtil fw=new FwUtil();
		fw.switchToFrame();
		homepage.verifyUserName();
	}
	@Test(priority=2)
	public void select(){
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login("vijay123", "Vijay_123");
		HomePage homepage=new HomePage(driver);
		FwUtil fw=new FwUtil();
		fw.switchToFrame();
		homepage.selectFromList("Web");
	}
	@Test(priority=3)
	public void clickContacts(){
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login("vijay123", "Vijay_123");
		HomePage homepage=new HomePage(driver);
		FwUtil fw=new FwUtil();
		fw.switchToFrame();
		homepage.clickContact();
	}
	@Test(priority=4)
	public void clickOnNewContact(){
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login("vijay123", "Vijay_123");
		HomePage homepage=new HomePage(driver);
		FwUtil fw=new FwUtil();
		fw.switchToFrame();
		homepage.clickNewContact();
	}
}
