package rahulsheetyacademy.testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulshettyacaddemy.ExtentReport;

//import org.testng.ITestListener;

public class Listners  extends base implements ITestListener{
	ExtentReports extent=ExtentReport.configs();
	ExtentTest test;
	ThreadLocal<ExtentTest> threadlocal=new ThreadLocal<ExtentTest>();
	//@Override
	public void OnTestStart(ITestResult result)
	{
		test=extent.createTest(result.getMethod().getMethodName());
		threadlocal.set(test);
	}
	public void onTestSucess(ITestResult result)
	{
    test.log(Status.PASS,"test passed");
    }
	public void onTestFailure(ITestResult result)
	{
		
    test.log(Status.FAIL,"test failed");
    threadlocal.get().fail(result.getThrowable());
    //test.fail(result.getThrowable());

   try {
	driver= (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
} catch (IllegalArgumentException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IllegalAccessException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (NoSuchFieldException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SecurityException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
    String screenshot=null;
    try {
		 screenshot= getScreenshot(result.getMethod().getMethodName(),driver);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    threadlocal.get().addScreenCaptureFromPath(screenshot, result.getMethod().getMethodName());
    }
	public void onStart(ITestContext context)
	{
		
	}
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
	
}

