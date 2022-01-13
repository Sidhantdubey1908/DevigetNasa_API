package DevigetAPI_Automation.DevigetAPI_Automation;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		String browser=getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		
		return driver;
	}
	
	public static String getProperty(String strProp) {
	String strValue = "";
	try {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "/Global.properties");
		prop.load(file);

		strValue = prop.getProperty(strProp);
	} catch (Exception e) {

	}

	return strValue;
}
	
	public static void getScreenShot(Scenario scenario) {

		// File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		// FileUtils.copyFile(screenshot, new File("target\\screenshots\\src.png"));

		scenario.attach(screenshot, "image/png", "ss");
	}
}
