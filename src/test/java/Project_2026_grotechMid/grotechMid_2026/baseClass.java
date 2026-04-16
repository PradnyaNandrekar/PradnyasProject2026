package Project_2026_grotechMid.grotechMid_2026;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.chrome.ChromeOptions;

public class baseClass 
{
	static String browserName;
	public static WebDriver driver;
	
	@BeforeMethod
	@Parameters("browserName")
	public static WebDriver launch(String browserName)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
//			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		driver.get("https://grotechminds.com/automate-me/");
		return driver;
	}
	
//	@AfterMethod
	public void quit()
	{
		driver.quit();
	}
	

}
