package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_AccountRegistration extends BaseClass {
	
	/*public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		
         driver = new ChromeDriver();  
		  
         driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 

        driver.get("https://tutorialsninja.com/demo/");   // url
          driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}*/
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info(" ********** starting the application   ?***");
		
		try {
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		
		logger.info("click on my account link");
		
		hp.clickRegister();
		
		AccountRegistrationPage repage = new AccountRegistrationPage(driver);
		
		repage.setFirstname("tejesh");   // we can use for first name and last name also. 
		repage.setLastname(randomeString().toUpperCase());
		repage.setEmail(randomeString()+"@gmail.com");    // random genearting email 
		
		repage.setTelephone(randomeNumber());
		
		String password = randomeAlphaNumeric();
		
		repage.setPassword(password);
		repage.setconfirmPassword(password);
		
		repage.setPrivacypolicy();
		repage.clickContinue();
		
		String confmsg = repage.getConfirmationmsg();
		
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		}
	
	catch(Exception e)	
	{
		logger.error("test failed");
		Assert.fail();
	}
	}
	
	
	
	
	
	/*public String randomeString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomeNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public String randomeAlphaNumeric()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedstring+"#"+generatednumber);
	}*/
}
