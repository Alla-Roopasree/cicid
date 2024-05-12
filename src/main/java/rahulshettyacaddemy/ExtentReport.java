package rahulshettyacaddemy;

//simport org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	//static ExtentReports reports;

	public static ExtentReports configs()
	{
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	//will create the file index.html
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Extend Reports");
		reporter.config().setReportName("test reports");		
		ExtentReports reports =new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Testcase", "rahul");	
		reports.createTest(path);
		return reports;
	}
}