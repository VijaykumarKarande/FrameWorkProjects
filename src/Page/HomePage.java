package Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Generic.BaseTest;

public class HomePage extends BaseTest {

	@FindBy(xpath = "//td[@class='headertext' and @align='left']")
	private WebElement headerText;

	@FindBy(xpath = "//select[@name='search_target']")
	private WebElement dropBox;

	@FindBy(xpath = "//a[contains(@title,'Contacts')]")
	private WebElement contact;

	@FindBy(xpath = "//a[contains(@title,'Tasks')]")
	private WebElement tasks;
	
	@FindBy(xpath = "//a[contains(@title,'New Contact')]")
	private WebElement newContact;
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void verifyUserName(){
		headerText.isDisplayed();
	}
	public void selectFromList(String name){
		Select select=new Select(dropBox);
		select.selectByVisibleText(name);
	}
	public void clickContact(){
		contact.sendKeys(Keys.ENTER);
	}
	public void clickTask(){
		tasks.sendKeys(Keys.ENTER);
	}
	public void clickNewContact(){
		Actions action=new Actions(driver);
		action.moveToElement(contact).perform();
		newContact.sendKeys(Keys.ENTER);
	}

}
