package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkreporter;   // UI of the report 
	
    public ExtentReports extent;    // populate common information on the report like tester name . browser name etc. 
    
    public ExtentTest test; 
    
    String repName;
    
    public void onStart(ITestContext testcontext) {
    	
    	
    	
    	String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	
    	repName="Test-Report-" +timestamp +".html";
    	
    	 sparkreporter = new ExtentSparkReporter(".\\reports\\"+ repName);
    	
    	 sparkreporter.config().setDocumentTitle("Opencart Automation report");
   	     sparkreporter.config().setReportName("Functional testing");  // name of the report 
   	     sparkreporter.config().setTheme(Theme.DARK);
   	 
   	      extent = new ExtentReports();
   	 
   	      extent.attachReporter(sparkreporter);
   	 
   	      extent.setSystemInfo("Application", "opencart");
   	 
   	      extent.setSystemInfo("Environment", "QA");
   	 
   	      extent.setSystemInfo("Tester Name ", "tejesh");
   	 
   	      extent.setSystemInfo("os ", "windows10");
   	 
   	      extent.setSystemInfo("Browser name ", "chrome");
    	
    }
    
    public void onTestSuccess(ITestResult result) {
   	 
   	 test= extent.createTest(result.getTestClass().getName());    // create a new entry in the report
   	 test.assignCategory(result.getMethod().getGroups());
   	 
   	 test.log(Status.PASS, result.getName()+"got scucessfully executed");  // update status 
   	 
   	 
   	 
    }
    
    public void onTestFailure(ITestResult result) {
    	test=extent.createTest(result.getTestClass().getName());
    	test.assignCategory(result.getMethod().getGroups());
    	
    	test.log(Status.FAIL,result.getName()+" got failed");
    	test.log(Status.INFO,result.getThrowable().getMessage());
    	
    	try {
    		String imgPath= new BaseClass().captureScreen(result.getName());
    		test.addScreenCaptureFromPath(imgPath);
    	} catch(IOException e1) {
    		e1.printStackTrace();
    	}
    	
    	
    }
    
    public void onTestSkipped(ITestResult result) {
    	test=extent.createTest(result.getTestClass().getName());
    	test.assignCategory(result.getMethod().getGroups());
    	
    	test.log(Status.SKIP, result.getName()+ "got skipped");
    	test.log(Status.INFO,result.getThrowable().getMessage());
    }
    
    public void onFinish(ITestContext testContext) {
    	extent.flush();
    	
    	String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;   // automatic it will open
    	File extentReport = new File(pathOfExtentReport);
    	
    	try {
    		Desktop.getDesktop().browse(extentReport.toURI());
    		
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    

}
