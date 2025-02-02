package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*data is valid - login scucess -> tes pass -> logout
 * data is valid -> login failed -> test fail
 * 
 * data is invalid -> login sucess -> test fail -> logout 
 * data is invalid -> login failed -> test pass
 */

public class TC03_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven") // getting data data provide from different pacjage
	public void verify_loginDDt(String email, String pwd)
	{
		
		
		  logger.info("*****Starting tc_003_loginDDt***");   //homepage
		  
			  
			HomePage hp = new HomePage(driver);
				
				hp.clickMyAccount();
				hp.clickLogin();
				
				
				//login
				LoginPage lp=new LoginPage(driver);
				lp.setEmail(email);
				lp.setPassword(pwd);
				lp.clickLogin();
				
				
				//myaccount
				
				MyAccountPage mac = new MyAccountPage(driver);
				boolean targetpage = mac.isMyAccountPageExists();
				 mac.clickLogout();
				




              logger.info("*****finished tc_003_loginDDt"); 
	}

}
