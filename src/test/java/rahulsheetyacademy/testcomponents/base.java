package rahulsheetyacademy.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//import net.bytebuddy.jar.asm.TypeReference;
//import rahulheetyacademyJson.ObjectMapper;
import rahulshetty.Framework.Landingpage;

public class base {
	//public static WebDriver driver;
	public WebDriver driver;
    public Landingpage landing;
 public  WebDriver intalizeDriver() throws IOException
 
 {
	 
	 Properties prop=new Properties();
	 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//GlobalData.properties");
     prop.load(fis);
     String browser=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
     if(browser.contains("Chrome"))
     { ChromeOptions options=new ChromeOptions();
    	 if(browser.contains("headless"))
     {
    	
    	 options.addArguments("headless");
     }
    	  driver=new ChromeDriver(options);
    	  driver.manage().window().setSize(new Dimension(1440,900));//it is full screen mode 
    	  //full screen mode is differeeent from maximize mode
    	  
     }
     else if(browser=="edge") {
    	 driver=new EdgeDriver();
     }
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     driver.manage().window().maximize();
     return driver;
     }
 public String getScreenshot(String testcaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		File des=new File(System.getProperty("user.dir")+"//reports"+testcaseName+".png");
		FileUtils.copyFile(Source,des);
		return System.getProperty("user.dir")+"//reports"+testcaseName+".png";
	}
 public List<HashMap<String, String>> getDatafromJson(String filePath) throws IOException
	{
		String file=FileUtils.readFileToString(new File(filePath));
		
		//jackson databind
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> list =mapper.readValue(file, new TypeReference<List<HashMap<String, String>>>(){
			
		});
	return list;
	}
 @BeforeMethod(alwaysRun=true)
 public Landingpage launchApplication() throws IOException
 { 
  driver=intalizeDriver();
 landing=new Landingpage(driver);
 landing.goTO();
 return landing;
 //landing.signup("roopasree@gmail.com", "Roopasree@00");
 }
@AfterMethod(alwaysRun=true)
public void Exit()
{driver.close();
	
}


}
