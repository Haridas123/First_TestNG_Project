package resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;

	// this method return WebDriver object
	public WebDriver driverInitialization() throws IOException {

		// FileInputStream Read the file this--> data.properties
		// [C:\Users\Admin\eclipse-workspace\E2ETestNGFramework\src\main\java\Resources\data.properties]

		// data.properties file path given to FileInputStream
		// C:\Users\Admin\eclipse-workspace\ProjectFrameWork\src\main\java\resource\data.properties3

		// fis = new
		// FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\ProjectFrameWork\\src\\main\\java\\resource\\data.properties2");

		// this line take user file directory path automatically.here we have not
		// mentioned path like Above method
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resource\\data.properties2");
		// fis2 = new
		// FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\data.properties3");
		// this line Access file --> data.properties [data.properties is project file]
		prop = new Properties();
		// prop2 = new Properties();
		// if we remove Above line. we will get Below Error

		/*
		 * FAILED: loginVerification("test1", "secure123")
		 * java.lang.NullPointerException at
		 * resource.BaseClass.driverInitialization(BaseClass.java:34) at
		 * MyTestCases.VerifyLoginPage.loginVerification(VerifyLoginPage.java:23)
		 */

		prop.load(fis);
		// prop2.load(fis2);
		String browserName = prop.getProperty("browser");
		String url2 = prop.getProperty("URL");
		String note = prop.getProperty("Imporatant_Note");
		
		// String browserURL = prop2.getProperty("url");
		
		System.out.println("browser name -->" + browserName + " URL--> " + url2 + "  note-->" + note);//optional line
		 

		if (browserName.equalsIgnoreCase("chrome")) {
			
			// System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_103_version\\chromedriver.exe");
			

			WebDriverManager.chromedriver().setup(); // this and Above line open current
			// Browser

			// WebDriverManager.chromedriver().browserVersion("79.0.9").setup();//this will
			// open specified Browser like "79.0.9"

			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			// Microsoft Edge code E:\edgeDriver
			System.setProperty("webdriver.edge.driver", "E:\\edgeDriver\\edge.exe");
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("fireFox")) {
			// fireFox code here.same like above chrome browser
		}

		else {
			System.out.println("please enter valid browser name");
		}

		return driver; // this line returning webDriver as an Object
	}

	@BeforeMethod
	public void launchBrowser() throws IOException {
		driver = driverInitialization();
		driver.get(prop.getProperty("URL"));
	}

	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
}
