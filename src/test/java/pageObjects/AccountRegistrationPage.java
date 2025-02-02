package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirst;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlast;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtPhone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPwd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txPwdconf;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdpolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btncont;
	
	@FindBy(xpath= "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfir;
	
	
	public void setFirstname(String fname) {
		txtfirst.sendKeys(fname);
	}
	
	public void setLastname(String fname) {
		txtlast.sendKeys(fname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		txtPhone.sendKeys(tel);
	}
	
	public void setPassword(String pwd) {
		txtPwd.sendKeys(pwd);
	}
	
	public void setconfirmPassword(String pwd) {
		txPwdconf.sendKeys(pwd);
	}
	
	public void setPrivacypolicy() {
		chkdpolicy.click();
	}
		
	public void clickContinue() {
		btncont.click();
		
		//sol2
		//btncont.submit();
		
		//sol3
		//Actions act = new Actions(driver);
		//act.moveToElement(btncont).click().perform();
		
		//sol4
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btncont);
	}
	
	public String getConfirmationmsg() {
		try {
			return (msgConfir.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
	
	
	
	

}

