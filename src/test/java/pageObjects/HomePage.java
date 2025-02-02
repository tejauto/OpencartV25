package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  extends BasePage{
	
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement inkMyaxxount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement inkRegister;
	
	@FindBy(linkText="Login")  
	WebElement inklogin;
	
	
	public void clickMyAccount()
	{
		inkMyaxxount.click();
	}
	
	public void clickRegister()
	{
		inkRegister.click();
	}
	
	public void clickLogin()
	{
		inklogin.click();
	}
	

}
