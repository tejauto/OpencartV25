package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;   // log4j
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"browser"})
	public void setup(String br) throws InterruptedException, IOException
	{
		    // loading confifg propeties
		  FileReader file = new FileReader("./src//test//resources//config.properties");
		  p=new Properties();
		  p.load(file);
		
		  logger = LogManager.getLogger(this.getClass());  // to get present class 
		  
          switch(br.toLowerCase())
          {
          case "chrome" : driver=new ChromeDriver();break;
          case "edge" : driver=new EdgeDriver(); break;
          default : System.out.println("invalid browser"); return;
          }
		  
         driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 

          driver.get(p.getProperty("appUrl"));   // url  // reading url from property file 
          driver.manage().window().maximize();
          Thread.sleep(4000);
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public String randomeString()
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
	}
	
	public String captureScreen(String tname) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourcefile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + 	timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		
		sourcefile.renameTo(targetFile);
		
		return targetFilePath;
	}

}
